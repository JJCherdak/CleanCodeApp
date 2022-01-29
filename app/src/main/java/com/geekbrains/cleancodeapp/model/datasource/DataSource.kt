package com.geekbrains.cleancodeapp.model.datasource

import io.reactivex.rxjava3.core.Observable


interface DataSource <T> {
    suspend fun getData(word: String): T
}