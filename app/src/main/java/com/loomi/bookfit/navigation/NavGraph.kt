package com.loomi.bookfit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.loomi.bookfit.ui.screens.SplashScreen
import com.loomi.bookfit.ui.screens.auth.LoginScreen
import com.loomi.bookfit.ui.screens.home.HomeScreen
import com.loomi.bookfit.ui.screens.classes.ClassesScreen
import com.loomi.bookfit.ui.screens.bookings.BookingsScreen
import com.loomi.bookfit.ui.screens.profile.ProfileScreen

@Composable
fun BookFitNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Splash Screen
        composable(route = Screen.Splash.route) {
            SplashScreen(
                onNavigateToLogin = { navController.navigate(Screen.Login.route) },
                onNavigateToHome = { navController.navigate(Screen.Home.route) { popUpTo(0) } }
            )
        }
        
        // Auth Screens
        composable(route = Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(Screen.Home.route) { popUpTo(0) } },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        // Main Screens
        composable(route = Screen.Home.route) {
            HomeScreen(
                onClassClick = { classId -> 
                    navController.navigate(Screen.Classes.route)
                },
                onBookingsClick = {
                    navController.navigate(Screen.Bookings.route)
                },
                onProfileClick = {
                    navController.navigate(Screen.Profile.route)
                }
            )
        }
        
        composable(route = Screen.Classes.route) {
            ClassesScreen(
                onBackClick = { navController.popBackStack() },
                onClassClick = { classId ->
                    // Navigate to class detail
                    // navController.navigate(Screen.ClassDetail.createRoute(classId))
                }
            )
        }
        
        composable(route = Screen.Bookings.route) {
            BookingsScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        
        composable(route = Screen.Profile.route) {
            ProfileScreen(
                onBackClick = { navController.popBackStack() },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}
