package com.atlestat.Presentation.Register

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.atlestat.Domain.Models.User
import com.atlestat.Presentation.Common.DropdownMenu
import com.atlestat.Presentation.Common.Routes
import com.atlestat.Presentation.Login.ViewModel.LoginVM
import com.atlestat.R
import com.atlestat.ui.theme.mainColor
import java.util.Calendar

@Composable
fun CrearUsuario(
    navController: NavController,
    vm:LoginVM
){
    val nombres= remember{mutableStateOf("")}
    val apellidos= remember{mutableStateOf("")}
    val fechaNacimiento= remember{mutableStateOf("")}
    val dni= remember{mutableStateOf("")}
    val genero =remember{ mutableStateOf("") }
    val distrito=remember{ mutableStateOf("") }
    val correo= remember{ mutableStateOf("") }
    val contrasena= remember{ mutableStateOf("") }
    val paso = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = true ){
        paso.value=0
    }
    if(paso.value==0){
        CrearUsuario1(
            nombres, apellidos, fechaNacimiento, dni, genero, distrito, paso
        )
    }else{
        CrearUsuario2(navController = navController,correo, contrasena,nombres, apellidos, fechaNacimiento, dni, genero, distrito,vm)
    }
}
@Composable
fun CrearUsuario1(
    nombres:MutableState<String>,
    apellidos:MutableState<String>,
    fechaNacimiento:MutableState<String>,
    dni:MutableState<String>,
    genero:MutableState<String>,
    distrito:MutableState<String>,
    paso:MutableState<Int>
) {
    val selectedDate = remember { mutableStateOf("") }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Function to handle date selection
    val onDateSelected = { year: Int, month: Int, dayOfMonth: Int ->
        // Update the selectedDate state
        val dayOfMonthText = if(dayOfMonth<10) "0$dayOfMonth" else "$dayOfMonth"
        val monthText= if(month<10) "0${month+1}" else "${month+1}"
        selectedDate.value = "$dayOfMonthText$monthText$year"
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
            fechaNacimiento.value=selectedDate.value
        }
    }
    Box(
        modifier= Modifier.fillMaxSize()
    ){
        Box(modifier = Modifier.fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.blurryloginbg), contentDescription = "",
                modifier= Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom=140.dp)
        ){
            item{Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(20.dp)){
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",modifier= Modifier
                    .size(40.dp)
                    .align(Alignment.TopStart), contentScale = ContentScale.FillWidth)
                Image(painter = painterResource(id = R.drawable.namelogo), contentDescription = "name",modifier= Modifier
                    .fillMaxWidth(0.5f)
                    .align(
                        Alignment.Center
                    ), contentScale = ContentScale.FillWidth)
            }}
            item{
                OutlinedTextField(value = nombres.value, onValueChange = {nombres.value=it},
                    label = {Text("Nombres")},
                    placeholder = {Text("Nombres")},
                    shape= RoundedCornerShape(10.dp),
                    modifier= Modifier
                        .fillMaxWidth(0.8f)
                        .padding(bottom = 10.dp),
                    leadingIcon={ Icon(imageVector = Icons.Filled.Person, contentDescription = "user") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = mainColor,
                        focusedLabelColor = mainColor,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    )
                )
            }
            item{
                OutlinedTextField(value = apellidos.value, onValueChange = {apellidos.value=it},
                    label = {Text("Apellidos")},
                    placeholder = {Text("Apellidos")},
                    shape= RoundedCornerShape(10.dp),
                    modifier= Modifier
                        .fillMaxWidth(0.8f)
                        .padding(bottom = 10.dp),
                    leadingIcon={ Icon(imageVector = Icons.Filled.Person, contentDescription = "user") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = mainColor,
                        focusedLabelColor = mainColor,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    )
                )
            }
            item{
                OutlinedTextField(value = fechaNacimiento.value, onValueChange = {fechaNacimiento.value=it},
                    label = {Text("Fecha de Nacimiento")},
                    placeholder = {Text("Fecha de Nacimiento")},
                    shape= RoundedCornerShape(10.dp),
                    modifier= Modifier
                        .fillMaxWidth(0.8f)
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
            }
            item{
                DropdownMenu(modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 10.dp), label = "Género", options = listOf("Seleccione un género","Másculino","Femenino"), leadingIcon = Icons.Filled.Face, selection = genero)
            }
            item{
                OutlinedTextField(value = dni.value, onValueChange = {dni.value=it},
                    label = {Text("Documento de identidad")},
                    placeholder = {Text("Documento de identidad")},
                    shape= RoundedCornerShape(10.dp),
                    modifier= Modifier
                        .fillMaxWidth(0.8f)
                        .padding(bottom = 10.dp),
                    leadingIcon={ Icon(imageVector = Icons.Filled.DateRange, contentDescription = "user") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = mainColor,
                        focusedLabelColor = mainColor,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                )
            }
            item{
                DropdownMenu(modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 10.dp), label = "Distrito", options = listOf("Seleccione un destrito","Barranco","Miraflores","Surco"), leadingIcon = Icons.Filled.Home, selection = distrito)
            }
        }
        Button(onClick = {paso.value=1},modifier= Modifier
            .fillMaxWidth(0.6f)
            .align(Alignment.BottomCenter)
            .padding(bottom = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = mainColor
            )) {
            Text("Continuar Registro", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
        }

    }



}
class DateTransformation() : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return dateFilter(text)
    }
}

fun dateFilter(text: AnnotatedString): TransformedText {

    val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 2 == 1 && i < 4) out += "/"
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 3) return offset +1
            if (offset <= 8) return offset +2
            return 10
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <=2) return offset
            if (offset <=5) return offset -1
            if (offset <=10) return offset -2
            return 8
        }
    }

    return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}

@Composable
fun CrearUsuario2(
    navController: NavController,
    correo:MutableState<String>,
    contrasena:MutableState<String>,
    nombres:MutableState<String>,
    apellidos:MutableState<String>,
    fechaNacimiento:MutableState<String>,
    dni:MutableState<String>,
    genero:MutableState<String>,
    distrito:MutableState<String>,
    vm:LoginVM
) {
    val contrasena2= remember{ mutableStateOf("") }
    val showContrasena = remember{ mutableStateOf(false) }
    val showContrasena2 = remember{ mutableStateOf(false) }
    Box(
        modifier= Modifier.fillMaxSize()
    ){
        Box(modifier = Modifier.fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.blurryloginbg), contentDescription = "",
                modifier= Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom=140.dp)
        ){
            item{Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(20.dp)){
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",modifier= Modifier
                    .size(40.dp)
                    .align(Alignment.TopStart), contentScale = ContentScale.FillWidth)
                Image(painter = painterResource(id = R.drawable.namelogo), contentDescription = "name",modifier= Modifier
                    .fillMaxWidth(0.5f)
                    .align(
                        Alignment.Center
                    ), contentScale = ContentScale.FillWidth)
            }}
            item{
                OutlinedTextField(value = correo.value, onValueChange = {correo.value=it},
                    label = {Text("Correo")},
                    placeholder = {Text("Correo")},
                    shape= RoundedCornerShape(10.dp),
                    modifier= Modifier
                        .fillMaxWidth(0.8f)
                        .padding(bottom = 10.dp),
                    leadingIcon={ Icon(imageVector = Icons.Filled.Email, contentDescription = "user") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = mainColor,
                        focusedLabelColor = mainColor,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                )
            }
            item{
                OutlinedTextField(value = contrasena.value, onValueChange = {contrasena.value=it},
                    label = {Text("Contraseña")},
                    placeholder = {Text("Contraseña")},
                    shape= RoundedCornerShape(10.dp),
                    modifier= Modifier
                        .fillMaxWidth(0.8f)
                        .padding(bottom = 10.dp),
                    leadingIcon={ Icon(imageVector = Icons.Filled.DateRange, contentDescription = "user") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = mainColor,
                        focusedLabelColor = mainColor,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                    trailingIcon = { Icon(painter = painterResource(id = if(showContrasena.value) R.drawable.remove_visibility else R.drawable.visibility), contentDescription = "",modifier=Modifier
                        .clickable { showContrasena.value=!showContrasena.value })},
                    visualTransformation = if(showContrasena.value) VisualTransformation.None else PasswordVisualTransformation()
                )
            }
            item{
                OutlinedTextField(value = contrasena2.value, onValueChange = {contrasena2.value=it},
                    label = {Text("Contraseña")},
                    placeholder = {Text("Repita Contraseña")},
                    shape= RoundedCornerShape(10.dp),
                    modifier= Modifier
                        .fillMaxWidth(0.8f)
                        .padding(bottom = 10.dp),
                    leadingIcon={ Icon(imageVector = Icons.Filled.DateRange, contentDescription = "user") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = mainColor,
                        focusedLabelColor = mainColor,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                    trailingIcon = { Icon(painter = painterResource(id = if(showContrasena2.value) R.drawable.remove_visibility else R.drawable.visibility), contentDescription = "",modifier=Modifier.clickable { showContrasena2.value=!showContrasena2.value })},
                    visualTransformation = if(showContrasena2.value) VisualTransformation.None else PasswordVisualTransformation()
                )
            }
        }
        Button(onClick = {
            vm.CreateUser(
                User(
                    nombres.value,
                    apellidos.value,
                    fechaNacimiento.value,
                    correo.value,
                    contrasena.value,
                    dni.value,
                    genero.value,
                    distrito.value
                )
            )
            navController.navigate(Routes.Login)
                         },modifier= Modifier
            .fillMaxWidth(0.6f)
            .align(Alignment.BottomCenter)
            .padding(bottom = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = mainColor
            )) {
            Text("Continuar Registro", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
        }
    }
}

@Composable
fun SuccessScreen(){
    Box(
        modifier= Modifier.fillMaxSize()
    ){
        Box(modifier = Modifier.fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.blurryloginbg), contentDescription = "",
                modifier= Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom=140.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.TopStart),
                        contentScale = ContentScale.FillWidth
                    )
                    Image(
                        painter = painterResource(id = R.drawable.namelogo),
                        contentDescription = "name",
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .align(
                                Alignment.Center
                            ),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
            item{
                Text("Se ha enviado un correo a: mrcoalba@gmail.com para que valide que usted ha creado la cuenta",modifier=Modifier.fillMaxWidth(0.8f),
                    textAlign = TextAlign.Justify)
            }
        }
        Button(onClick = { /*TODO*/ },modifier= Modifier
            .fillMaxWidth(0.6f)
            .align(Alignment.BottomCenter)
            .padding(bottom = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = mainColor
            )) {
            Text("Finalizar Registro", fontWeight = FontWeight.Bold,modifier=Modifier.padding(5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CrearUsuarioPreview(){
    SuccessScreen()
}