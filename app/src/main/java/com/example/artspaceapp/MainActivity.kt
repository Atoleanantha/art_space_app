package com.example.artspaceapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import com.example.artspaceapp.ui.theme.Bluelignt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtWorkGallery().BuildGallery()
                }
            }
        }
    }
}


class ArtWorkGallery{

//    customise list as per your convinice and and in formation

    val artworks= arrayOf(
        R.drawable.andrey_zvyagintsev,
        R.drawable.birmingham_museums,
        R.drawable.heriberto_garcia,
        R.drawable.europeana,
    )

    @Composable
    fun BuildGallery(){
        ViewFrame()
    }
    @Composable
    private fun ViewFrame( modifier:Modifier=Modifier){
        var currentImg by remember { mutableStateOf(0) }
        Column (modifier=modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ImageCard(artworks[currentImg])
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            InfoCard(tile = "Flower Art Work", name = "James Joy", year = "2021")
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))


            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,

                ){
                Button(

                    onClick = {
                        if(currentImg==0){
                            currentImg=artworks.size-1
                        }else if(currentImg<0){
                            currentImg=artworks.size-1
                        }else{
                            currentImg--;
                        }
                    },
                    Modifier.width(120.dp),

                    ) {
                    Text(text = "Previous")


                }
                Button(
                    onClick = {
                        if(currentImg==artworks.size-1){
                            currentImg=0
                        }else if(currentImg<0){
                            currentImg=artworks.size-1
                        }else{
                            currentImg++;
                        }
                    },
                    Modifier.width(120.dp)
                    ,) {
                    Text(text = "Next")
                }
            }

        }
    }

    @Composable
    private fun ImageCard(@DrawableRes img:Int,){
        val modifier=Modifier
        Box(
            modifier= modifier
                .shadow(elevation = 5.dp)
                .fillMaxHeight(0.7f)
                .fillMaxWidth(0.852f)
                .width(350.dp)
                .height(500.dp)
                .aspectRatio(0.6f)
            ,
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = modifier
                    .width(320.dp)
                    .height(470.dp)
                    .aspectRatio(0.6f)
                    .padding(30.dp),
                contentScale = ContentScale.FillHeight,

                painter = painterResource(id = img),
                contentDescription =null )
        }
    }

    @Composable
    private fun InfoCard(name:String,tile:String,year:String,modifier:Modifier=Modifier){
        Box(

            modifier= modifier
                .background(color = Bluelignt)
                .fillMaxHeight(0.4f)
                .fillMaxWidth(0.852f)
                .aspectRatio(2f)
                .height(100.dp)
                .width(350.dp)
                .padding(start = 20.dp, top = 5.dp, bottom = 5.dp)
            ,
            contentAlignment = Alignment.CenterStart
        ){
            Column {
                Text (
                    text = tile,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(text = "$name ( $year )",
                    fontSize = 22.sp
                )

            }
        }
    }

    @Composable
    private fun BottomButtons(){

    }
}
