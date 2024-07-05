package com.example.swiggydeomo.data.repository

import com.example.swiggydeomo.data.model.Movie
import com.example.swiggydeomo.data.model.Search
import com.example.swiggydeomo.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getMovieList(apiKey: String, searchQuery: String, pageNo: Int): Flow<Movie> =
        flow {
            emit(apiService.getMovieList(apiKey, searchQuery, pageNo))
        }
}