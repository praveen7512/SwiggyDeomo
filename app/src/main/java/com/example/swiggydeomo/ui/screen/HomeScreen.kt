package com.example.swiggydeomo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.swiggydeomo.ui.navigation.DetailScreenRoute
import com.example.swiggydeomo.ui.viewmodel.MovieViewModel


@Composable
fun HomeScreen(navController: NavController , movieViewModel: MovieViewModel = hiltViewModel()) {

    var searchQuery by remember {
        mutableStateOf("")
    }

    val savedStateHandle = SavedStateHandle()

    val movieData by movieViewModel.movieList.collectAsState()

    val list = movieData.Search


    Column(modifier = Modifier.padding(20.dp)) {

        TextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
            },
            label = { Text(text = "Enter your movie name here ") })


        Button(onClick = { savedStateHandle.set("moviequery" , searchQuery) }) {
            Text(text = "Search The Movie")
        }



        Spacer(modifier = Modifier.height(10.dp))


        LazyColumn(){
            items(list){
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                DetailScreenRoute(it.Title, it.Year, it.Poster, searchQuery)
                            )
                        }
                        .wrapContentSize(),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    val imageUrlResource = rememberAsyncImagePainter(model = it.Poster)
                    Image(
                        painter = imageUrlResource,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    )

                    Text(text = it.Title, style = MaterialTheme.typography.bodySmall, maxLines = 1)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = it.Title, style = MaterialTheme.typography.bodySmall, maxLines = 2)


                }
            }
        }
    }

}