package com.example.database.di

import androidx.room.Room
import android.app.Application
import com.example.database.AppDatabase
import com.example.database.dao.CourseDao
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get<Application>(),
            AppDatabase::class.java,
            "courses-db"
        ).build()
    }

    single<CourseDao> { get<AppDatabase>().courseDao() }
}
