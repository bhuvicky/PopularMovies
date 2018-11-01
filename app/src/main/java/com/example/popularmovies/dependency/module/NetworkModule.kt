package com.example.popularmovies.dependency.module

import com.example.popularmovies.Constant.Constant
import com.example.popularmovies.datasource.MovieOperation
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun retrofit(okHttp: OkHttpClient.Builder, interceptor: HttpLoggingInterceptor): Retrofit {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttp.addInterceptor(interceptor)

        return Retrofit.Builder()
                .baseUrl(Constant.NetworkUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build())
                .build()
    }

    @Provides
    fun movieOperation(retrofit: Retrofit): MovieOperation {
        return retrofit.create(MovieOperation::class.java)
    }

    @Provides
    fun createOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @Provides
    fun createLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }
}