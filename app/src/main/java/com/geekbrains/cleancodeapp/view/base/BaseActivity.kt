package com.geekbrains.cleancodeapp.view.base



import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.cleancodeapp.model.data.AppState
import com.geekbrains.cleancodeapp.viewmodel.BaseViewModel

abstract class BaseActivity<T : AppState> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)
}
