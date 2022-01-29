package com.geekbrains.cleancodeapp.application

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import com.geekbrains.cleancodeapp.di.DaggerAppComponent
import com.geekbrains.cleancodeapp.di.application
import com.geekbrains.cleancodeapp.di.mainScreen
import org.koin.core.context.startKoin

class TranslatorApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }


}