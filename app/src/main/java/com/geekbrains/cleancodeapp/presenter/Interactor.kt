package com.geekbrains.cleancodeapp.presenter

import io.reactivex.rxjava3.core.Observable

interface Interactor<T> {
    fun getData(word: String): Observable<T>
}