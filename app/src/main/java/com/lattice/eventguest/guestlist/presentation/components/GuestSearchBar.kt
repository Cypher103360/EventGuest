package com.lattice.eventguest.guestlist.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestSearchBar() {
    var query by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(4.dp), // Keeps the card rectangular
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { Text("Search guests") },
            singleLine = true,
            shape = RectangleShape, // Ensures the TextField itself is rectangular
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface, // Background when not focused
                focusedContainerColor = MaterialTheme.colorScheme.surface, // Background when focused
                unfocusedIndicatorColor = Color.Transparent, // Removes the underline
                focusedIndicatorColor = Color.Transparent,   // Removes the underline when focused
                disabledIndicatorColor = Color.Transparent,  // Removes underline when disabled
                errorIndicatorColor = Color.Transparent      // Removes underline on error
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = if (query.isNotBlank()) {
                {
                    IconButton(onClick = { query = "" }) {
                        Icon(
                            modifier = Modifier.padding(end = 8.dp),
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear search",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else null
        )
    }
}

