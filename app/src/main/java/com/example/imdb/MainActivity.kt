package com.example.imdb

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import retrofit2.Response
import retrofit2.http.GET

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            createHomePage()
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "createHomePage", showSystemUi = true, showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun createHomePage(){
    val context = LocalContext.current
    val inputText = remember { mutableStateOf("") }
    val intentx = Intent(context,FilmDetails::class.java)
    val magnifier =  Icons.Default.ArrowBack
    val list = Icons.Default.Home
    val bottomNavItems= listOf<BottomNavItem>(
        BottomNavItem("Search","search",magnifier),
        BottomNavItem("List","list",list)
    )
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(97, 97, 97))
        ,
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = R.drawable.imdb), contentDescription = "Imdb Banner")
        }
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            TextField(   value = inputText.value , onValueChange ={ it->inputText.value=it} , label = { Text(text = "Film İsmi Giriniz")}, modifier = Modifier
                .padding()
            )
            Button(
                modifier = Modifier
                    .padding(vertical = 20.dp),
                onClick = {
                    intentx.putExtra("film_name",inputText.value)
                    context.startActivity(intentx)
                },
                colors = ButtonDefaults.buttonColors(Color(250,181,5), Color.Black)

            )
            {
                Text(text = "Ara")
            }
        }
    }
}




