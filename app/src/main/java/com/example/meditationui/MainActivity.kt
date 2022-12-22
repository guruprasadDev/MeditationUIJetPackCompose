package com.example.meditationui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import com.example.meditationui.ui.SleepMediationUi
import com.example.meditationui.ui.theme.MeditationUITheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUITheme {
                SleepMediationUi()
//                navController = rememberNavController()
//                SetUpNavGraph(navController = navController)
            }
        }
    }
}
