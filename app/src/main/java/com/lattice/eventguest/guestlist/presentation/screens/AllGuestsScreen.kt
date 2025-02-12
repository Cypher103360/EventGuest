package com.lattice.eventguest.guestlist.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lattice.eventguest.guestlist.presentation.components.AllGuestListItem
import com.lattice.eventguest.guestlist.presentation.components.GuestSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllGuestsScreen(navController: NavController) {
    val guestList = listOf(
        Guest("Naveen", "Singh", "General", "2"),
        Guest("Priya", "Sharma", "VIP", "1"),
        Guest("Ravi", "Kumar", "General", "3"),
        Guest("Sonal", "Gupta", "General", "5"),
        Guest("Amit", "Yadav", "VIP", "4"),
        Guest("Gaurav", "Kumar", "VIP", "0"),
        Guest("Vishal", "Gola", "Genera", "1"),
        Guest("Neha", "Dhupia", "General", "6"),
        Guest("Sachin", "Tendulker", "VIP", "1")
    )
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
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "go back",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                title = { Text("All guests", color = MaterialTheme.colorScheme.onPrimary) },
                actions = {
                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                        IconButton(
                            onClick = {
                                navController.navigate("add_guest")
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Guest",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("camera_preview")
                },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(
                    imageVector = Icons.Default.QrCodeScanner,
                    contentDescription = "Scan QR Code"
                )
            }
        },
        contentWindowInsets = WindowInsets.safeContent
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary)
            ) {
                GuestSearchBar()
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(guestList.size) { index ->
                    val guest = guestList[index]
                    Box(modifier = Modifier.clickable {
                        navController.navigate("guest_details/${guest.name} ${guest.surname}/${guest.guestClass}/${guest.checkInCount}")
                    }) {
                        AllGuestListItem(
                            name = guest.name,
                            surname = guest.surname,
                            guestClass = guest.guestClass,
                            checkInCount = guest.checkInCount
                        )
                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }

        }
    }
}