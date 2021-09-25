package com.example.newmoviesplayground.api

import com.example.newmoviesplayground.model.Movie
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieService {

    @GET("shows")
    fun getNewMovies(): Single<List<Movie>>
}