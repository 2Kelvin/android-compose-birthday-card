package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    Greeting("RocketMan")
                }
            }
        }
    }
}

//other functions - Composable functions ... etc
// they're declared just beneath/ after main ComponentActivity function
// then invoked inside the ComponentActivity function which renders all the UIs they describe
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name")
}

// Composable functions can call other Composable functions inside them
// eg. BirthdayCardPreview calling Greeting inside it
// the 'Preview' Composable functions are just for displaying your changes in the Design area
// they don't change the actual code that'll be in the app/phone/emulator
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        Greeting("RocketMan")
    }
}

// Composable functions are just like "Functional Components in Javascript"
// Composable functions don't return anything
// they just describe the UI
// they must be start with a "CAPITAL LETTER"
// they are things not actions || they are nouns not verbs eg. BirthdayCard, Icon, BlackButton etc...