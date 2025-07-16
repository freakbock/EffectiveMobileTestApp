package com.example.presentation.di

import com.example.presentation.ui.favorite.FavoriteViewModel
import com.example.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get())}
}
