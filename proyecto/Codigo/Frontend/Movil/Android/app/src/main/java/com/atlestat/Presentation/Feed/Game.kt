package com.atlestat.Presentation.Feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.atlestat.R

@Composable
fun Game (){
    LazyColumn(
        modifier=Modifier.fillMaxSize()
    ) {item{
        Image(painter = painterResource(id = R.drawable.game_footage), contentDescription = null, contentScale = ContentScale.FillWidth,modifier=Modifier.fillMaxWidth())

    }
    }
}