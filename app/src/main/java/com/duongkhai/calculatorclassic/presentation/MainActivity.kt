package com.duongkhai.calculatorclassic.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.duongkhai.calculatorclassic.domain.navigation.Destination
import com.duongkhai.calculatorclassic.domain.navigation.NavHostNoteApp
import com.duongkhai.calculatorclassic.domain.navigation.composable
import com.duongkhai.calculatorclassic.presentation.ui.home.HomeScreen
import com.duongkhai.calculatorclassic.presentation.ui.theme.CalculatorClassicTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            val navController: NavHostController = rememberNavController()
            CalculatorClassicTheme {
                Scaffold(
                    contentWindowInsets = WindowInsets(0, 0, 0, 0)
                ) { scaffoldPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(scaffoldPadding)
                            .systemBarsPadding(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        SetupNavigation(navController = navController)
                    }
                }
            }
        }
    }


}

@Composable
private fun SetupNavigation(navController: NavHostController) {
    NavHostNoteApp(navController = navController, startDestination = Destination.HomeScreen) {
        composable(Destination.HomeScreen) { HomeScreen(navController) }
    }
}