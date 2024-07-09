package com.atlestat.Presentation.Feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.atlestat.Domain.Models.Match
import com.atlestat.Domain.Models.Team
import com.atlestat.Presentation.Common.CustomBottomBar
import com.atlestat.Presentation.Common.CustomTopBar
import com.atlestat.Presentation.Common.Routes
import com.atlestat.Presentation.Feed.ViewModel.FeedVM
import com.atlestat.Presentation.Login.ViewModel.LoginVM
import com.atlestat.R
import com.atlestat.ui.theme.backgroundGray
import com.atlestat.ui.theme.backgroundLightGray
import com.atlestat.ui.theme.darkMainColor
import com.atlestat.ui.theme.mainColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@Composable
fun FeedScreen(
    navController: NavController,
    loginVM: LoginVM,
    feedVM: FeedVM,
    selectedIndex:MutableState<Int>
) {
    Scaffold(
        modifier=Modifier.fillMaxSize(),
        floatingActionButton = {
            if(selectedIndex.value==1){
                FloatingActionButton(onClick = { navController.navigate(Routes.AddContent) },
                    shape= RoundedCornerShape(10.dp),
                    modifier=Modifier.size(56.dp),
                    containerColor= mainColor) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "add",modifier=Modifier.size(32.dp),tint=Color.White)
                }
            }

        }
    ) {paddingValues ->
        LazyColumn(
            modifier= Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding= PaddingValues(bottom=120.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item{
                Column(modifier=Modifier.fillMaxWidth(0.9f)) {
                    Text("Próximo partido",fontWeight= FontWeight.Bold,modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp))
                    NextMatch(feedVM.currentMatch[0],coach= selectedIndex.value==1,navController)
                }
            }
            if(selectedIndex.value==1){
                item{
                    Column(modifier= Modifier
                        .fillMaxWidth(0.9f)
                        .padding(top = 20.dp)) {
                        Text("Mis Equipos",fontWeight= FontWeight.Bold,modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp))
                        TeamCarrousel(feedVM.teams)
                    }
                }
            }
            item{
                Column(modifier= Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 20.dp)) {
                    Text("Partidos pasados",fontWeight= FontWeight.Bold,modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp))
                    feedVM.pastMatches.forEach {
                        PastMatch(it)
                        Spacer(modifier = Modifier.padding(top=10.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeCard(){
    val codigo=remember{ mutableStateOf("") }
    Card(
        shape= RoundedCornerShape(20.dp),
        colors= CardDefaults.cardColors(
            containerColor = backgroundLightGray
        )
    ) {
        Box(
            modifier=Modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.welcome_img),
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
                Text("Bienvenido John Doe",modifier=Modifier.fillMaxWidth())
                Text("¿Deseas agregar tu equipo o participar en los partidos?", fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
                Spacer(modifier=Modifier.padding(bottom=40.dp))
                Text("Ingresa tu código de invitación")
                OutlinedTextField(value = codigo.value, onValueChange = {codigo.value=it},
                    label = {Text("Código")},
                    placeholder = {Text("Ingresa tu código")},
                    shape= CircleShape,
                    modifier=Modifier.fillMaxWidth(0.8f),
                    leadingIcon={ Icon(imageVector = Icons.Filled.Create , contentDescription = "codigo") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = mainColor,
                        focusedLabelColor = darkMainColor
                    )
                )
                Spacer(modifier=Modifier.padding(bottom=20.dp))
                Button(onClick = { /*TODO*/ },modifier=Modifier.fillMaxWidth(0.6f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = mainColor
                    )) {
                    Text("Agregar", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                }
                Spacer(modifier=Modifier.padding(bottom=20.dp))
            }
        }
    }
}
@Composable
fun NextMatch(
    match: Match,
    coach:Boolean,
    navController: NavController
){
    Card(
        shape= RoundedCornerShape(20.dp),
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = R.drawable.playing_img), contentDescription = "nextMatch",modifier=Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
            Column(
                modifier= Modifier
                    .background(backgroundLightGray)
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.football_ic), contentDescription = "football_logo",modifier=Modifier.size(20.dp))
                    Text("Partido de práctica")
                }
                Text(text = "${match.equipo1} vs ${match.equipo2}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Row(
                    modifier= Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Filled.DateRange, contentDescription = "date")
                        Text(text = match.fecha)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painterResource(id = R.drawable.baseline_access_time_24), contentDescription = "time")
                        Text(text = match.duracion+" minutos")
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier=Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("10 AM")
                    Button(onClick = {if (coach){
                        navController.navigate(Routes.Game)
                    }
                                                },modifier=Modifier.fillMaxWidth(0.6f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = mainColor
                        )) {
                        Text(if(coach) "Editar" else "Jugar", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "next")
                    }
                }
            }
        }

    }
}

@Composable
fun TeamCard(team: Team){
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape= RoundedCornerShape(20.dp)
    ){
        Box(modifier = Modifier.fillMaxSize()){
            Image(painterResource(id = R.drawable.team_card),contentDescription = null,modifier=Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(0.5f)))
            Text(team.nombre, fontWeight = FontWeight.Bold,modifier=Modifier.align(Alignment.Center),color=Color.White)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TeamCarrousel(teams:List<Team>){
    val pagerState= rememberPagerState(pageCount = teams.size)
    Column(
        modifier=Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HorizontalPager(state =pagerState,
            modifier=Modifier.fillMaxWidth(),
            itemSpacing = 10.dp) {page->
            TeamCard(teams[page])
        }
        HorizontalPagerIndicator(Modifier.padding(top=5.dp),pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerIndicator(
    modifier: Modifier,
    pagerState:PagerState
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration -> // Loop through pages
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray)
                    .height(5.dp)
                    .width(if (pagerState.currentPage == iteration) 20.dp else 10.dp)
            )
        }
    }
}

@Composable
fun PastMatch(match: Match){
    Card(
        modifier= Modifier
            .fillMaxWidth(),
        shape= RoundedCornerShape(20.dp)
    ){
        Column(
            modifier= Modifier
                .fillMaxSize()
                .background(backgroundLightGray)
                .padding(20.dp)
        ) {
            Row(
                modifier= Modifier
                    .background(Color(0xff37474F), RoundedCornerShape(20.dp))
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(match.equipo1Puntaje?:"", fontWeight = FontWeight.Bold,color=Color.White)
                    Text(match.equipo1, fontWeight = FontWeight.Bold,color=Color.White)
                }
                Text("vs", fontStyle = FontStyle.Italic,color=Color.White,modifier=Modifier.padding(horizontal = 30.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(match.equipo2Puntaje?:"", fontWeight = FontWeight.Normal,color=Color.White)
                    Text(match.equipo2, fontWeight = FontWeight.Normal,color=Color.White)
                }
            }
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.football_ic), contentDescription =null ,modifier=Modifier.size(20.dp))
                    Text("Partido de práctica")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = null,modifier=Modifier.size(20.dp) )
                    Text(match.fecha)
                }
            }
        }
    }
}
