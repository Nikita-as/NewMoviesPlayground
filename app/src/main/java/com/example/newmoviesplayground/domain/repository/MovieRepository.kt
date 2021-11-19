package com.example.newmoviesplayground.domain.repository

import com.example.newmoviesplayground.data.remote.MovieService
import com.example.newmoviesplayground.domain.model.Movie
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService
) {

    fun getNewMovies(): Single<List<Movie>> {
        return movieService.getNewMovies()
            .subscribeOn(Schedulers.io())
    }
}