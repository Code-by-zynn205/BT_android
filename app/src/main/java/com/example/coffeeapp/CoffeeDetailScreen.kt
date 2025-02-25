package com.example.coffeeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star // Thêm import này
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapptheme.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeDetailScreen(coffeeName: String, price: String) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Chi Tiết Cà Phê", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { /* Xử lý quay lại */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Quay lại",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF1F1F1F)
                )
            )
        },
        containerColor = Color.Black,
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Hình ảnh cà phê
            Image(
                painter = painterResource(id = R.drawable.cappuccino), // Sử dụng drawable phù hợp
                contentDescription = coffeeName,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tên và Đánh giá cà phê
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = coffeeName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.Star, // Sử dụng biểu tượng sao sẵn có từ Material Design
                    contentDescription = "Đánh giá",
                    tint = Color(0xFFD17842),
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "4.5 (180)",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Thông tin cà phê
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Rang vừa",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                // Thêm các biểu tượng/thông tin khác nếu cần
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mô tả
            Text(
                text = "Một loại đồ uống dựa trên cà phê làm chủ yếu từ espresso và sữa. Đọc Thêm",
                color = Color.Gray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lựa chọn kích thước
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf("S", "M", "L").forEach { size ->
                    Button(
                        onClick = { /* Xử lý lựa chọn kích thước */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (size == "M") Color(0xFFD17842) else Color(0xFF1F1F1F)
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Text(text = size, color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Giá và Nút Mua
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = price,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { /* Xử lý mua hàng */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD17842)),
                    modifier = Modifier
                        .height(48.dp)
                        .width(120.dp)
                ) {
                    Text("Mua Ngay", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Phần đánh giá sản phẩm
            Text(
                text = "Đánh Giá Sản Phẩm",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Danh sách mẫu đánh giá sử dụng Column thay vì LazyColumn
            val reviews = listOf(
                "Cà phê tuyệt vời! Hương vị espresso và sữa cân bằng hoàn hảo. Rất khuyến khích! - John D.",
                "Mượt mà và đậm đà, lựa chọn buổi sáng yêu thích của tôi. - Sarah L.",
                "Hương vị ngon, nhưng giá hơi cao so với phần. - Mike T."
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                reviews.forEach { review ->
                    Text(
                        text = review,
                        color = Color.Gray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }

}