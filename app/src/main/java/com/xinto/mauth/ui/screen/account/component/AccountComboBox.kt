package com.xinto.mauth.ui.screen.account.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

@Composable
fun <T : Enum<T>> AccountComboBox(
    values: Array<T>,
    value: T,
    onValueChange: (T) -> Unit,
    label: (@Composable () -> Unit)? = null
) {
    val (expanded, setExpanded) = remember {
        mutableStateOf(false)
    }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = setExpanded
    ) {
        OutlinedTextField(
            modifier = Modifier.menuAnchor(),
            value = value.name,
            onValueChange = {},
            singleLine = true,
            label = label,
            readOnly = true,
            trailingIcon = {
                val iconRotation by animateFloatAsState(if (expanded) 180f else 0f)
                Icon(
                    modifier = Modifier.rotate(iconRotation),
                    imageVector = Icons.Rounded.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { setExpanded(false) }
        ) {
            values.forEach {
                DropdownMenuItem(
                    text = { Text(it.name) },
                    onClick = {
                        setExpanded(false)
                        onValueChange(it)
                    }
                )
            }
        }
    }
}
