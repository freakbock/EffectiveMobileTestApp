package com.example.data.model

import java.util.Date

data class CourseDto(
    val id: String,
    val title: String,
    val text: String,
    val price: String, // ← изменили
    val rate: Float,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
)

