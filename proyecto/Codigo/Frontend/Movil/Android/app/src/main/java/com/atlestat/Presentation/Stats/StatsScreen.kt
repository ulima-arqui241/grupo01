package com.atlestat.Presentation.Stats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.atlestat.R
import com.atlestat.ui.theme.backgroundLightGray
import com.atlestat.ui.theme.darkMainColor
import com.atlestat.ui.theme.mainColor
import com.atlestat.ui.theme.selectionLightBlue

@Composable
fun StatsScreen(
    navController: NavController
){
    LazyColumn(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item{
            Image(painter = painterResource(id = R.drawable.stats_menu), contentDescription = null,modifier=Modifier.fillMaxWidth(0.9f), contentScale = ContentScale.FillWidth)
        }
        item{
            Column(
                modifier=Modifier.fillMaxWidth(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Partidos pasados",modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp), fontWeight = FontWeight.Bold)
                PastMatch()
            }
        }
    }
}

@Composable
private fun PastMatch(){
    Card {
        Box(
            modifier= Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.playing_img), contentDescription = "nextMatch",modifier=Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
            Column(
                modifier= Modifier
                    .fillMaxWidth()
                    .background(backgroundLightGray)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(
                    modifier= Modifier
                        .offset(y = -20.dp)
                        .background(Color(0xff37474F), RoundedCornerShape(20.dp))
                        .padding(20.dp)
                        .fillMaxWidth(0.8f),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("3", fontWeight = FontWeight.Bold,color= Color.White)
                        Text("Equipo A", fontWeight = FontWeight.Bold,color= Color.White)
                    }
                    Text("vs", fontStyle = FontStyle.Italic,color= Color.White,modifier=Modifier.padding(horizontal = 30.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("2", fontWeight = FontWeight.Normal,color= Color.White)
                        Text("Equipo B", fontWeight = FontWeight.Normal,color= Color.White)
                    }
                }
                Column(
                    modifier=Modifier.fillMaxWidth(0.9f)
                ){

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(id = R.drawable.football_ic), contentDescription = "football_logo",modifier=Modifier.size(20.dp))
                        Text("Partido de práctica")
                    }
                    Row(
                        modifier= Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Filled.DateRange, contentDescription = "date")
                            Text(text = "20/03/2024")
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(painterResource(id = R.drawable.baseline_access_time_24), contentDescription = "time")
                            Text(text = "90 min")
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(painterResource(id = R.drawable.baseline_people_24 ), contentDescription = "people")
                            Text(text = "11 jugadores")
                        }
                    }
                    Text("Rendimiento",fontWeight= FontWeight.Bold,modifier=Modifier.fillMaxWidth())
                    Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                        Row(
                            modifier=Modifier.background(selectionLightBlue, CircleShape),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(imageVector = Icons.Filled.Star, contentDescription = null,modifier=Modifier.padding(10.dp))
                            Text("7/10",modifier=Modifier.padding(10.dp))
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text("1.2 puntos sobre el promedio del equipo")
                    }
                    Row(
                        modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
                        Button(onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = mainColor
                            )) {
                            Text("Ver más", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
                            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "next")
                        }
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                }

            }

        }
    }
}

@Composable
fun WelcomeStatsScreen(){
    Card(
        shape= RoundedCornerShape(20.dp),
        colors= CardDefaults.cardColors(
            containerColor = backgroundLightGray
        )
    ) {
        Box(
            modifier= Modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.stats_welcome_bg),
                contentDescription = "welcome_bg",modifier= Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier= Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Bienvenido John Doe",modifier= Modifier.fillMaxWidth())
                Text("¿Deseas agregar tu equipo o participar en los partidos?", fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
                Spacer(modifier= Modifier.padding(bottom=40.dp))
                Text("Agregalos a AtleStat",modifier=Modifier.fillMaxWidth())
                Spacer(modifier= Modifier.padding(bottom=20.dp))
                Button(onClick = { /*TODO*/ },modifier= Modifier.fillMaxWidth(0.6f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = mainColor
                    )) {
                    Text("Agregar", fontWeight = FontWeight.Bold,modifier= Modifier.padding(5.dp))
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                }
                Spacer(modifier= Modifier.padding(bottom=20.dp))
            }
        }
    }
}
