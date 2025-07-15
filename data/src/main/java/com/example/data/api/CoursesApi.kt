// data/api/CoursesApi.kt
package com.example.data.api

import retrofit2.http.GET
import com.example.data.model.CoursesResponse

interface CoursesApi {
    @GET("path/to/courses")  // подставь реальный путь
    suspend fun getCourses(): CoursesResponse
}
