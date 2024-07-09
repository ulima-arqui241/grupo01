package com.atlestat.Presentation.Common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.atlestat.ui.theme.mainColor

@Composable
fun ErrorDialog(
    show:MutableState<Boolean>,
    errorMensaje:String
){
    AlertDialog(
        onDismissRequest = { show.value=false },
        containerColor = Color.White,
        confirmButton = {
            Button(
                colors= ButtonDefaults.buttonColors(
                    containerColor = mainColor,
                    contentColor = Color.White
                ),
                onClick = {
                    show.value=false
                }) {
                Text("Ok", fontWeight = FontWeight.Bold)
            }
        },
        icon= {
            Icon(imageVector = Icons.Default.Warning, contentDescription = "info")
        },
        title = {
            Text("Aviso")
        },
        text = {
            Text(errorMensaje, textAlign = TextAlign.Center,modifier= Modifier.fillMaxWidth())
        }
    )
}