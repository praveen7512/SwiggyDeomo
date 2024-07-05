package com.example.swiggydeomo.data.network

import com.example.swiggydeomo.data.model.Movie
import com.example.swiggydeomo.data.model.Search
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getMovieList(
        @Query("apikey") apiKey: String,
        @Query("s") searchQuery: String,
        @Query("page") pageNo: Int
    ): Movie
}