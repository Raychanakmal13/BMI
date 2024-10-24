// File: androidApp/src/main/java/com/example/bmi/android/MainActivity.kt

package com.example.bmi.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bmi.BmiCalculator
import com.example.bmi.Gender

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiApp()
        }
    }
}

@Composable
fun BmiApp() {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf(Gender.MALE) }
    var result by remember { mutableStateOf("") }
    var advice by remember { mutableStateOf("") }

    val bmiCalculator = BmiCalculator()

    Column(
        modifier = Modifier.fillMaxSize().padding(2.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Height (cm)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { gender = Gender.MALE }) {
                Text("Male")
            }
            Button(onClick = { gender = Gender.FEMALE }) {
                Text("Female")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val bmi = bmiCalculator.calculateBMI(weight.toDouble(), height.toDouble(), gender)
            result = "Your BMI: %.2f".format(bmi)
            advice = bmiCalculator.getHealthAdvice(bmi)
        }) {
            Text("Calculate BMI")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = result, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = advice, color = Color.White)
    }
}
