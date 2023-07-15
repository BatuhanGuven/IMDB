package com.example.imdb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import retrofit2.Call

class FilmDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            apiProcesses(intent,this,this)


        }
    }
}
@Composable
fun BackButtonx(onBackPressed: () -> Unit) {
    IconButton(
        onClick = onBackPressed,
        modifier = Modifier.padding(5.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Geri"
        )
    }
}

@Composable
fun apiProcesses(intent: Intent,context: Context,activity: ComponentActivity){
    val query = intent.getStringExtra("film_name")
    val moviesList = remember { mutableListOf<Result>() }
    val isMoviesLoad = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val intent = Intent(context,movieDetails::class.java)

    if (isMoviesLoad.value==false){
        val call = apiService.getData(
            "apikey 5M9tXgFhIfWYuzM5ofVnB2:25QC4JBUyujhquUAUFQmzN",
            "application/json",
            query!!
        )
        call.enqueue(object : retrofit2.Callback<MoviesDataModel> {
            override fun onResponse(call: Call<MoviesDataModel>, response: retrofit2.Response<MoviesDataModel>) {
                if (response.isSuccessful) {
                    val responseBody: MoviesDataModel? = response.body()
                    moviesList.addAll(responseBody!!.result)
                    isMoviesLoad.value=true
                } else {
                    Toast.makeText(context,"Veri Hatası", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<MoviesDataModel>, t: Throwable) {
                Toast.makeText(context,"Veri Hatası", Toast.LENGTH_SHORT).show()
            }

        })


    }
 

    Column() {
        BackButtonx {
            activity.finish()
        }
        LazyColumn(modifier = Modifier.fillMaxSize()){
            itemsIndexed(moviesList){
                    index, item ->
                Card (modifier = Modifier
                    .padding(5.dp)
                    .clickable {
                        intent.putExtra("imdbID", item.imdbID)
                        context.startActivity(intent)
                    }){
                    Row(horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(50.dp)) {
                        AsyncImage(model = item.Poster, contentDescription ="movie image" )
                        Box(modifier = Modifier
                            .width(200.dp)
                            ,
                            contentAlignment = Alignment.Center)
                        {
                            Text(text = item.Title)
                        }
                    }
                }
            }
        }
    }


}



