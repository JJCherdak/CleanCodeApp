package com.geekbrains.cleancodeapp.model.dataSource

import io.reactivex.rxjava3.core.Observable

interface DataSource <T> {
    fun getData(word: String): Observable<T>
}