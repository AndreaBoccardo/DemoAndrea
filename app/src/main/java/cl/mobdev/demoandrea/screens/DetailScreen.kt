package cl.mobdev.demoandrea.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, text: String?){
    Column() {
        if (text != null) {
            Text(text)
        }
    }
}