// data/model/CourseDto.kt
package com.example.data.model

import com.google.gson.annotations.SerializedName

data class CourseDto(
    val id: String,
    val title: String,
    val text: String,
    val price: Double,
    val rate: Float,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
)
