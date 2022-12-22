package com.example.meditationui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meditationui.ui.HomeScreen
import com.example.meditationui.ui.SleepMediationUi

@Composable
fun SetUpNavGraph(
    navController: NavHostController

) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.Home.route
    ) {
        composable(
            route = NavigationScreens.Featured.route
        ) {
            HomeScreen()
        }

        composable(
            route = NavigationScreens.Featured.route
        ) {
            SleepMediationUi()
        }
    }
}