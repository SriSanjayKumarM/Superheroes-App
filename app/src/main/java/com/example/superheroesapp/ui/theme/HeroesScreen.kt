package com.example.superheroesapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun HeroList(heroes: List<Hero>) {
    LazyColumn {
        items(heroes) { it ->
            HeroListItem(it)
        }
    }
}

@Composable
fun HeroListItem(hero: Hero) {
    Card(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .height(dimensionResource(R.dimen.image_size))
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
                    .weight(1f)
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

