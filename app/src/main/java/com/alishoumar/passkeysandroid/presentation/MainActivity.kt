package com.alishoumar.passkeysandroid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.alishoumar.passkeysandroid.presentation.navigation.Screen
import com.alishoumar.passkeysandroid.presentation.navigation.SetUpNavGraph
import com.alishoumar.passkeysandroid.presentation.ui.theme.PassKeysAndroidTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PassKeysAndroidTheme {
                val navController = rememberNavController()
                    SetUpNavGraph(startDestination = Screen.RootAuth.route,
                        navController = navController)
            }
        }
    }
}
