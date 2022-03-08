package com.adeli.igapshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adeli.igapshop.ui.navigation.Screen

@Composable
private fun AppDrawerHeader() {
  Row(modifier = Modifier.fillMaxWidth()) {
    Image(
      imageVector = Icons.Filled.Menu,
      contentDescription = "Drawer Header Icon",
      colorFilter = ColorFilter
        .tint(MaterialTheme.colors.onSurface),
      modifier = Modifier.padding(16.dp)
    )
    Text(
      text = "IGap Shop",
      modifier = Modifier
        .align(alignment = Alignment.CenterVertically)
    )
  }
}

@Composable
private fun ScreenNavigationButton(
  icon: ImageVector,
  label: String,
  isSelected: Boolean,
  onClick: () -> Unit
) {
  val colors = MaterialTheme.colors
  val imageAlpha = if (isSelected) {
    1f
  } else {
    0.6f
  }
  val textColor = if (isSelected) {
    colors.primary
  } else {
    colors.onSurface.copy(alpha = 0.6f)
  }
  val backgroundColor = if (isSelected) {
    colors.primary.copy(alpha = 0.12f)
  } else {
    colors.surface
  }
  Surface(
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 8.dp, end = 8.dp, top = 8.dp),
    color = backgroundColor,
    shape = MaterialTheme.shapes.small
  ) {
    Row(
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .padding(4.dp)
    ) {
      Image(
        imageVector = icon,
        contentDescription = "Screen Navigation Button",
        colorFilter = ColorFilter.tint(textColor),
        alpha = imageAlpha
      )
      Spacer(Modifier.width(16.dp))
      Text(
        text = label,
        style = MaterialTheme.typography.body2,
        color = textColor,
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

@Composable
fun AppDrawer(
  navController: NavController,
  currentScreen: Screen.ProductList,
  closeDrawerAction: () -> Unit
) {
  Column(modifier = Modifier.fillMaxSize()) {
    AppDrawerHeader()
    Divider(color = MaterialTheme.colors.onSurface.copy(alpha = .2f))
    ScreenNavigationButton(
      icon = Icons.Filled.Home,
      label = "Product List",
      isSelected = currentScreen == Screen.ProductList,
      onClick = {
        navController.navigate(Screen.ProductList.route)
        closeDrawerAction()
      }
    )
    ScreenNavigationButton(
      icon = Icons.Filled.Person,
      label = "Login",
      isSelected = true,
      onClick = {
        navController.navigate(Screen.Login.route)
        closeDrawerAction()
      }
    )
  }
}
