package com.example.coffeeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeeapp.ui.theme.CoffeeAppTheme
import com.example.coffeeapptheme.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf("Cappuccino") }

    Scaffold(
        containerColor = Color.Black,
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .background(Color.Black)
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Find the best \ncoffee for you",
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }

            item {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            modifier = Modifier.size(28.dp),
                            tint = Color.Gray
                        )
                    },
                    placeholder = {
                        Text(
                            "Find Your Coffee...",
                            fontSize = 20.sp,
                            color = Color.Gray
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(horizontal = 5.dp, vertical = 5.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedPlaceholderColor = Color.Gray,
                        unfocusedPlaceholderColor = Color.Gray,
                        containerColor = Color(0xFF1F1F1F)
                    ),
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }

            item {
                val categories = listOf("Cappuccino", "Espresso", "Latte", "Flat White")
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(categories.size) { index ->
                        val category = categories[index]
                        FilterChip(
                            selected = selectedTab == category,
                            onClick = { selectedTab = category },
                            label = { Text(category, color = Color.White) }
                        )
                    }
                }
            }

            val coffeeList = listOf(
                Coffee("Cappuccino with Oat Milk", "$4.20", R.drawable.cappuccino),
                Coffee("Cappuccino Freddo", "$3.50", R.drawable.cpc),
                Coffee("Espresso Shot", "$2.50", R.drawable.espresso),
                Coffee("Latte Love", "$4.00", R.drawable.latte),
                Coffee("Flat White Classic", "$3.80", R.drawable.espresso),
                Coffee("Caramel Macchiato", "$5.00", R.drawable.espresso),
                Coffee("Mocha Magic", "$4.75", R.drawable.latte)
            )

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                ) {
                    items(coffeeList.filter { it.name.contains(selectedTab, ignoreCase = true) }) { coffee ->
                        Card(
                            modifier = Modifier
                                .width(150.dp)
                                .height(200.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1F1F)),
                            shape = RoundedCornerShape(12.dp),
                            onClick = {
                                navController.navigate("detail/${coffee.name}/${coffee.price}")
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(
                                    painter = painterResource(id = coffee.imageRes),
                                    contentDescription = coffee.name,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                )
                                Text(
                                    text = coffee.name,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    maxLines = 2
                                )
                                Text(
                                    text = coffee.price,
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Special for you",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            val specialCoffeeList = listOf(
                Coffee("Vanilla Latte", "$4.50", R.drawable.latte),
                Coffee("Caramel Macchiato", "$5.00", R.drawable.espresso),
                Coffee("Hazelnut Mocha", "$5.20", R.drawable.espresso)
            )

            items(specialCoffeeList) { specialCoffee ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .border(2.dp, Color(0xFFD17842), RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1F1F)),
                    shape = RoundedCornerShape(16.dp),
                    onClick = {
                        navController.navigate("detail/${specialCoffee.name}/${specialCoffee.price}")
                    }
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = specialCoffee.imageRes),
                            contentDescription = specialCoffee.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(16.dp))
                        )

                        Column(
                            modifier = Modifier
                                .weight(2f)
                                .padding(12.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = specialCoffee.name,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Special Price: ${specialCoffee.price}",
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = {
                                    navController.navigate("detail/${specialCoffee.name}/${specialCoffee.price}")
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD17842)),
                                modifier = Modifier.height(36.dp)
                            ) {
                                Text(text = "Order", color = Color.White, fontSize = 12.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFF1F1F1F)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            selected = false,
            onClick = {}
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    CoffeeAppTheme {  // Thêm theme vào đây
        val context = LocalContext.current
        val navController = remember { androidx.navigation.testing.TestNavHostController(context) }
        HomeScreen(navController = navController)
    }
}

