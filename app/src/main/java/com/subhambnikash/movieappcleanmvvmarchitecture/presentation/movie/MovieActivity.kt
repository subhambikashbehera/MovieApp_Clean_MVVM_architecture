package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.subhambnikash.movieappcleanmvvmarchitecture.R
import com.subhambnikash.movieappcleanmvvmarchitecture.databinding.ActivityMovieBinding
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.GetMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var movieActivityViewModelFactory:MovieActivityViewModelFactory

    
    private lateinit var movieActivityViewModel: MovieActivityViewModel


    lateinit var movieAdapter: MovieAdapter
    lateinit var binding:ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_movie)
        
        (application as Injector).createMovieSubComponent().inject(this)

        movieActivityViewModel= ViewModelProvider(this,movieActivityViewModelFactory)[MovieActivityViewModel::class.java]
        binding.viewModel=movieActivityViewModel
        binding.lifecycleOwner=this

        setSupportActionBar(binding.toolBar)
        initRecycler()

    }

    private fun initRecycler(){
        val manager=LinearLayoutManager(this)
        binding.recyclerView.layoutManager=manager
        movieAdapter= MovieAdapter()
        binding.recyclerView.adapter=movieAdapter
        setPopularMovieList()
    }

    private fun setPopularMovieList(){
        binding.progressBar.visibility=View.VISIBLE
        movieActivityViewModel.getMoviesUseCases().observe(this){

            if (!it.isNullOrEmpty()){
                it.let { it1->  movieAdapter.setList(it1) }
                movieAdapter.notifyDataSetChanged()
                binding.progressBar.visibility=View.GONE
            }else{
                binding.progressBar.visibility=View.GONE
                Toast.makeText(this,"loading Failed",Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      return  when(item.itemId){
            R.id.update->{
                updateMovie()
                true
            }
            else ->{return super.onOptionsItemSelected(item)}
        }
    }

    private fun updateMovie(){
        binding.progressBar.visibility=View.VISIBLE
        movieActivityViewModel.updateMovieShows().observe(this){

            Log.d("checkData", "updateMovieToCacheUi: $it")

            if (!it.isNullOrEmpty()){
                it.let { it1->  movieAdapter.setList(it1) }
                movieAdapter.notifyDataSetChanged()
                binding.progressBar.visibility=View.GONE
            }else{
                binding.progressBar.visibility=View.GONE
                Toast.makeText(this,"loading Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}