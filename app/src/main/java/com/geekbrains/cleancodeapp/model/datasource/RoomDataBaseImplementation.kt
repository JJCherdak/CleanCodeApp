package com.geekbrains.cleancodeapp.model.datasource

import com.geekbrains.cleancodeapp.model.data.DataModel
import io.reactivex.rxjava3.core.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") // To change body of created functions use File
        // | Settings | File Templates.
    }
}