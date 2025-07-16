package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.entity.FavoriteCourseEntity

@Dao
interface CourseDao {
    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<FavoriteCourseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: FavoriteCourseEntity)

    @Query("DELETE FROM favorites WHERE courseId = :id")
    suspend fun remove(id: String)

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE courseId = :id)")
    suspend fun exists(id: String): Boolean
}
