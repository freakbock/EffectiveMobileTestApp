package com.example.presentation.ui.home

import CourseAdapter
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import org.koin.androidx.viewmodel.ext.android.viewModel



class HomeFragment : Fragment(R.layout.fragment_home) {


    private val viewModel: HomeViewModel by viewModel()

    private val adapter by lazy {
        CourseAdapter { course ->
            viewModel.toggleFavorite(course.id)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.courses_recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.courses.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        val sortTextView = view.findViewById<TextView>(R.id.sort_textview)
        sortTextView.setOnClickListener {
            viewModel.sortByPublishDateDesc()
        }

        viewModel.loadCourses()
    }
}

