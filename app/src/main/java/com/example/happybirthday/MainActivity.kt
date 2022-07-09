package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage("Happy Birthday Julie", " -from- Malika")
                }
            }
        }
    }
}

// Composable functions are just like "Functional Components in Javascript"
// Composable functions don't return anything
// they just describe the UI
// they must be start with a "CAPITAL LETTER"
// they are things not actions || they are nouns not verbs eg. BirthdayCard, Icon, BlackButton etc...
//other functions - Composable functions ... etc
// are declared just beneath/ after main ComponentActivity function
// then invoked inside the ComponentActivity function which renders all the UIs they describe
@Composable
fun BirthdayGreetingWithText(message:String, from:String) {
    Column{
        Text(
            text = message,
            fontSize = 24.sp
        )
        Text(
            text = from,
            fontSize = 12.sp
        )
    }
}

// res folder: drawable(images), mipmap(launcher icons) & values(strings)
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    // painterResource() loads the 'androidparty' image found in the drawable subfolder & in the resources folder
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null, // content description defines the purpose of a UI element | since here it's set to null, the TalkBack skips this image composable
            modifier = Modifier //Modifiers decorate/ add behavior to Jetpack Compose UI elements
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText("Happy Birthday Julie", " -from- Malika")
    }
}
// Composable functions can call other Composable functions inside them
// eg. BirthdayCardPreview calling Greeting inside it
// the 'Preview' Composable functions are just for displaying your changes in the Design area
// they don't change the actual code that'll be in the app/phone/emulator
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage("Happy Birthday Julie", " -from- Malika")
    }
}