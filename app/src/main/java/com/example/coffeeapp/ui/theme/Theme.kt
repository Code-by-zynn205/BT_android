package com.example.coffeeapp.ui.theme

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

// Định nghĩa bảng màu cho chế độ tối
private val DarkColorScheme = darkColorScheme(
    primary = CoffeeBrown,      // Màu chính (ví dụ: nâu đậm cho nút bấm)
    onPrimary = White,          // Màu chữ trên nền màu chính
    background = DarkBrown,     // Nền tối đồng bộ với chế độ Dark Mode
    onBackground = LightBrown   // Màu chữ trên nền tối (màu sáng hơn để dễ đọc)
)

// Hàm chính áp dụng theme cho ứng dụng
@Composable
fun CoffeeAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}

// Preview cho chế độ tối
@Preview(
    name = "Dark Mode Preview",
    uiMode = Configuration.UI_MODE_NIGHT_YES, // Kích hoạt chế độ tối
    showBackground = true // Hiển thị nền trong bản preview
)
@Composable
fun DarkModePreview() {
    CoffeeAppTheme {
        // Hiển thị nội dung để xem trước
        // Đây có thể là bất kỳ giao diện nào bạn muốn kiểm tra
        SampleCoffeeContent()
    }
}

// Nội dung mẫu để hiển thị trong preview
@Composable
fun SampleCoffeeContent() {
    // Đây là nơi bạn sẽ hiển thị giao diện mẫu, ví dụ một Text hoặc Layout
    androidx.compose.material3.Text(
        text = "Find the best coffee for you",
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onBackground
    )
}
