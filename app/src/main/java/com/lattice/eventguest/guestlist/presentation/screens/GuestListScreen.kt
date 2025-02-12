package com.lattice.eventguest.guestlist.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lattice.eventguest.guestlist.presentation.components.DemoEventItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestListScreen(
    onEvenClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Guest List", color = MaterialTheme.colorScheme.onPrimary) },
                actions = {
                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Guest",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More Options",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            )
        }
    ) { contentPadding ->
        Column(modifier = Modifier
            .padding(contentPadding)
            .fillMaxSize()) {
            DemoEventItem(
                title = "A demo event",
                date = "19 Feb 2025 01:30",
                onEventClick = { onEvenClick("A demo event") }
            )
        }
    }
}