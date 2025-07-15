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
import com.example.presentation.ui.CourseAdapter


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private val adapter = CourseAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.courses_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.courses.observe(viewLifecycleOwner) { courses ->
            adapter.submitList(courses)
        }

        // Загружаем курсы
        viewModel.loadCourses()

        // Реализация сортировки по publishDate по клику на сортировку (например, TextView с id sortTextView)
        val sortTextView = view.findViewById<TextView>(R.id.sort_textview)
        sortTextView.setOnClickListener {
            viewModel.sortByPublishDateDesc()
        }
    }
}

