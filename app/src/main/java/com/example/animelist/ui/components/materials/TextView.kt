package com.example.animelist.ui.components.materials

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.animelist.ui.theme.QuickSandFonts
import com.example.animelist.ui.theme.TextColor

@Composable
fun TextView(
    text: String,
    size: Int = 16,
    color: Color = TextColor,
    isBold: Boolean = false,
    maxLines: Int? = Int.MAX_VALUE,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = size.sp,
        fontFamily = QuickSandFonts,
        color = color,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines!!,
        fontWeight = if(isBold) FontWeight.Bold else FontWeight.Normal,
        modifier = modifier
    )
}