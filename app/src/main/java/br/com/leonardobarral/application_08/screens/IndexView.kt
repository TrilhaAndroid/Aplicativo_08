package br.com.leonardobarral.application_08.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun IndexView(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        Button(onClick = {
            navController.navigate("home")
        }) {
            Text(
                text = "Home",
                fontStyle = FontStyle.Normal,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ) }
    }
}