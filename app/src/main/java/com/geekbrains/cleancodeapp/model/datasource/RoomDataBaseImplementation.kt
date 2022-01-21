package com.geekbrains.cleancodeapp.model.datasource

import com.geekbrains.cleancodeapp.model.data.DataModel
import io.reactivex.rxjava3.core.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented") // To change body of created functions use File
        // | Settings | File Templates.
    }
}