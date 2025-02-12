package com.lattice.eventguest.guestlist.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lattice.eventguest.guestlist.presentation.qrscanner.CameraPreview
import java.util.Scanner

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "guestList") {
        composable("guestList") {
            GuestListScreen(
                onEvenClick = { message ->
                    navController.navigate("all_guests")
                }
            )
        }
        composable("all_guests") {
            AllGuestsScreen(navController)
        }
        composable("guest_details/{name}/{guestClass}/{checkInCount}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("guestClass") { type = NavType.StringType },
                navArgument("checkInCount") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val guestClass = backStackEntry.arguments?.getString("guestClass") ?: ""
            val checkInCount = backStackEntry.arguments?.getString("checkInCount") ?: ""
            GuestDetailsScreen(
                name = name,
                guestClass = guestClass,
                checkInCount = checkInCount,
                navController = navController
            )
        }
        composable("add_guest") {
            AddGuestScreen(navController)
        }
        composable("camera_preview") {
            ScannerScreen(navController)
        }
    }
}
