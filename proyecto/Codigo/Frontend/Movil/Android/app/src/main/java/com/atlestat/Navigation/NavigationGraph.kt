package com.atlestat.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atlestat.Presentation.Common.Routes
import com.atlestat.Presentation.Feed.AddMatch
import com.atlestat.Presentation.Feed.FeedScreen
import com.atlestat.Presentation.Feed.Game
import com.atlestat.Presentation.Feed.ViewModel.FeedVM
import com.atlestat.Presentation.Login.LoginScreen
import com.atlestat.Presentation.Login.ViewModel.LoginVM
import com.atlestat.Presentation.Profile.ProfileScreen
import com.atlestat.Presentation.Register.CrearUsuario
import com.atlestat.Presentation.Register.CrearUsuario1
import com.atlestat.Presentation.Register.CrearUsuario2
import com.atlestat.Presentation.Stats.StatsScreen

@Composable
fun NavigationGraph(
    navController:NavHostController,
    loginVM: LoginVM= hiltViewModel(),
    feedVM: FeedVM= hiltViewModel(),
    selectedIndex:MutableState<Int>
){

    NavHost(navController = navController, startDestination = Routes.Login ){
        composable(Routes.Login){
            LoginScreen(navController=navController,vm=loginVM)
        }
        composable(Routes.Register1){
            CrearUsuario(navController = navController, vm = loginVM)
        }
        composable(Routes.Home){
            FeedScreen(navController=navController,loginVM=loginVM,feedVM=feedVM,selectedIndex=selectedIndex)
        }
        composable(Routes.Stats){
            StatsScreen(navController=navController)
        }
        composable(Routes.Profile){
            ProfileScreen(navController = navController,loginVM=loginVM)
        }
        composable(Routes.AddContent){
            AddMatch(navController = navController,loginVM=loginVM,feedVM=feedVM)
        }
        composable(Routes.Game){
            Game()
        }
    }
}