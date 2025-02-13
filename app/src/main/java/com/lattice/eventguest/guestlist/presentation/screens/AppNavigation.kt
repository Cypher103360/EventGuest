package com.lattice.eventguest.guestlist.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "guestList") {
        composable("guestList") { navBackStackEntry ->
            GuestListScreen(
                navController = navController,
                onEvenClick = { eventId ->
                    println("Event clicked: $eventId")
                    navController.navigate("all_guests/$eventId")
                }
            )
        }
        composable("all_guests/{eventId}") { navBackStackEntry ->
            val eventId = navBackStackEntry.arguments?.getString("eventId") ?: ""
            AllGuestsScreen(
                eventId = eventId,
                navController = navController,
                onGuestClick = { guest ->
                    navController.navigate("guest_details/${guest.name}/${guest.email}/${guest.mobile}/${guest.address}/${guest.arrived}")
                }
            )
        }
        composable("guest_details/{name}/{email}/{mobile}/{address}/{arrived}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val mobile = backStackEntry.arguments?.getString("mobile") ?: ""
            val address = backStackEntry.arguments?.getString("address") ?: ""
            val arrived = backStackEntry.arguments?.getBoolean("arrived") ?: false

            println("Name: $name- Email: $email- Mobile: $mobile- Address: $address- Arrived: $arrived")
            GuestDetailsScreen(
                name = name,
                email = email,
                mobile = mobile,
                address = address,
                arrived = arrived,
                navController = navController
            )
        }
        composable("add_guest/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId") ?: ""
            AddGuestScreen(eventId = eventId, navController = navController)
        }
        composable("camera_preview/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId") ?: ""
            ScannerScreen(eventId = eventId, navController = navController)
        }
        composable("add_event") {
            AddEventScreen(navController = navController)
        }
    }
}
