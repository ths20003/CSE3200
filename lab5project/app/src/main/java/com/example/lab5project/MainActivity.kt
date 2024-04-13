package com.example.lab5project

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lab5project.data.Datasource
import com.example.lab5project.model.RadioStation
import com.example.lab5project.ui.theme.RadioAppTheme
import com.example.lab5project.viewmodel.ViewModelMediaPlayer


class MainActivity : ComponentActivity() {

    private val mediaPlayerViewModel by viewModels<ViewModelMediaPlayer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadioAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RadioApp(context = applicationContext, mediaPlayerViewModel = mediaPlayerViewModel)
                }
            }
        }
    }
}

@Composable
fun RadioStationCard(context: Context, radioStation: RadioStation, mediaPlayerViewModel: ViewModelMediaPlayer, modifier: Modifier = Modifier) {
    val isPlaying = remember { mutableStateOf(false) }

    Card(
        modifier = modifier.clickable {
            if (isPlaying.value) {
                mediaPlayerViewModel.pauseAudio()
                isPlaying.value = false
            } else {
                mediaPlayerViewModel.playAudio(context, context.getString(radioStation.url))
                isPlaying.value = true
            }
        }
    ){
        Column() {
            Image(
                painter = painterResource(id = radioStation.imageResourceID),
                contentDescription = stringResource(id = radioStation.radioStationName),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = context.getString(radioStation.radioStationName),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun RadioApp(context: Context, mediaPlayerViewModel: ViewModelMediaPlayer){
    val radioStationList = Datasource().loadRadioStations() // Change function call
    RadioStationList(radioStationList = radioStationList, context = context, mediaPlayerViewModel = mediaPlayerViewModel)
}

@Composable
fun RadioStationList(radioStationList: List<RadioStation>, context: Context, mediaPlayerViewModel: ViewModelMediaPlayer, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier){
        items(radioStationList) { radioStation ->
            RadioStationCard( // Change function call
                context = context,
                radioStation = radioStation,
                mediaPlayerViewModel = mediaPlayerViewModel,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}






