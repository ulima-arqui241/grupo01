package com.atlestat.Presentation.Common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.atlestat.R
import com.atlestat.ui.theme.backgroundLightBlue
import com.atlestat.ui.theme.selectionLightBlue

@Composable
fun CustomBottomBar(
    navController:NavController?=null
) {
    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    BottomAppBar(
        containerColor = backgroundLightBlue,
        contentPadding = PaddingValues(10.dp)
    ) {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                modifier= Modifier.weight(1f),
                selected = index==selectedIndex,
                onClick = {
                    navController?.navigate(screen.route)
                    selectedIndex = index
                },
                icon = {
                    Icon(painter = painterResource(id = screen.icon), contentDescription = "Icon",tint=Color.Black, modifier = Modifier.size(25.dp))
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = selectionLightBlue
                )
            )
        }
    }
}
val items = listOf<NavItem>(
    NavItem(
        title = "Home",
        icon=R.drawable.home_ic,
        route = Routes.Home
    ),
    NavItem(
        title = "Stats",
        icon=R.drawable.stats_ic,
        route = Routes.Stats
    ),
    NavItem(
        title = "Profile",
        icon= R.drawable.user_ic,
        route = Routes.Profile
    )
)
data class NavItem (
        val title:String,
        val icon:Int,
        val route:String)

