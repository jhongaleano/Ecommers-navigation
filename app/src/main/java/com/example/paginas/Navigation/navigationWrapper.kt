package com.example.paginas.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.paginas.pages.HomeScreen
import com.example.paginas.pages.ProductDetailScreen
import  com.example.paginas.Models.*
import com.example.paginas.R
import com.example.paginas.pages.CartScreen
import com.example.paginas.pages.LoginScreen
import com.example.paginas.pages.ProfileScreen
import com.example.paginas.pages.RegisterScreen

@Composable
fun NavigationWrapper(){
    val backStack = rememberNavBackStack(Routes.Login)
    val cartItems = remember { mutableStateListOf<ProductItem>() }
    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.Login> {
                LoginScreen(
                    FirstScreen = {backStack.add(Routes.First(ProductItem(0,"","",0.0,R.drawable.ic_launcher_background,"")))},
                    {backStack.add(Routes.Register)}
                )
            }
            entry<Routes.Register>{
                RegisterScreen(
                    FirstScreen = {backStack.add(Routes.First(ProductItem(0,"","",0.0,R.drawable.ic_launcher_background,"")))},
                    {backStack.add(Routes.Login)}
                )
            }
            entry<Routes.First>{key ->
                HomeScreen(
                    SecondScreen = {},
                    homeProductsList = homeProductsList,
                    {backStack.add(Routes.First(key.product))},
                    {backStack.add(Routes.Third(key.product)) },
                    { seletedProduct ->

                        backStack.add(Routes.Second(product = seletedProduct))
                    },
                    cartpages = {backStack.add(Routes.Cart(homeProductsList,222.40))}
                )

            }
            entry<Routes.Second> {key ->
                ProductDetailScreen(
                    product = key.product,
                    isinCart = false,
                    onAddToCart = { product ->
                      if (cartItems.none{it.id == product.id}){
                            cartItems.add(product)
                      }
                    },
                    onBackClick = {backStack.removeLastOrNull()},
                    {backStack.add(Routes.Third(key.product))},
                    {backStack.add(Routes.First(key.product))},
                    {backStack.add((Routes.Cart(homeProductsList,222.40)))}

                )
            }

            entry<Routes.Cart> {
                val totalCalculado = cartItems.sumOf { it.price }
                CartScreen(
                    cartItems = cartItems,
                    totalPrice = totalCalculado,
                    onClear = {cartItems.clear()},
                    onRemoveItem = {remove ->
                        cartItems.remove(remove)}

                )

            }

            entry<Routes.Third> {key->
                ProfileScreen(
                    onBackClick = {backStack.removeLastOrNull()},
                    {backStack.add(Routes.First(key.product))},
                    {
                        backStack.add(Routes.Second(key.product))},
                    product = key.product
                )
            }
            entry<Routes.Error> {
                Text("Error al consultar la pagina ...")
            }
        }
    )
}