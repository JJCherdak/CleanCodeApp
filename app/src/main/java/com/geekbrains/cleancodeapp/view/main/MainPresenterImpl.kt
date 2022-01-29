package com.geekbrains.cleancodeapp.view.main

//import com.geekbrains.cleancodeapp.model.data.AppState
//import com.geekbrains.cleancodeapp.model.datasource.DataSourceLocal
//import com.geekbrains.cleancodeapp.model.datasource.DataSourceRemote
//import com.geekbrains.cleancodeapp.model.repository.RepositoryImplementation
//import com.geekbrains.cleancodeapp.presenter.Presenter
//import com.geekbrains.cleancodeapp.rx.SchedulerProvider
//import com.geekbrains.cleancodeapp.view.base.View
//import io.reactivex.rxjava3.disposables.CompositeDisposable
//import io.reactivex.rxjava3.observers.DisposableObserver
//
//class MainPresenterImpl<T : AppState, V : View>(
//    private val interactor: MainInteractor = MainInteractor(
//        RepositoryImplementation(DataSourceRemote()),
//        RepositoryImplementation(DataSourceLocal())
//    ),
//    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
//    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
//) : Presenter<T, V> {
//    private var currentView: V? = null
//    override fun attachView(view: V) {
//        if (view != currentView) {
//            currentView = view
//        }
//    }
//    override fun detachView(view: V) {
//        compositeDisposable.clear()
//        if (view == currentView) {
//            currentView = null
//        }
//    }
//    override fun getData(word: String, isOnline: Boolean) {
//        compositeDisposable.add(
//            interactor.getData(word, isOnline)
//                .subscribeOn(schedulerProvider.io())
//                .observeOn(schedulerProvider.ui())
//                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
//                .subscribeWith(getObserver())
//        )
//    }
//
//    private fun getObserver(): DisposableObserver<AppState> {
//        return object : DisposableObserver<AppState>() {
//
//            override fun onNext(appState: AppState) {
//                currentView?.renderData(appState)
//            }
//
//            override fun onError(e: Throwable) {
//                currentView?.renderData(AppState.Error(e))
//            }
//
//            override fun onComplete() {
//            }
//        }
//    }
//}
//
