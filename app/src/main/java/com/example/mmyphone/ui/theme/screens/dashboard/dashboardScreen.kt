package com.example.mmyphone.ui.theme.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DashboardScreen(navController: NavController){
    Column {
        Text(
            text = "Welcome To Dashboard", fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
//            .background(Color.LightGray)
                .padding(5.dp)
        )
    }


}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())
}