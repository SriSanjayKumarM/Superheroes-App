package com.example.superheroesapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.R
import com.example.superheroesapp.model.Hero

@Composable
fun HeroList(
    heroes: List<Hero>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = Modifier,
        contentPadding = contentPadding
    ) {
        items(heroes) { hero ->
            HeroListItem(hero, Modifier.padding(vertical = 8.dp)) // Ensures spacing between cards
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name), // App name
                style = MaterialTheme.typography.displayLarge // DisplayLarge style
            )
        }
    )
}


@Composable
fun HeroListItem(hero: Hero, modifier: Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.image_size) + 32.dp) // Adjusted height for text visibility
            .clip(MaterialTheme.shapes.medium), // 16dp Clip radius
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // 2dp elevation
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            // Column for text
            Column(
                modifier = Modifier
                    .weight(1f) // Takes remaining space
                    .padding(end = dimensionResource(R.dimen.padding_medium)) // 16dp space
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            // Image on the right
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.image_size)) // 72dp size
                    .clip(MaterialTheme.shapes.small) // 8dp Clip radius
            )
        }
    }
}

