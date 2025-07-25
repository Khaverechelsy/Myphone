package com.example.mmyphone.ui.theme.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mmyphone.R
import com.example.mmyphone.data.AuthViewModel
import com.example.mmyphone.navigation.ROUTE_LOGIN


@Composable
fun registerScreen(navController: NavController){
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("") }
    var authViewModel: AuthViewModel = viewModel()
    Box(){
        Image(painter = painterResource(id = R.drawable.background),
            contentDescription = "Image background",
            contentScale = ContentScale.FillBounds)
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Register Here", fontSize = 35.sp,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
//                .background(Color.LightGray)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Image logo" ,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp) ,
            contentScale = ContentScale.Fit)
        OutlinedTextField(value = username,
            onValueChange = {username=it},
            label={Text("Enter Username")},
            placeholder ={Text("Please enter username")},
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person icon")},
            modifier  = Modifier.fillMaxWidth(0.8f))

        OutlinedTextField(value = fullname,
            onValueChange = {fullname=it},
            label={Text("Enter fullname")},
            placeholder ={Text("Please enter fullname ")},
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person icon")},
            modifier  = Modifier.fillMaxWidth(0.8f))



        OutlinedTextField(value = email, onValueChange ={email=it},
            label = {Text("Enter Email")},
            textStyle = TextStyle(Color.Blue),
            placeholder = {Text("Please enter email")},
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email icon")},
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))

        OutlinedTextField(value = password,
            onValueChange = {password=it},
            label={Text("Enter password")},
            textStyle = TextStyle(Color.Blue),
            placeholder ={Text("Please enter password", color = Color.White, fontWeight = FontWeight.Bold)},
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password icon")},
            visualTransformation = PasswordVisualTransformation(),
            modifier  = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = (KeyboardType.Password)))

        OutlinedTextField(value = confirmpassword,
            onValueChange = {confirmpassword=it},
            textStyle = TextStyle(Color.Blue),
            label={Text("Enter Confirm Password")},
            placeholder ={Text("Please confirm password")},
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Person icon")},
            visualTransformation = PasswordVisualTransformation(),
            modifier  = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = (KeyboardType.Password)) )

        Spacer(modifier = Modifier.height(10.dp))
        val context = LocalContext.current

        Button(onClick = {
            authViewModel.signup(username = username, fullname = fullname, email=email,
                password=password,confirmpassword=confirmpassword,
                navController=navController, context =context)
        },
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.fillMaxWidth(0.8f))
        { Text(text = "Register", color = Color.Red) }

        Text(text = "If already registered,Login here",
            color = Color.White,
            modifier = Modifier.clickable { navController.navigate(ROUTE_LOGIN) })


    }
}

@Preview(showBackground = true, showSystemUi = true
)
@Composable
fun registerScreenPreview(){
    registerScreen(rememberNavController())
}






