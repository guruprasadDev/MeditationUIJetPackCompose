package com.example.meditationui

sealed class NavigationScreens(val route: String) {
    object Home : NavigationScreens(route = "home_screen")
    object Featured : NavigationScreens(route = "featured_screen")
}
