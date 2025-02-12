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
import androidx.navigation.NavController
import com.lattice.eventguest.guestlist.data.Guest
import com.lattice.eventguest.guestlist.presentation.components.AddGuestListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGuestScreen(
    navController: NavController
) {
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
                    TextButton(onClick = {}) {
                        Text(text = "DONE", color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            LazyColumn {
                items(guestList.size) { item ->
                    val guest = guestList[item]
                    val isChecked = remember { mutableStateOf(false) }
                    AddGuestListItem(
                        guestName = "${guest.name} ${guest.surname}",
                        isChecked = isChecked.value,
                        onCheckChanged = {
                            isChecked.value = it
                            println("Guest ${guest.name} ${guest.surname} checked")
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