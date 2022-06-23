package cl.mobdev.demoandrea.navigation

sealed class AppScreens(val route: String){

    object ListScreen: AppScreens("list_screen")
    object DetailScreen: AppScreens("detail_screen")

}