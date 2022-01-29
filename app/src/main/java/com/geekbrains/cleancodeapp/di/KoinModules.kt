package com.geekbrains.cleancodeapp.di

import com.geekbrains.cleancodeapp.model.data.DataModel
import com.geekbrains.cleancodeapp.model.datasource.RetrofitImplementation
import com.geekbrains.cleancodeapp.model.datasource.RoomDataBaseImplementation
import com.geekbrains.cleancodeapp.model.repository.Repository
import com.geekbrains.cleancodeapp.model.repository.RepositoryImplementation
import com.geekbrains.cleancodeapp.view.main.MainInteractor
import com.geekbrains.cleancodeapp.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation()
    ) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}