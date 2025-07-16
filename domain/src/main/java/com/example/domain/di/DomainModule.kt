package com.example.domain.di

import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.usecase.ToggleFavoriteUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { ToggleFavoriteUseCase(get()) }
}
