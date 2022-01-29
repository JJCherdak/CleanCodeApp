package com.geekbrains.cleancodeapp.view.main

import com.geekbrains.cleancodeapp.model.data.AppState
import com.geekbrains.cleancodeapp.model.data.DataModel
import com.geekbrains.cleancodeapp.model.repository.Repository
import com.geekbrains.cleancodeapp.viewmodel.Interactor


class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource){
                remoteRepository
            } else{
                localRepository
            }.getData(word)
        )
    }
}