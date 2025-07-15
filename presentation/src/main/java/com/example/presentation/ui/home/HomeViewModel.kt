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

    fun loadCourses() {
        viewModelScope.launch {
            currentCourses = repository.getCourses()
            _courses.value = currentCourses
        }
    }

    fun sortByPublishDateDesc() {
        val sorted = currentCourses.sortedByDescending { it.publishDate }
        _courses.value = sorted
    }
}

