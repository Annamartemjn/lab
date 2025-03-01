package com.example.controls.ui.theme.Components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.InputBGColor
import com.example.smartlab.ui.theme.InputFocusedBorderColor
import com.example.smartlab.ui.theme.InputStrokeColor

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: String, // Добавлено текущее значение
    onValueChange: (String) -> Unit, // Добавлен обработчик изменения
    enabled: Boolean = true,
    isError: Boolean = false, // Новый флаг для ошибки
    keyboardType: KeyboardType = KeyboardType.Text // Опциональный тип клавиатуры
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange, // Управляем вводом
        modifier = modifier,
        enabled = enabled,
        isError = isError, // Подсветка ошибки
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            )
        },
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType // Тип клавиатуры
        ),

        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = InputBGColor,
            unfocusedContainerColor = InputBGColor,
            focusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
            unfocusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
            focusedBorderColor = if (isError) Color.Red else InputFocusedBorderColor,
            unfocusedBorderColor = if (isError) Color.Red else InputStrokeColor,
            cursorColor = AccentColor
        ),
        shape = RoundedCornerShape(10.dp),
    )
}

@Preview
@Composable
private fun TextInputPreview() {
}