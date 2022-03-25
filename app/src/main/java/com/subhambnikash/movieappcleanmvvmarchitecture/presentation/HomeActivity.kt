package com.subhambnikash.movieappcleanmvvmarchitecture.presentation

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.subhambnikash.movieappcleanmvvmarchitecture.R
import com.subhambnikash.movieappcleanmvvmarchitecture.databinding.ActivityHomeBinding
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.artist.ArtistActivity
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie.MovieActivity
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow.TvShowActivity
import kotlin.properties.Delegates

class HomeActivity : AppCompatActivity() {

    var flag by Delegates.notNull<Int>()
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)
        setSupportActionBar(binding.toolBar)

        flag=  this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK



    }

    fun onClick(view: View) {
        when(view.id){
            binding.artist.id -> { startActivity(Intent(this,ArtistActivity::class.java)) }
            binding.movie.id -> { startActivity(Intent(this,MovieActivity::class.java)) }
            binding.tvShows.id -> { startActivity(Intent(this,TvShowActivity::class.java)) }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.dark_white_mode,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when(item.itemId){
            R.id.darkWhite->{
                when(flag){
                    Configuration.UI_MODE_NIGHT_YES->{AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)}
                    Configuration.UI_MODE_NIGHT_NO->{AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)}
                    Configuration.UI_MODE_NIGHT_UNDEFINED->{AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)}
                }
                true
             }
           else -> {return super.onOptionsItemSelected(item)}
       }
    }



}