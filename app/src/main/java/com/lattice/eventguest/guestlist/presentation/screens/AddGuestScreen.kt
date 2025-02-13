package com.lattice.eventguest.guestlist.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lattice.eventguest.guestlist.presentation.components.AddGuestListItem
import com.lattice.eventguest.guestlist.presentation.viewmodel.GuestViewModel
import com.lattice.eventguest.guestlist.presentation.viewmodel.PeopleViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGuestScreen(
    eventId: String,
    navController: NavController,
    viewModel: PeopleViewModel = hiltViewModel(),
    guestViewModel: GuestViewModel = hiltViewModel()
) {
    val guestId  =  mutableListOf<String>()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "go back",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                title = {
                    Text(text = "Add Guest", color = MaterialTheme.colorScheme.onPrimary)
                },
                actions = {
                    TextButton(
                        onClick = {
                        guestViewModel.addGuestToEvent(eventId, guestId)
                        navController.popBackStack()
                    }) {
                        Text(text = "DONE", color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            LazyColumn {
                items(viewModel.peopleList.size) { item ->
                    val guest = viewModel.peopleList[item]
                    val isChecked = remember { mutableStateOf(false) }
                    AddGuestListItem(
                        guestName = guest.name,
                        isChecked = isChecked.value,
                        onCheckChanged = {
                            isChecked.value = it
                            if (it) {
                                guestId.add(guest.id)
                            } else {
                                guestId.remove(guest.id)
                            }
                            println("Guest $guestId checked")
                        }
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }
        }
    }
}