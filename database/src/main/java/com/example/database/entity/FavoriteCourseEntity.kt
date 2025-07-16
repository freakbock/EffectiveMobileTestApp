package com.example.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteCourseEntity(
    @PrimaryKey val courseId: String
)
