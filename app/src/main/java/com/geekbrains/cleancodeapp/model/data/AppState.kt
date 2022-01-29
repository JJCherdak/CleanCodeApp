package com.geekbrains.cleancodeapp.model.data

import io.reactivex.rxjava3.core.Observable

sealed class AppState{
    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}
