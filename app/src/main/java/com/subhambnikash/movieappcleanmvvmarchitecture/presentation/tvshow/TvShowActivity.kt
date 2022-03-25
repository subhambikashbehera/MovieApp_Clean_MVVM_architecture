package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow

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
import com.subhambnikash.movieappcleanmvvmarchitecture.databinding.ActivityTvShowBinding
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.Injector
import javax.inject.Inject


class TvShowActivity : AppCompatActivity() {

    lateinit var tvShowsAdapter: TvShowAdapter
    lateinit var binding: ActivityTvShowBinding

    @Inject
    lateinit var tvShowsActivityViewModelFactory: TvShowActivityViewModelFactory

    lateinit var tvShowActivityViewModel: TvShowActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)


        (application as Injector).createTvShowsSubComponent().inject(this)

        tvShowActivityViewModel = ViewModelProvider(
            this,
            tvShowsActivityViewModelFactory
        )[TvShowActivityViewModel::class.java]
        binding.viewModel = tvShowActivityViewModel
        binding.lifecycleOwner = this

        setSupportActionBar(binding.toolBar)
        initRecycler()
    }


    private fun initRecycler() {
        val manager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = manager
        tvShowsAdapter = TvShowAdapter()
        binding.recyclerView.adapter = tvShowsAdapter
        setPopularMovieList()
    }

    private fun setPopularMovieList() {
        binding.progressBar.visibility = View.VISIBLE
        tvShowActivityViewModel.getTvShoesUseCases().observe(this) {

            Log.d("checkData", "setPopularMovieList: $it")


            if (!it.isNullOrEmpty()) {
                it.let { it1 -> tvShowsAdapter.setList(it1) }
                tvShowsAdapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this, "loading Failed", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.update -> {
                updateMovie()
                true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateMovie() {
        binding.progressBar.visibility = View.VISIBLE
        tvShowActivityViewModel.updateTvShowsUseCases().observe(this) {

            Log.d("checkData", "setPopularMovieList: $it")


            if (!it.isNullOrEmpty()) {
                it.let { it1 -> tvShowsAdapter.setList(it1) }
                tvShowsAdapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this, "loading Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}