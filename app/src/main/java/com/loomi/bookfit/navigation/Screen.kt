package com.loomi.bookfit.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Home : Screen("home")
    object Classes : Screen("classes")
    object Bookings : Screen("bookings")
    object Profile : Screen("profile")
    
    companion object {
        const val ARG_CLASS_ID = "classId"
        fun classDetail(classId: String) = "class_detail/$classId"
    }
}
