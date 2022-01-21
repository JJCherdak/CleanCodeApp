package com.geekbrains.cleancodeapp.view.base

import com.geekbrains.cleancodeapp.model.data.AppState

interface View {

    fun renderData(appState: AppState)
}