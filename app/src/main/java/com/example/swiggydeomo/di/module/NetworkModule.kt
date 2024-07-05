package com.example.swiggydeomo.di.module

import com.example.swiggydeomo.data.network.ApiService
import com.example.swiggydeomo.data.network.RetrofitInstance
import com.example.swiggydeomo.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit = RetrofitInstance.retrofitInstance

    @Singleton
    @Provides
    fun provideApiService() : ApiService = RetrofitInstance.apiService

    @Singleton
    @Provides
    fun provideMovieRepo(apiService: ApiService) = MovieRepository(apiService)
}