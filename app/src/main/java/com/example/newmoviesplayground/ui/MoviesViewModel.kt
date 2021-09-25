package com.example.newmoviesplayground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newmoviesplayground.model.Movie
import com.example.newmoviesplayground.model.Movies
import com.example.newmoviesplayground.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _newMovies = MutableLiveData<List<Movie>>()
    val newMovies: LiveData<List<Movie>>
        get() = _newMovies

    init {
        movieRepository.getNewMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movies -> _newMovies.value = movies }, { t -> Timber.e(t) })
    }

}