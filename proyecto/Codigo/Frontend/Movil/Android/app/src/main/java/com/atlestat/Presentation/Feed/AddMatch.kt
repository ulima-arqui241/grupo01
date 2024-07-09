package com.atlestat.Presentation.Feed

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.atlestat.Domain.Models.Match
import com.atlestat.Domain.Models.Team
import com.atlestat.Domain.Models.User
import com.atlestat.Presentation.Common.DropdownMenu
import com.atlestat.Presentation.Common.Routes
import com.atlestat.Presentation.Feed.ViewModel.FeedVM
import com.atlestat.Presentation.Login.ViewModel.LoginVM
import com.atlestat.Presentation.Register.DateTransformation
import com.atlestat.R
import com.atlestat.ui.theme.backgroundGray
import com.atlestat.ui.theme.backgroundLightBlue
import com.atlestat.ui.theme.backgroundLightGray
import com.atlestat.ui.theme.darkMainColor
import com.atlestat.ui.theme.mainColor
import com.atlestat.ui.theme.selectionLightBlue
import java.util.Calendar

@Composable
fun AddMatch(
    navController: NavController,
    loginVM: LoginVM,
    feedVM: FeedVM
) {
    val selection=remember{ mutableStateOf(0) }
    Scaffold(
        modifier= Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){paddingValues ->
        Column(
            modifier= Modifier
                .fillMaxSize()
                .background(backgroundLightGray, RoundedCornerShape(20.dp))
                .padding(paddingValues)
        ) {
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ){
                Column(
                    modifier= Modifier
                        .weight(1f)
                        .background(
                            if (selection.value == 0) backgroundLightBlue else Color.White,
                            RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                        .clickable {
                            selection.value = 0
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(painter = painterResource(id = R.drawable.player_icon), contentDescription = null,modifier=Modifier.size(25.dp).padding(top=5.dp))
                    Text("Atleta")
                }
                Column(
                    modifier= Modifier
                        .weight(1f)
                        .background(
                            if (selection.value == 1) backgroundLightBlue else Color.White,
                            RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                        .clickable {
                            selection.value = 1
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(painter = painterResource(id = R.drawable.logo), contentDescription = null,modifier=Modifier.size(25.dp).padding(top=5.dp))
                    Text("Entrenador")
                }
            }
            HorizontalDivider(thickness = 2.dp, color = selectionLightBlue)
            if(selection.value==0){
                AthleteParticipation(navController)
            }else{
                CoachOptions(navController,loginVM,feedVM)
            }

        }
    }
}

@Composable
fun AthleteParticipation(navController: NavController){
    val codigo=remember{ mutableStateOf("") }
    Box(
        modifier=Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.match_img),
            contentDescription = null,modifier= Modifier
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
            Text("Participa en un equipo",modifier=Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold,fontSize=20.sp)
            Spacer(modifier=Modifier.padding(bottom=40.dp))
            Text("Ingresa tu código de invitación",modifier=Modifier.fillMaxWidth())
            OutlinedTextField(value = codigo.value, onValueChange = {codigo.value=it},
                label = {Text("Código")},
                placeholder = {Text("Ingresa tu código")},
                shape= CircleShape,
                modifier=Modifier.fillMaxWidth(),
                leadingIcon={ Icon(imageVector = Icons.Filled.Create , contentDescription = "codigo") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = mainColor,
                    focusedLabelColor = darkMainColor
                )
            )
            Spacer(modifier=Modifier.padding(bottom=20.dp))
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(imageVector = Icons.Filled.Info, contentDescription = null,modifier=Modifier.padding(end=10.dp))
                Text("Este código es proporcionado por el entreandor")
            }
            Spacer(modifier=Modifier.padding(bottom=20.dp))
            Button(onClick = {
                navController.navigate(Routes.Home)
            },modifier=Modifier.fillMaxWidth(0.6f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = mainColor
                )) {
                Text("Siguiente", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
            }
            Spacer(modifier=Modifier.padding(bottom=20.dp))
        }
    }
}

@Composable
fun CoachOptions(navController: NavController,loginVM: LoginVM,feedVM: FeedVM){
    val selection= remember {
        mutableStateOf(0)
    }
    val fecha = remember {
        mutableStateOf("")
    }
    val duracion = remember {
        mutableStateOf("")
    }
    val playerList = remember{
        mutableStateOf("")
    }
    val newPlayerList = remember{
        mutableStateOf("")
    }
    val nombreEquipo = remember{
        mutableStateOf("")
    }
    val correoToAdd = remember{ mutableStateOf("") }
    val selectedDate = remember { mutableStateOf("") }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val equipoA = remember{ mutableStateOf("") }
    val equipoB = remember {
        mutableStateOf("")
    }
    val starting11= remember {
        mutableStateListOf<User>()
    }
    LaunchedEffect(key1 = true ){
        starting11.clear()
        starting11.addAll(loginVM.Get11Random())
    }

    // Function to handle date selection
    val onDateSelected = { year: Int, month: Int, dayOfMonth: Int ->
        // Update the selectedDate state
        val dayOfMonthText = if(dayOfMonth<10) "0$dayOfMonth" else "$dayOfMonth"
        val monthText= if(month<10) "0${month+1}" else "${month+1}"
        selectedDate.value = "$dayOfMonthText/$monthText/$year"
    }

    // Function to show DatePickerDialog
    val showDatePickerDialog = {
        DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                onDateSelected(year, month, dayOfMonth)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
    LaunchedEffect(key1 = selectedDate.value ){
        if(selectedDate.value!=""){
            fecha.value=selectedDate.value
        }
    }
    LazyColumn(
        modifier= Modifier
            .fillMaxSize()
    ){
        item{
            Column(
                modifier=Modifier.padding(20.dp)
            ){
                Text("Crear",modifier= Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp), fontWeight = FontWeight.Bold,fontSize=20.sp)
                Row(
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row(
                        modifier= Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(
                                if (selection.value == 0) selectionLightBlue else backgroundGray,
                                RoundedCornerShape(20.dp)
                            )
                            .clickable {
                                selection.value = 0
                            },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.football_ic), contentDescription = null,modifier=Modifier.size(30.dp))
                        Spacer(Modifier.padding(horizontal = 5.dp))
                        Text("Partido")
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row(
                        modifier= Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(
                                if (selection.value == 1) selectionLightBlue else backgroundGray,
                                RoundedCornerShape(20.dp)
                            )
                            .clickable {
                                selection.value = 1
                            },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(painter = painterResource(id = R.drawable.baseline_people_24), contentDescription = null,modifier=Modifier.size(30.dp))
                        Spacer(Modifier.padding(horizontal = 5.dp))
                        Text("Equipo")
                    }
                }

            }
            if(selection.value==0){
                Column(
                    modifier=Modifier.padding(20.dp)
                ) {
                    Text(text = "Fecha ",modifier= Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp))
                    OutlinedTextField(value = fecha.value, onValueChange = {fecha.value=it},
                        label = {Text("Fecha del partido")},
                        placeholder = {Text("Fecha del partido")},
                        shape= RoundedCornerShape(10.dp),
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        leadingIcon={ Icon(imageVector = Icons.Filled.DateRange, contentDescription = "user") },
                        trailingIcon={ Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "fecha",modifier=Modifier.clickable {
                            showDatePickerDialog()
                        })},
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = mainColor,
                            focusedLabelColor = mainColor,
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White
                        ),
                        visualTransformation = DateTransformation()
                    )
                    Text(text = "Duración ",modifier= Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp))
                    OutlinedTextField(
                        value = duracion.value, onValueChange = { duracion.value = it },
                        label = { Text("Duración del partido (en min)") },
                        placeholder = { Text("Duración del partido (en min)") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_access_time_24),
                                contentDescription = null
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = mainColor,
                            focusedLabelColor = mainColor,
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White
                        ),
                    )
                    Text(text = "Equipo A ",modifier= Modifier
                        .fillMaxWidth())
                    DropdownMenu(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp), options = feedVM.teams.map {
                                                           it.nombre
                    }, leadingIcon = Icons.Filled.Face, selection = equipoA)
                    Text(text = "Equipo B ",modifier= Modifier
                        .fillMaxWidth())
                    DropdownMenu(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp), options = feedVM.teams.map {
                        it.nombre
                    }, leadingIcon = Icons.Filled.Face, selection = equipoB)
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End){
                        Button(onClick = {
                            feedVM.AddRecent(
                                Match(
                                    equipo1 = equipoA.value,
                                    equipo2 = equipoB.value,
                                    duracion = duracion.value,
                                    fecha=fecha.value,
                                    equipo1Puntaje = (0..5).random().toString(),
                                    equipo2Puntaje = (0..5).random().toString()
                                )
                            )
                            navController.navigate(Routes.Home)
                        },modifier= Modifier
                            .fillMaxWidth(0.6f)
                            .padding(vertical = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = mainColor
                            )) {
                            Text("Siguiente", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
                            Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
                        }
                    }

                }
            }else{
                Image(painter = painterResource(id = R.drawable.coach_img), contentDescription = null,modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp), contentScale = ContentScale.FillWidth)
                Column(modifier=Modifier.padding(20.dp)) {
                    Text(text = "Nombre ",modifier= Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp))
                    OutlinedTextField(
                        value = nombreEquipo.value, onValueChange = { nombreEquipo.value = it },
                        label = { Text("Nombre") },
                        placeholder = { Text("") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_people_24),
                                contentDescription = null
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = mainColor,
                            focusedLabelColor = mainColor,
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White
                        ),
                    )
                    Text(text = "Integrantes ",modifier= Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp))
                    OutlinedTextField(
                        value = correoToAdd.value, onValueChange = { correoToAdd.value = it },
                        label = { Text("Correo del integrante") },
                        placeholder = { Text("Correo del integrante") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_people_24),
                                contentDescription = null
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = mainColor,
                            focusedLabelColor = mainColor,
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White
                        ),
                    )
                    Row(
                        modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
                        Button(onClick = {
                            val tempUser = loginVM.GetUser(correoToAdd.value)
                            tempUser?.let {
                                starting11.add(it)
                            }
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = mainColor
                            )) {
                            Text("Agregar", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
                        }
                    }
                    Text("Integrantes", fontWeight = FontWeight.Bold,modifier=Modifier.padding(vertical = 5.dp))
                    starting11.forEach {
                        Text(it.nombres+" "+it.apellidos)
                    }
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End){
                        Button(onClick = {
                            feedVM.AddTeam(
                                Team(nombre = nombreEquipo.value,
                                    integrantes = starting11)
                            )
                            navController.navigate(Routes.Home)
                        },modifier= Modifier
                            .fillMaxWidth(0.6f)
                            .padding(vertical = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = mainColor
                            )) {
                            Text("Siguiente", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
                            Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
                        }
                    }
                }
            }

        }

    }
}