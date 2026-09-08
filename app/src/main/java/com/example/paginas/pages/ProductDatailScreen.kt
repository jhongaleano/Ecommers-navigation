package com.example.paginas.pages



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paginas.Models.ProductItem
import com.example.paginas.R

import com.example.paginas.ui.theme.*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    product: ProductItem,
    isinCart: Boolean,
    onAddToCart:(ProductItem)-> Unit,
    onBackClick: () -> Unit,
    ThirdScreen: ()-> Unit,
    primera:()-> Unit,
    onNavigateToCart:()-> Unit
) {

    Scaffold(
        // TOP APP BAR (Material 3)
        topBar = {
            TopAppBar(
                title = {
                    Text("Product Details", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = onNavigateToCart) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkTeal)
            )
        },
        // BOTTOM BAR (Material 3)
        bottomBar = {
            NavigationBar(containerColor = DarkTeal) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = primera,
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                        unselectedTextColor = Color.White.copy(alpha = 0.6f)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Productos") },
                    label = { Text("Products") },
                    selected = true,
                    onClick = { },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = AccentGold,
                        selectedTextColor = AccentGold,
                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                        unselectedTextColor = Color.White.copy(alpha = 0.6f),
                        indicatorColor = DarkTeal
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = ThirdScreen,
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                        unselectedTextColor = Color.White.copy(alpha = 0.6f)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MoreVert, contentDescription = "Más") },
                    label = { Text("More") },
                    selected = false,
                    onClick = { },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                        unselectedTextColor = Color.White.copy(alpha = 0.6f)
                    )
                )
            }
        },
        containerColor = PaleGreenBg
    ) { innerPadding ->
        // CONTENIDO PRINCIPAL (Scrollable)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    // 1. Imagen Principal del Producto
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Image(
                            painter = painterResource(product.imageUrl),
                            contentDescription = "Artisan Leather Bag",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // 2. Nombre, Precio
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = product.name,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextDark
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = "price: $${product.price}",
                                fontWeight = FontWeight.Bold,
                                color = TextDark,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // 3. Descripción
                    Text(
                        text = product.description,
                        color = TextLight,
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // 4. Selector de Tallas (Size)
                    Text("Size", fontWeight = FontWeight.Bold, color = TextDark, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))

                    Spacer(modifier = Modifier.height(20.dp))

                    // 5. Selector de Colores (Color)
                    Text("Color", fontWeight = FontWeight.Bold, color = TextDark, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))

                    Spacer(modifier = Modifier.height(32.dp))

                    // 6. Botón Añadir al Carrito (Material 3 Button)

                    if (isinCart) {
                        OutlinedButton(
                            onClick = onNavigateToCart,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("En el carrito — Ver carrito")
                        }
                    } else {
                        Button(
                            onClick = {onAddToCart(product)},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = AccentGold),
                            shape = RoundedCornerShape(26.dp)
                        ) {
                            Text(
                                text = "Add to Cart - $${product.price}",
                                color = DarkTeal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }


                }



    }
}


// ==========================================
// PREVIEW EN ANDROID STUDIO
// ==========================================
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailScreenPreview() {
//    ProductDetailScreen()
}
