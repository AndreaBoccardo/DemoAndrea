package cl.mobdev.demoandrea.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import cl.mobdev.demoandrea.R

@Composable
fun DetailScreen(navController: NavController, text: String?){
    Scaffold(topBar = {
        TopAppBar() {
            Text(stringResource(R.string.title_detail))
        }
    }) {
        BodyContent()
    }
    
    Column() {
        if (text != null) {
            Text(text)
            Text(text)
        }
    }
}

@Composable
fun BodyContent(){}