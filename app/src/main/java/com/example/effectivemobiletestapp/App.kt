package com.example.effectivemobiletestapp

import android.app.Application
import com.example.data.di.dataModule
import com.example.database.di.databaseModule
import com.example.domain.di.domainModule
import com.example.presentation.di.presentationModule
import networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                appModule, // App-level зависимости
                dataModule,
                domainModule,
                databaseModule,
                presentationModule,
                networkModule // Retrofit, etc.
            )
        }
    }
}
