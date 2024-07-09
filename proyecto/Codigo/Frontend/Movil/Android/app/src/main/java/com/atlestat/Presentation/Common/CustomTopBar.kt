package com.atlestat.Presentation.Common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atlestat.R
import com.atlestat.ui.theme.backgroundLightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    selectedType:MutableState<Int>
) {
    val expanded= remember{ mutableStateOf(false) }

    TopAppBar(title = { /*TODO*/ },
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier=Modifier.padding(start=20.dp)
            ){
                Icon(painter = painterResource(id = R.drawable.logo), contentDescription = "icon",modifier=Modifier.size(30.dp))
                Icon(painter = painterResource(id = R.drawable.namelogo), contentDescription = "logo")
                Row(
                    modifier=Modifier.padding(start=20.dp)
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded.value,
                        onExpandedChange = {
                            expanded.value= !expanded.value
                        },
                        modifier=Modifier
                    ) {
                        Row {
                            Button(
                                modifier=Modifier.menuAnchor(),
                                colors=ButtonDefaults.buttonColors(
                                    containerColor = backgroundLightGray,
                                    contentColor = Color.Black
                                ),
                                onClick = { /*TODO*/ }
                            ) {
                                Icon(painterResource(id = list[selectedType.value].icon),contentDescription = null,tint= Color.Black,modifier=Modifier.size(25.dp))
                                ExposedDropdownMenuDefaults.TrailingIcon(
                                    expanded = expanded.value
                                )
                            }
                        }
                        ExposedDropdownMenu(
                            expanded = expanded.value,
                            onDismissRequest = {
                                expanded.value = false
                            },
                            modifier=Modifier.width(150.dp)
                                .background(Color.White),
                        ) {
                            list.forEachIndexed { index, option ->
                                DropdownMenuItem(
                                    modifier=Modifier.fillMaxWidth(),
                                    text = { Text(option.name) },
                                    leadingIcon = {
                                                  Icon(painter = painterResource(id = option.icon), contentDescription = null,modifier=Modifier.size(20.dp) )
                                    },
                                    onClick = {
                                        selectedType.value = index
                                        expanded.value = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}
val list = listOf<TypeUser>(
    TypeUser(
        "Jugador",
        R.drawable.player_icon
    ),
    TypeUser(
        "Coach",
        R.drawable.logo
    )
)

data class TypeUser(
    val name:String,
    val icon:Int
)

