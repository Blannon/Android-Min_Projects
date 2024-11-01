package com.blannon_network.androidmin_projects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.blannon_network.androidmin_projects.tabs.project0.TabBarScreen
import com.blannon_network.androidmin_projects.tabs.project01.presentation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
           TabBarScreen()
           //MainScreen()

        }
    }
}

