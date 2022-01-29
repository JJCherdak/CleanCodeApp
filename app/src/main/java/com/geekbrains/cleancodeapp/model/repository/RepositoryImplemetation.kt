package com.geekbrains.cleancodeapp.model.repository

import com.geekbrains.cleancodeapp.model.data.DataModel
import com.geekbrains.cleancodeapp.model.datasource.DataSource
import io.reactivex.rxjava3.core.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}