package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.artist

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
import com.subhambnikash.movieappcleanmvvmarchitecture.databinding.ActivityArtistBinding
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.Injector
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie.MovieActivityViewModel
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie.MovieAdapter
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var artistActivityViewModelFactory: ArtistActivityViewModelFactory
    lateinit var artistActivityViewModel: ArtistActivityViewModel
    lateinit var artistAdapter: ArtistAdapter
    lateinit var binding:ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_artist)

        (application as Injector).createArtistSubComponent().inject(this)

        artistActivityViewModel= ViewModelProvider(this,artistActivityViewModelFactory)[ArtistActivityViewModel::class.java]
        binding.viewModel=artistActivityViewModel
        binding.lifecycleOwner=this

        setSupportActionBar(binding.toolBar)
        initRecycler()

    }


    private fun initRecycler(){
        val manager= LinearLayoutManager(this)
        binding.recyclerView.layoutManager=manager
        artistAdapter= ArtistAdapter()
        binding.recyclerView.adapter=artistAdapter
        setPopularMovieList()
    }

    private fun setPopularMovieList(){
        binding.progressBar.visibility= View.VISIBLE
        artistActivityViewModel.getArtistUseCases().observe(this){

            if (!it.isNullOrEmpty()){
                it.let { it1->  artistAdapter.setList(it1) }
                artistAdapter.notifyDataSetChanged()
                binding.progressBar.visibility= View.GONE
                Log.d("checkData", "updateArtistToCacheUi: $it")
            }else{
                binding.progressBar.visibility= View.GONE
                Toast.makeText(this,"loading Failed", Toast.LENGTH_SHORT).show()
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
        binding.progressBar.visibility= View.VISIBLE
        artistActivityViewModel.updateArtistUseCases().observe(this){
            if (!it.isNullOrEmpty()){
                it.let { it1->  artistAdapter.setList(it1) }
                artistAdapter.notifyDataSetChanged()
                binding.progressBar.visibility= View.GONE
            }else{
                binding.progressBar.visibility= View.GONE
                Toast.makeText(this,"loading Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}