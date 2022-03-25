package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.subhambnikash.movieappcleanmvvmarchitecture.R
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.databinding.LayoutItemBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    val movieList= arrayListOf<TvShow>()
    fun setList(movieNewList: List<TvShow>){
        movieList.clear()
        movieList.addAll(movieNewList)
    }


   inner class MyViewHolder(private val itemBinding: LayoutItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
       fun bind(movie: TvShow) {
           val url="https://image.tmdb.org/t/p/original/"+movie.poster_path
           itemBinding.description.text=movie.overview
           itemBinding.tittle.text=movie.name
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