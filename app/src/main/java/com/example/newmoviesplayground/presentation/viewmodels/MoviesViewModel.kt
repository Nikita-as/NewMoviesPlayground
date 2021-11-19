package com.example.newmoviesplayground.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newmoviesplayground.domain.model.Movie
import com.example.newmoviesplayground.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _newMovies = MutableLiveData<List<Movie>>()
    val newMovies: LiveData<List<Movie>> = _newMovies

    init {
        movieRepository.getNewMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movies -> _newMovies.value = movies }, { t -> Timber.e(t) })
    }

}