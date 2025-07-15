// data/repository/CoursesRepositoryImpl.kt
package com.example.data.repository

import com.example.data.api.CoursesApi
import com.example.data.mappers.CourseMapper
import com.example.domain.model.Course
import com.example.domain.repository.CoursesRepository

class CoursesRepositoryImpl(
    private val api: CoursesApi
) : CoursesRepository {
    override suspend fun getCourses(): List<Course> {
        val response = api.getCourses()
        return response.courses.map { CourseMapper.fromDto(it) }
    }
}
