package cl.mobdev.demoandrea.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.mobdev.demoandrea.screens.ListScreen
import cl.mobdev.demoandrea.screens.DetailScreen


@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.ListScreen.route){
        composable(route = AppScreens.ListScreen.route){
            ListScreen(navController)
        }
        composable(route = AppScreens.DetailScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text"){
                type = NavType.StringType
            })){
            DetailScreen(navController, it.arguments?.getString("text"))
        }
    }
}