package com.atlestat.Presentation.Login

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.atlestat.Presentation.Common.Routes
import com.atlestat.Presentation.Login.ViewModel.LoginVM
import com.atlestat.R
import com.atlestat.ui.theme.mainColor
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.reflect.Array.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    vm:LoginVM
){
    val userTxtFld= remember{mutableStateOf("")}
    val passTxtFld= remember{mutableStateOf("")}
    val visibility = remember{ mutableStateOf(false) }
    Box(
        modifier=Modifier.fillMaxSize()
    ){
        Box(modifier = Modifier.fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.loginbg), contentDescription = "",
                modifier=Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
            Row(
                modifier= Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(0.7f)
                    .padding(start = 20.dp, bottom = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",modifier=Modifier.fillMaxWidth(0.2f), contentScale = ContentScale.FillWidth)
                Image(painter = painterResource(id = R.drawable.namelogo), contentDescription = "name",modifier=Modifier.fillMaxWidth(0.8f), contentScale = ContentScale.FillWidth)
            }
        }
        Column(
            modifier= Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = userTxtFld.value, onValueChange = {userTxtFld.value=it},
                label = {Text("Correo")},
                placeholder = {Text("Correo")},
                shape= RoundedCornerShape(10.dp),
                modifier=Modifier.fillMaxWidth(0.8f),
                leadingIcon={ Icon(imageVector = Icons.Filled.Email, contentDescription = "mail")},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = mainColor,
                    focusedLabelColor = mainColor,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.padding(bottom=20.dp))
            OutlinedTextField(value = passTxtFld.value, onValueChange = {passTxtFld.value=it},
                label = {Text("Contraseña")},
                placeholder = {Text("Contraseña")},
                shape= RoundedCornerShape(10.dp),
                modifier=Modifier.fillMaxWidth(0.8f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = mainColor,
                    focusedLabelColor = mainColor,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                ),
                leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "lock")},
                trailingIcon = { Icon(painter = painterResource(id = if(visibility.value) R.drawable.visibility else R.drawable.remove_visibility), contentDescription = "visibility",modifier=Modifier.clickable {
                    visibility.value=!visibility.value
                })},
                visualTransformation = if(!visibility.value) PasswordVisualTransformation() else VisualTransformation.None
            )
            Spacer(modifier = Modifier.padding(bottom=20.dp))

            Button(onClick = {
                if(vm.Login(userTxtFld.value,passTxtFld.value)){
                    navController.navigate(Routes.Home)
                }
            },modifier=Modifier.fillMaxWidth(0.6f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = mainColor
                )) {
                Text("Ingresar", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
            }
            Spacer(modifier = Modifier.padding(bottom=20.dp))
            TextButton(onClick = {
                navController.navigate(Routes.Login)
            }) {
                Text("Cambiar contraseña",color= mainColor)
            }
            HorizontalDivider(modifier= Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 20.dp))
            TextButton(onClick = {
                navController.navigate(Routes.Register1)
            }) {
                Text("Crear cuenta",color= mainColor)
            }
            Spacer(modifier = Modifier.padding(bottom=20.dp))
        }

    }
}

