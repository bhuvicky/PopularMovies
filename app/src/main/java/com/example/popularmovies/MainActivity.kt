package com.example.popularmovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.popularmovies.base.BaseActivity
import com.example.popularmovies.movies.movielist.MovieListFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replace(R.id.fragment_host, MovieListFragment.newInstance())
    }
}
