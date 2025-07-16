package com.example.domain.usecase

import com.example.domain.repository.CoursesRepository

class ToggleFavoriteUseCase(private val repository: CoursesRepository) {
    suspend fun execute(courseId: String, isFavorite: Boolean) {
        if (isFavorite) {
            repository.removeFavorite(courseId)
        } else {
            repository.addFavorite(courseId)
        }
    }
}
