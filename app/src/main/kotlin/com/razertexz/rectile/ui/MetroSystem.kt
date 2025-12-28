package com.razertexz.rectile.ui

import androidx.annotation.DrawableRes
import androidx.annotation.ColorInt
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.razertexz.rectile.R

private val openSansFamily = FontFamily(
    Font(R.font.open_sans_variable)
)

@Composable
internal fun MetroTile(
    label: String,
    @DrawableRes iconResId: Int,
    width: Dp,
    height: Dp = width,
    @ColorInt backgroundColor: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width, height)
            .background(color = Color(backgroundColor))
            .clickable(onClick = onClick)
            .padding(6.dp)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            colorFilter = ColorFilter.tint(Color.White),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )

        BasicText(
            text = label,
            style = TextStyle(
                fontFamily = openSansFamily,
                fontSize = 12.sp,
                color = Color.White
            ),
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}