// domain/model/Course.kt
package com.example.domain.model

import java.util.Date

data class Course(
    val id: String,
    val title: String,
    val text: String,
    val price: Double,
    val rate: Float,
    val startDate: Date,
    val hasLike: Boolean,
    val publishDate: Date
)
