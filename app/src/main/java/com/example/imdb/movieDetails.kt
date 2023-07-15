package com.example.imdb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.imdb.ui.theme.IMDBTheme
import retrofit2.Call

class movieDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            detaylıListe(intent,this,this)
        }
    }
}
@Composable
fun BackButton(onBackPressed: () -> Unit) {
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
fun detaylıListe(intent: Intent,context: Context,activity: ComponentActivity){
    val movieId = intent.getStringExtra("imdbID")
    var movie = remember { mutableStateOf(ResultX("","","","","","","","","","","","","","","","",
        emptyList(),"","","","","","","","")) }
    val isMoviesLoad = remember { mutableStateOf(false) }


    if (isMoviesLoad.value==false){
        val call = apiService.gatNewData(
            "apikey 5M9tXgFhIfWYuzM5ofVnB2:25QC4JBUyujhquUAUFQmzN",
            "application/json",
            movieId!!
        )
        call.enqueue(object : retrofit2.Callback<newDetails> {
            override fun onResponse(call: Call<newDetails>, response: retrofit2.Response<newDetails>) {
                if (response.isSuccessful) {
                    val responseBody: newDetails? = response.body()
                    isMoviesLoad.value=true
                    movie.value=responseBody!!.result
                } else {
                    Toast.makeText(context,"Veri Hatası", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<newDetails>, t: Throwable) {
                Toast.makeText(context,"Veri Hatası", Toast.LENGTH_SHORT).show()
            }

        })


    }

    Column(modifier = Modifier
        .fillMaxSize()
        ) {
            BackButton {
                activity.finish()
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
                contentAlignment = Alignment.Center
                ){
                AsyncImage(model = movie.value.Poster, contentDescription = "movie poster")
            }
            Column {
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Name: ${movie.value.Title}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)
                    
                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Year: ${movie.value.Year}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Actors: ${movie.value.Actors}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Awards: ${movie.value.Awards}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Country: ${movie.value.Country}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Director: ${movie.value.Director}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "imdbRating: ${movie.value.imdbRating}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "imdbVotes: ${movie.value.imdbVotes}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Language: ${movie.value.Language}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Metascore: ${movie.value.Metascore}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }
                Card(modifier = Modifier.padding(5.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(text = "Writer: ${movie.value.Writer}", modifier = Modifier.padding(5.dp), fontSize = 20.sp)

                }





            }




    }


}
