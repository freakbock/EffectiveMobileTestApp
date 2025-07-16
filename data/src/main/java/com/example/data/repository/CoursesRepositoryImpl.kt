package com.example.data.repository

import com.example.data.api.CoursesApi
import com.example.data.mappers.CourseMapper
import com.example.database.dao.CourseDao
import com.example.database.entity.FavoriteCourseEntity
import com.example.domain.model.Course
import com.example.domain.repository.CoursesRepository

class CoursesRepositoryImpl(
    private val api: CoursesApi,
    private val dao: CourseDao
) : CoursesRepository {

    private val coursesUrl = "courses"

    override suspend fun getCourses(): List<Course> {
        val response = api.getCourses(coursesUrl)
        return response.courses.map { CourseMapper.fromDto(it) }
    }

    override suspend fun addFavorite(id: String) {
        dao.insert(FavoriteCourseEntity(id))
    }

    override suspend fun removeFavorite(id: String) {
        dao.remove(id)
    }

    override suspend fun getFavoriteCourses(): List<Course> {
        val favorites = dao.getAllFavorites().map { it.courseId }

        val response = api.getCourses(coursesUrl)
        val apiCourses = response.courses

        return apiCourses
            .filter { favorites.contains(it.id) }
            .map { dto -> CourseMapper.fromDto(dto).copy(hasLike = true) }
    }
}