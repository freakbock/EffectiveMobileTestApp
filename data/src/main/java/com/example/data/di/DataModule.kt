//package com.example.data.di
//
//import com.example.data.api.CoursesApi
//import com.example.data.repository.CoursesRepositoryImpl
//import com.example.domain.repository.CoursesRepository
//import org.koin.dsl.module
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//// data/di/DataModule.kt
//val dataModule = module {
//    single { provideRetrofit() }
//    single { get<Retrofit>().create(CoursesApi::class.java) }
//    single<CoursesRepository> { CoursesRepositoryImpl(get()) }
//}
//
//fun provideRetrofit(): Retrofit = Retrofit.Builder()
//    .baseUrl("https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&e\n" +
//            "xport=download")
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()

package com.example.data.di

import com.example.data.api.CoursesApi
import com.example.data.repository.CoursesRepositoryImpl
import com.example.domain.repository.CoursesRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&e\n" +
                    "xport=download")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<CoursesApi> {
        get<Retrofit>().create(CoursesApi::class.java)
    }

    single<CoursesRepository> {
        CoursesRepositoryImpl(get())
    }
}

