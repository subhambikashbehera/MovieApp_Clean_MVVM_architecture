package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.artist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.subhambnikash.movieappcleanmvvmarchitecture.R
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.databinding.LayoutItemBinding

class ArtistAdapter: RecyclerView.Adapter<ArtistAdapter.MyViewHolder>() {

    val movieList= arrayListOf<Artist>()
    fun setList(movieNewList: List<Artist>){
        movieList.clear()
        movieList.addAll(movieNewList)
    }


   inner class MyViewHolder(private val itemBinding: LayoutItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
       fun bind(movie: Artist) {
           val url="https://image.tmdb.org/t/p/original/"+movie.profile_path
           itemBinding.description.text=movie.name
          // itemBinding.tittle.text=movie.name
           Glide.with(itemBinding.imageView.context)
               .load(url)
               .into(itemBinding.imageView)
           Log.d("checkUserData", "setPopularMovieList: $url")
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:LayoutItemBinding=DataBindingUtil.inflate(layoutInflater, R.layout.layout_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
       return movieList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }



}