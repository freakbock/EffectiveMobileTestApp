package com.example.data.mappers

import com.example.data.model.CourseDto
import com.example.domain.model.Course
import java.text.SimpleDateFormat
import java.util.*

object CourseMapper {
    private val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    fun fromDto(dto: CourseDto): Course {
        return Course(
            id = dto.id,
            title = dto.title,
            text = dto.text,
            price = dto.price.replace(" ", "").toDoubleOrNull() ?: 0.0,
            rate = dto.rate,
            startDate = parseDate(dto.startDate),
            hasLike = dto.hasLike,
            publishDate = parseDate(dto.publishDate)
        )
    }

    private fun parseDate(dateStr: String): Date {
        return try {
            formatter.parse(dateStr) ?: Date()
        } catch (e: Exception) {
            Date()
        }
    }
}
