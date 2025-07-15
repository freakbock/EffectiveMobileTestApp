package com.example.effectivemobiletestapp

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    // Можно положить тут SharedPreferences или другие app-level зависимости
    single { androidContext().getSharedPreferences("prefs", Context.MODE_PRIVATE) }
}
