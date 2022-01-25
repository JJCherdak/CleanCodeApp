package com.geekbrains.cleancodeapp.view.main

import androidx.lifecycle.LiveData
import com.geekbrains.cleancodeapp.model.data.AppState
import com.geekbrains.cleancodeapp.model.datasource.DataSourceLocal
import com.geekbrains.cleancodeapp.model.datasource.DataSourceRemote
import com.geekbrains.cleancodeapp.model.repository.RepositoryImplementation
import com.geekbrains.cleancodeapp.viewmodel.BaseViewModel
import io.reactivex.rxjava3.observers.DisposableObserver

class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    )
) : BaseViewModel<AppState>() {

    private var appState: AppState? = null

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { liveDataForViewToObserve.value = AppState.Loading(null) }
                .subscribeWith(getObserver())
        )
        return super.getData(word, isOnline)
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}
