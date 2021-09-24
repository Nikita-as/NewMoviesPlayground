package com.example.newmoviesplayground.api

import com.example.newmoviesplayground.model.Movies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieService {

    @GET("shows")
    fun getNewMovies(): Single<Movies>
}