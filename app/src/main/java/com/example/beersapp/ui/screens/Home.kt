package com.example.beersapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beersapp.R
import com.example.beersapp.models.Beer
import com.example.beersapp.ui.viewmodels.BeersViewModel

@Composable
fun HomeScreen (viewModel: BeersViewModel) {
    Column (modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 20.dp)
        .fillMaxSize()
    ) {
        Header(viewModel, Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(8.dp))
        BeersContainer(viewModel)
    }
}

@Composable
fun Header (viewModel: BeersViewModel, modifier: Modifier) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Title()
        RefreshBtn(viewModel)
    }
}

@Composable
fun Title () {
    Text(
        text = "Random Beers",
        fontSize = 32.sp,
    )
}

@Composable
fun RefreshBtn (viewModel: BeersViewModel) {
    Button(
        onClick = { viewModel.onRefreshBeers() },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(Icons.Default.Refresh, contentDescription = "Actualizar cervezas")
    }
}

@Composable
fun BeersContainer (viewModel: BeersViewModel) {
    val beers : List<Beer> by viewModel.beers.observeAsState(initial = emptyList())

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 250.dp),
    ) {
        beers.forEach {
            item {
                BeerCard(it)
            }
        }
    }
}

@Composable
fun BeerCard (beer: Beer) {
    Card (
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp).clickable {  },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row (modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(
                id = R.drawable.beer),
                contentDescription = "Beer Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(5.dp)
                    .size(60.dp)
                    .clip(RoundedCornerShape(10))
            )
            Column (modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(text = beer.name, fontSize = 18.sp)
                Text(text = beer.brand, fontSize = 14.sp, fontWeight = FontWeight.Bold)

                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = beer.style, fontSize = 12.sp, fontStyle = FontStyle.Italic)
                    Text(text = beer.alcohol, fontSize = 12.sp)
                }
            }
        }
    }
}