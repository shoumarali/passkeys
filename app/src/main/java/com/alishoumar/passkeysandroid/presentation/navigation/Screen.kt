package com.alishoumar.passkeysandroid.presentation.navigation

sealed class Screen (val route:String){

    object SignUp:Screen(route = "singUp_screen")
    object OtherSignUp:Screen(route = "other_signup_screen")
    object Login:Screen(route = "login_screen")
    object RootAuth:Screen(route = "root_auth_screen")
}