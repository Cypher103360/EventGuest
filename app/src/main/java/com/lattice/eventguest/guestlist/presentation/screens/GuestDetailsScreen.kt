package com.lattice.eventguest.guestlist.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestDetailsScreen(
    name: String,
    email: String,
    mobile: String,
    address: String,
    arrived: Boolean,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(text = "Guest Details", color = MaterialTheme.colorScheme.onPrimary)
                },
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
                actions = {
                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Add Guest",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.displaySmall.fontSize,
                        fontWeight = FontWeight.Light
                    )
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .background(
                            color = if (!arrived) {
                                Color(0xffe99d2a)
                            } else {
                                Color.Green
                            }
                        )
                ) {
                    Text(
                        text = if (arrived) {
                            "Arrived"
                        } else {
                            "Not Arrived"
                        },
                        modifier = Modifier.padding(4.dp),
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "E-mail",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    )
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = email
                )


                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Phone",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    )
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = mobile
                )


                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Address",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    )
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = address
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GuestDetailScreenPreview(modifier: Modifier = Modifier) {
//    GuestDetailsScreen(
//        name = "Nicole Drew",
//        checkInCount = "2",
//        guestClass = "VIP",
//        navController = rememberNavController()
//    )

}