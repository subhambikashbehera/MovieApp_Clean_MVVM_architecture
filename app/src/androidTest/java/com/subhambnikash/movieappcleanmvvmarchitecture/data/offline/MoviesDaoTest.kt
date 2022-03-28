package com.subhambnikash.movieappcleanmvvmarchitecture.data.offline
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var dao: MoviesDao
    private lateinit var dataBase: GetDataBaseInstance


    @Before
    fun setUp() {
        dataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            GetDataBaseInstance::class.java
        ).build()
        dao = dataBase.moviesDao()
    }
    @After
    fun tearDown() {
        dataBase.close()
    }


    @Test
    fun saveMoviesTest(): Unit = runBlocking{
        val movies = listOf(
            Movie(1,"overview1","posterPath1","date1","title1"),
            Movie(2,"overview2","posterPath2","date2","title2"),
            Movie(3,"overview3","posterPath3","date3","title3")
        )
        dao.saveMovie(movies)
        val allMovies = dao.getMovie()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }




    @Test
    fun delete(): Unit = runBlocking{
        val movies = listOf(
            Movie(1,"overview1","posterPath1","date1","title1"),
            Movie(2,"overview2","posterPath2","date2","title2"),
            Movie(3,"overview3","posterPath3","date3","title3")
        )
        dao.saveMovie(movies)
        dao.deleteMovie()
        val allMovies = dao.getMovie()
        Truth.assertThat(allMovies).isEmpty()
    }






}