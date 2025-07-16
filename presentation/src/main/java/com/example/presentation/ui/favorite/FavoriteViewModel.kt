package com.example.presentation.ui.favorite

import androidx.lifecycle.*
import com.example.domain.model.Course
import com.example.domain.repository.CoursesRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val repository: CoursesRepository
) : ViewModel() {

    private val _favoriteCourses = MutableLiveData<List<Course>>()
    val favoriteCourses: LiveData<List<Course>> = _favoriteCourses

    fun loadFavorites() {
        viewModelScope.launch {
            _favoriteCourses.value = repository.getFavoriteCourses()
        }
    }

    fun toggleFavorite(courseId: String) {
        viewModelScope.launch {
            repository.addFavorite(courseId)
            loadFavorites() // обновляем после клика
        }
    }
}
