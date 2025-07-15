// data/mappers/CourseMapper.kt
package com.example.data.mappers

import com.example.data.model.CourseDto
import com.example.domain.model.Course
import java.text.SimpleDateFormat
import java.util.*

object CourseMapper {
    private val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

    fun fromDto(dto: CourseDto): Course {
        return Course(
            id = dto.id,
            title = dto.title,
            text = dto.text,
            price = dto.price,
            rate = dto.rate,
            startDate = formatter.parse(dto.startDate) ?: Date(),
            hasLike = dto.hasLike,
            publishDate = formatter.parse(dto.publishDate) ?: Date()
        )
    }
}
