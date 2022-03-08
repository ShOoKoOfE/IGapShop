package com.adeli.ui_login.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeli.core.domain.UIComponentState

@Composable
fun GenericDialog(
    modifier: Modifier = Modifier,
    title: String,
    description: String? = null,
    mutableState: MutableState<LoginState>
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
        },
        title = {
            Text(
                text = title
            )
        },
        text = {
            if (description != null) {
                Text(text = description)
            }
        },
        buttons = {
            Button(
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(20.dp),
                onClick = {
                mutableState.value = mutableState.value.copy(uiComponentState = UIComponentState.Hide)
            }) {
                Text("Ok")
            }
        }
    )
}