package com.lattice.eventguest.guestlist.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lattice.eventguest.guestlist.presentation.components.MainEventItem
import com.lattice.eventguest.guestlist.presentation.viewmodel.EventViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestListScreen(
    navController: NavController,
    onEvenClick: (String) -> Unit,
    viewModel: EventViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        viewModel.fetchEvents()
    }
    val eventList by viewModel.eventList.collectAsState()

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
                            onClick = {
                                navController.navigate("add_event")
                            }
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

            LazyColumn {
                items(eventList.size) { item ->
                    val events = eventList[item]
                    MainEventItem(
                        title = events.title,
                        startTime = events.startTimeStamp,
                        endTime = events.startTimeStamp,
                        venue = events.venue,
                        location = events.location,
                        onEventClick = { onEvenClick(events.id) }
                    )
                }
            }

        }
    }
}