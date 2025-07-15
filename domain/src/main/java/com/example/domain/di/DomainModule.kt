package com.example.domain.di

import com.example.domain.usecase.GetCoursesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetCoursesUseCase(get()) }
}
