package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.CourseDao
import com.example.database.entity.FavoriteCourseEntity


@Database(
    entities = [FavoriteCourseEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}