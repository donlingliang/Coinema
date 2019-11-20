package com.don.coinema

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.api.load

/**
 * Created by don on 2019-11-19
 */
class MoviesAdapter(var movies: List<Movie>) : androidx.recyclerview.widget.RecyclerView.Adapter<MoviesAdapter.MoiveViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoiveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoiveViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    override fun onBindViewHolder(holder: MoiveViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class MoiveViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        private val cover: ImageView = itemView.findViewById(R.id.item_movie_cover)

        fun bind(movie: Movie) {
            Log.e("FindMe:", Api.PHOTO_URL + movie.posterPath)
            cover.load(Api.PHOTO_URL + movie.posterPath)
        }
    }

    fun updateMoviesList(movies: List<Movie>?) {
        movies?.let {
            this.movies = movies
            notifyDataSetChanged()
        }
    }
}