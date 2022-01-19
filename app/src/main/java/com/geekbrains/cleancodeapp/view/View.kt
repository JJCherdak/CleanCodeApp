package com.geekbrains.cleancodeapp.view

import com.geekbrains.cleancodeapp.model.data.AppState

interface View {
    fun renderData(appState: AppState)
}