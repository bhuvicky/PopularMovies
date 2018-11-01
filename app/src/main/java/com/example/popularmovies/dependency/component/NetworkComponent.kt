package com.example.popularmovies.dependency.component

import com.example.popularmovies.datasource.MovieDataSource
import com.example.popularmovies.dependency.module.NetworkModule
import com.example.popularmovies.dependency.scope.MovieScope
import dagger.Component

@MovieScope
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(dataSource: MovieDataSource)
}