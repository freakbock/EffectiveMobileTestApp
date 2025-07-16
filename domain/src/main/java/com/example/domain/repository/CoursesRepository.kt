// domain/repository/CoursesRepository.kt
package com.example.domain.repository

import com.example.domain.model.Course

interface CoursesRepository {
    suspend fun getCourses(): List<Course>
    suspend fun addFavorite(id: String)
    suspend fun removeFavorite(id: String)
    suspend fun getFavoriteCourses() : List<Course>
}
