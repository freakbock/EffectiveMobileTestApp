// data/api/CoursesApi.kt
package com.example.data.api

import com.example.data.model.CourseDto
import retrofit2.http.GET
import com.example.data.model.CoursesResponse
import retrofit2.Response
import retrofit2.http.Url

interface CoursesApi {
    @GET
    suspend fun getCourses(@Url url: String): CoursesResponse
}

