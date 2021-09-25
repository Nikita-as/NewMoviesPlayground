package com.example.newmoviesplayground.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newmoviesplayground.R
import com.example.newmoviesplayground.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies.*

@AndroidEntryPoint
class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private val moviesViewModel: MoviesViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter = MovieAdapter()
        rvMovies.adapter = movieAdapter
        rvMovies.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onStart() {
        super.onStart()
        moviesViewModel.newMovies.observe(viewLifecycleOwner, {
            movieAdapter.setNewList(it)
        })
    }


}