package com.example.paginas.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.paginas.pages.HomeScreen
import com.example.paginas.pages.ProductDetailScreen
import  com.example.paginas.Models.*
import com.example.paginas.pages.LoginScreen
import com.example.paginas.pages.ProfileScreen
import com.example.paginas.pages.RegisterScreen

@Composable
fun NavigationWrapper(){
    val backStack = remember { mutableStateListOf<Any>(Routes.Login) }

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.Login> {
                LoginScreen(
                    FirstScreen = {usuario,pass -> backStack.add(Routes.CapturarDatos(user = usuario, pass = pass))},
                    {backStack.add(Routes.Register)}
                )
            }
            entry<Routes.Register>{
                RegisterScreen(
                    FirstScreen = {backStack.add(Routes.First)},
                    {backStack.add(Routes.Login)}
                )
            }
            entry<Routes.First>{
                HomeScreen(
                    SecondScreen = {backStack.add(Routes.Second)},
                    homeProductsList = homeProductsList,
                    {backStack.add(Routes.First)},
                    { backStack.add(Routes.Third)},
                )
            }
            entry<Routes.Second> {
                ProductDetailScreen(
                    onBackClick = {backStack.removeLastOrNull()},
                    {backStack.add(Routes.Third)},
                    {backStack.add(Routes.First)},

                )
            }
            entry<Routes.CapturarDatos> {key->
                ProfileScreen(
                    onBackClick = {backStack.removeLastOrNull()},
                    {backStack.add(Routes.First)},
                    {backStack.add(Routes.Second)},
                    key.user,
                    key.pass
                )
            }
            entry<Routes.Error> {
                Text("Error al consultar la pagina ...")
            }
        }
    )
}