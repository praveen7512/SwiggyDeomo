package com.example.swiggydeomo.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swiggydeomo.data.model.Movie
import com.example.swiggydeomo.data.model.Search
import com.example.swiggydeomo.data.repository.MovieRepository
import com.example.swiggydeomo.ui.navigation.DetailScreenRoute
import com.example.swiggydeomo.util.AppConstant
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movieList = MutableStateFlow<Movie>(Movie("", emptyList(), ""))
    val movieList: StateFlow<Movie> = _movieList

    init {
        viewModelScope.launch {
            val args = savedStateHandle.get<String>("moviequery")

            movieRepository.getMovieList(AppConstant.API_KEY , "hulk" , 1).collect{
                _movieList.value = it
            }

        }
    }


}