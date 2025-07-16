// presentation/ui/home/HomeViewModel.kt
package com.example.presentation.ui.home

import androidx.lifecycle.*
import com.example.domain.model.Course
import com.example.domain.repository.CoursesRepository
import com.example.domain.usecase.GetCoursesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CoursesRepository) : ViewModel() {

    private val _courses = MutableLiveData<List<Course>>()
    val courses: LiveData<List<Course>> = _courses

    private var currentCourses: List<Course> = emptyList()

    fun sortByPublishDateDesc() {
        val sorted = currentCourses.sortedByDescending { it.publishDate }
        _courses.value = sorted
    }

    fun toggleFavorite(courseId: String) {
        viewModelScope.launch {
            val currentList = _courses.value.orEmpty().toMutableList()
            val index = currentList.indexOfFirst { it.id == courseId }
            if (index != -1) {
                val course = currentList[index]
                val isFavorite = course.hasLike

                if (isFavorite) {
                    repository.removeFavorite(courseId)
                } else {
                    repository.addFavorite(courseId)
                }

                currentList[index] = course.copy(hasLike = !isFavorite)
                _courses.value = currentList
            }
        }
    }

    fun loadCourses() {
        viewModelScope.launch {
            val loaded = repository.getCourses()
            currentCourses = loaded // ← ЭТОГО НЕ ХВАТАЛО
            _courses.value = loaded
        }
    }

}

