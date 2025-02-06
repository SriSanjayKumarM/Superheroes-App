package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.model.HeroesRepository.heroes
import com.example.superheroesapp.ui.theme.HeroList
import com.example.superheroesapp.ui.theme.HeroTopAppBar
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppMain()
                }
            }
        }
    }
}

@Composable
fun AppMain() {
    Scaffold(
        topBar = {
            HeroTopAppBar()
        } // Adds the top app bar
    ) { innerPadding ->
        HeroList(
            heroes = heroes,
            contentPadding = innerPadding
            // Ensures content doesn't overlap
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesAppTheme(darkTheme = false) {
        AppMain()
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingDarkThemePreview() {
    SuperheroesAppTheme(darkTheme = true) {
        AppMain()
    }
}
