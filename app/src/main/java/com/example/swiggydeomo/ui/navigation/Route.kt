package com.example.swiggydeomo.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Serializable
data class DetailScreenRoute(val movieName: String, val description: String, val imageUrl: String , val query : String)

@Serializable
object ErrorPage
