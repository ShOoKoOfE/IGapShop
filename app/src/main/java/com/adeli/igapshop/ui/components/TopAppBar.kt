package com.adeli.igapshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
  title: String,
  icon: ImageVector,
  onIconClick: () -> Unit,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(56.dp)
      .background(color = MaterialTheme.colors.primaryVariant)
  ) {
    Image(
      imageVector = icon,
      contentDescription = "Top App Bar Icon",
      colorFilter = ColorFilter
        .tint(MaterialTheme.colors.onPrimary),
      modifier = Modifier
        .clickable(onClick = onIconClick)
        .padding(16.dp)
        .align(Alignment.CenterVertically)
    )
    Text(
      text = title,
      color = MaterialTheme.colors.onPrimary,
      style = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
      ),
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.CenterVertically)
        .padding(start = 16.dp, end = 16.dp)
    )
  }
}