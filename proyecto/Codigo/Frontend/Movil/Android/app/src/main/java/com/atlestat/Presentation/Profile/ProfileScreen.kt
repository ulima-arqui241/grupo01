package com.atlestat.Presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.atlestat.Presentation.Common.Routes
import com.atlestat.Presentation.Login.ViewModel.LoginVM
import com.atlestat.R
import com.atlestat.ui.theme.backgroundLightGray
import com.atlestat.ui.theme.mainColor

@Composable
fun ProfileScreen(
    navController: NavController,
    loginVM: LoginVM
) {
    LazyColumn(modifier= Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        item{
            Card(
                modifier=Modifier.padding(20.dp),
                shape = RoundedCornerShape(10.dp),
                colors=CardDefaults.cardColors(
                    containerColor = backgroundLightGray,
                    contentColor = Color.Black
                )
            ){
                Column(modifier=Modifier.fillMaxSize()
                    .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,){
                    Image(painter = painterResource(id = R.drawable.messi), contentDescription = null,modifier= Modifier
                        .size(150.dp)
                        .clip(
                            CircleShape
                        ),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(text = loginVM.loggedUser.value.nombres+" "+loginVM.loggedUser.value.apellidos, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = { navController.navigate(Routes.Login) },modifier=Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = mainColor
                        )) {
                        Text("Cerrar Sesión", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "next")
                    }
                }
            }
        }
    }
}