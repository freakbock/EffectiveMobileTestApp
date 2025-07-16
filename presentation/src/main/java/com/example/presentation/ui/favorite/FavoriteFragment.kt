package com.example.presentation.ui.favorite

import CourseAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val viewModel: FavoriteViewModel by viewModel()

    private val adapter by lazy {
        CourseAdapter { course ->
            viewModel.toggleFavorite(course.id)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.favorite_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.favoriteCourses.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.loadFavorites()
    }
}
