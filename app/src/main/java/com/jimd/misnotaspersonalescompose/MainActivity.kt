package com.jimd.misnotaspersonalescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jimd.misnotaspersonalescompose.navegation.NavegationManager
import com.jimd.misnotaspersonalescompose.navegation.mainNavegation
import com.jimd.misnotaspersonalescompose.ui.theme.MisNotasPersonalesComposeTheme
import com.jimd.misnotaspersonalescompose.view.NotasHome
import com.jimd.misnotaspersonalescompose.view.NotasHomeViewModel
import com.jimd.misnotaspersonalescompose.view.NotasNews
import com.jimd.misnotaspersonalescompose.view.NotasUpdate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MisNotasPersonalesComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    mainNavegation(navController = navController)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MisNotasPersonalesComposeTheme {
    }
}