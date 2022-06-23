package cl.mobdev.demoandrea.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.mobdev.demoandrea.R
import cl.mobdev.demoandrea.navigation.AppScreens


@Composable
fun ListScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        MyListOfCourses(myCourses, navController)
    }
}

data class MyCourse(val id: String, val image: Int, val title: String, val description:String){}

private val myCourses: List<MyCourse> = listOf(
    MyCourse("1", R.drawable.c01, "Front End Web Development",
        "This course will provide you with all of the essentials to become a successful frontend web developer. You will learn to master HTML, CSS and front end JavaScript, along with tools like Git, VSCode and front end frameworks like Vue"),
    MyCourse("2", R.drawable.c02, "Back end Web Development",
        "In this course you will learn back end web development, with tecnologies like backend with Node.js/Express/MongoDBIn this course you will learn back end web development, with tecnologies like backend with Node.js/Express/MongoDB"),
    MyCourse("3", R.drawable.c03, "Full Stack Web Dev",
        "In this course you will learn all about the front end with HTML, CSS and JavaScript. You will master tools like Git and Webpack and also learn C# and ASP.NET with Postgres"),
    MyCourse("4", R.drawable.c04, "UI/UX",
        "In this course you will learn to create beautiful interfaces. It is a mix of design and development to create modern user experiences on both web and mobile"),
    MyCourse("5", R.drawable.c05, "Web Design & Development",
        "Get started building websites and web apps with HTML/CSS/JavaScript/NodeJS. We teach you"),
    MyCourse("6", R.drawable.c06, "Data Science Program",
        "In this course you will learn Python for data science, machine learning and big data tools"),
    MyCourse("7", R.drawable.c07, "React Web Development",
        "This course will teach you how to build high quality web applications with technologies like React, Node.js, PHP & Laravel"),
    MyCourse("8", R.drawable.c08, "Software QA",
        "This course will teach you everything you need to know about quality assurance, and make safer the development process"),
    MyCourse("9", R.drawable.c09, "IOS Development",
        "Get started building mobile applications for IOS using Swift and other tools"),
    MyCourse("10", R.drawable.c10, "Android Development",
        "Get started building mobile applications for Android using Kotlin and other tools")
)

@Composable
fun MyItem(course: MyCourse, navController: NavController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .border(2.dp, Color.Red)
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colors.onBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(id = course.image), contentDescription = "image")
                MyTexts(course, navController)
            }
        }
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, fontWeight: FontWeight, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, fontWeight = fontWeight, maxLines = lines)
}

@Composable
fun MyTexts(course: MyCourse, navController: NavController){

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        MyText(
            text = course.title,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            text = course.description,
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Normal,
            if (expanded) Int.MAX_VALUE else 1)
        Button(onClick = {
            navController.navigate(route = AppScreens.DetailScreen.route + course.id)
        }) {
            Text(stringResource(R.string.button_detail))
        }
    }
}

@Composable
fun MyListOfCourses(myCourses: List<MyCourse>, navController: NavController){
    LazyColumn {
        items(myCourses){course ->
            MyItem(course, navController)
        }
    }
}



