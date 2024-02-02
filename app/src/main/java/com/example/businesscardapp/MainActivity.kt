package com.example.businesscardapp

import android.media.Image
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardView()
                }
            }
        }
    }
}

//@Preview
@Composable
fun MainInformation() {
    val faceImage = painterResource(id = R.drawable.businesscardface)
    Column(
        Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start) {
        Image(painter = faceImage, contentDescription = "Photo of the developer",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f)}),
            modifier = Modifier
                .shadow(6.dp)
                .clip(RoundedCornerShape(22.dp))
                .border(
                    BorderStroke(2.dp, Color.Black),
                    RoundedCornerShape(22.dp)
                )
                .padding(2.dp)

            )

        Text(text = "Georgii Lopatko",
            fontSize = 30.sp,
            color = Color.White,
            )
        Text(text = "Trainee Android Developer",
            fontSize = 20.sp,
            color = Color.White
            )
    }
}

//@Preview
@Composable
fun ContactInformation() {
    Column(
//        horizontalAlignment = Alignment.Start,
//        verticalArrangement = Arrangement.Bottom
        Modifier.padding(start = 50.dp, end = 50.dp, bottom = 15.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,

        ) {
        Text(text = "+79005139776",
            color = Color.White)
        Spacer(Modifier.size(5.dp))
        Text(text = "lopatkogeorgii@gmail.com",
            color = Color.White)
        Spacer(Modifier.size(5.dp),)
        Text(text = "@lopatkoger",
            color = Color.White,
            )
    }
}

@Composable
fun BackgroundImage() {
    val backgroundImage = painterResource(id = R.drawable.businesscardbackground)
    Image(painter = backgroundImage, contentDescription = "Background image",
        contentScale = ContentScale.Crop,
        alpha = 0.8F,
        modifier = Modifier
            .fillMaxSize())
}

@Composable
fun BusinessCardView() {

    Column(
        Modifier
            .paint(
                // Replace with your image id
                painterResource(id = R.drawable.businesscardbackground),
                contentScale = ContentScale.FillBounds)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        
        ) {
//        BackgroundImage()
        MainInformation()
        ContactInformation()
    }
}

@Preview
@Composable
fun CardPreview() {
    BusinessCardAppTheme {
        BusinessCardView()
    }
}