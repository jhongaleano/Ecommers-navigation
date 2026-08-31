package com.example.paginas.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paginas.ui.theme.*

@Composable
fun LoginScreen(FirstScreen: ()-> Unit,RegisScreen:()-> Unit){
    var value by remember{mutableStateOf("Hello")}

    Surface(
        modifier = Modifier.background(Color.White)
    ) {

        Scaffold() {innerpadding ->
            Column(modifier = Modifier
                .padding(innerpadding)
                .fillMaxSize(), Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Inicio  de Session",
                    modifier = Modifier.padding(bottom = 45.dp),
                    fontSize = 27.sp,
                    color = DarkTeal,
                    fontStyle = FontStyle.Italic
                )

                OutlinedTextField(
                    value = value,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = DarkTeal,
                        unfocusedBorderColor = Color.Gray,

                        ),
                    onValueChange = { value = it },
                    label = { Text(text = "Usuario") },
                    modifier = Modifier.padding(vertical = 25.dp)
                )

                OutlinedTextField(
                    value = value,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = DarkTeal,
                        unfocusedBorderColor = Color.Gray,

                        ),
                    onValueChange = { value = it },
                    label = { Text(text = "Contraseña") },
                    modifier = Modifier.padding(bottom = 25.dp)
                )

                Button(FirstScreen,
                    modifier = Modifier.padding(bottom = 12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkTeal,
                        contentColor = Color.White
                    )
                ) {
                    Text("Entrar")


                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Text("¿No tienes Cuenta?")



                    TextButton(RegisScreen,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = DarkTeal
                        )
                    ) {
                        Text("Registrate aqui")
                    }
                }
            }
        }

    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview(){
    //LoginScreen()
}