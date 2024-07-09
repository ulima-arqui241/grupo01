package com.atlestat.Presentation.Common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.atlestat.ui.theme.mainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenu(
    leadingIcon:ImageVector,
    modifier:Modifier,
    label:String?=null,
    selection:MutableState<String>,
    options:List<String>
) {
    val expanded=remember{ mutableStateOf(false) }
    val selectedIndex=remember{ mutableStateOf(0) }
    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = {
            expanded.value= !expanded.value
        },
        modifier=modifier
    ) {
        OutlinedTextField(
            value = options[selectedIndex.value],
            leadingIcon={
                Icon(imageVector = leadingIcon, contentDescription ="" )
            },
            onValueChange = {},
            label = {
                if (label != null) {
                    Text(label)
                }
            },
            readOnly = true, // Makes the TextField not editable
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded.value
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = mainColor,
                focusedLabelColor = mainColor,
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            shape= RoundedCornerShape(10.dp)
        )
        ExposedDropdownMenu(
            expanded = expanded.value,
            onDismissRequest = {
                expanded.value = false
            }
        ) {
            options.forEachIndexed { index, option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedIndex.value = index
                        expanded.value = false
                        selection.value=options[selectedIndex.value]
                    }
                )
            }
        }
    }
}