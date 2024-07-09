package com.atlestat.Navigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.atlestat.Presentation.Common.CustomBottomBar
import com.atlestat.Presentation.Common.CustomTopBar
import com.atlestat.Presentation.Common.Routes
import com.atlestat.ui.theme.backgroundLightBlue
import com.atlestat.ui.theme.selectionLightBlue
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun NavigationScreen(
    systemUiController: SystemUiController
) {
    val navController= rememberNavController()
    val destination=navController.currentBackStackEntryAsState().value?.destination?.route
    val selectedIndex= remember{ mutableStateOf(1) }
    LaunchedEffect(key1 = destination){
        if(destination==Routes.Login){
            systemUiController.setStatusBarColor(Color(0xff90b8e9))
        }else{
            systemUiController.setStatusBarColor(Color(0xfff5f5f5))
        }
    }
    Scaffold(
        modifier=Modifier.fillMaxSize(),
        bottomBar = {
            if(FullScreenCondition(destination)){
                CustomBottomBar(navController)
            }
        },
        topBar = {
            if(FullScreenCondition(destination)){
                CustomTopBar(selectedIndex)
            }
        }
    ){paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)){
            NavigationGraph(navController=navController,selectedIndex=selectedIndex)
        }
    }
}

fun FullScreenCondition(route: String?):Boolean{
    return if(route==null){
         true
    }else{
         !(route==Routes.Login || route==Routes.Register2 || route==Routes.Register1)
    }
}