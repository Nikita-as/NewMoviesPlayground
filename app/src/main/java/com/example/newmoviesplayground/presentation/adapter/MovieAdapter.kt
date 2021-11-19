package com.example.newmoviesplayground.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newmoviesplayground.R
import com.example.newmoviesplayground.domain.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

        private val movieList = mutableListOf<Movie>()

        inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
            return MovieViewHolder(view)
        }

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movieList[position]

            holder.itemView.apply {
                title_movie.text = movie.name
                image_movie.load(movie.image?.original){
                    crossfade(true)
                    crossfade(1000)
                }
                rating_movie.text = movie.rating?.average.toString()
            }
        }

        fun setNewList(newList: List<Movie>) {
            movieList.clear()
            movieList.addAll(newList)
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return movieList.size
        }
}