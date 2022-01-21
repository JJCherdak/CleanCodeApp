package com.geekbrains.cleancodeapp.presenter

import com.geekbrains.cleancodeapp.model.data.AppState
import com.geekbrains.cleancodeapp.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData (word: String, isOnline: Boolean)
}