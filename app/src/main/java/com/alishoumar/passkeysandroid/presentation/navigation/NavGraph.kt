package com.alishoumar.passkeysandroid.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alishoumar.passkeysandroid.presentation.screens.login.LoginScreen
import com.alishoumar.passkeysandroid.presentation.screens.otherOptionsScreen.OtherOptionsScreen
import com.alishoumar.passkeysandroid.presentation.screens.rootAuth.RootAuthScreen
import com.alishoumar.passkeysandroid.presentation.screens.signup.SignUpScreen
import com.alishoumar.passkeysandroid.presentation.screens.signup.SignUpViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun SetUpNavGraph(
    startDestination:String,
    navController:NavHostController
) {

    NavHost(navController = navController, startDestination = startDestination) {
        rootRoute(
            onSignUpClick = {navController.navigate(Screen.SignUp.route)},
            onLoginClick = {navController.navigate(Screen.Login.route)}
        )
        loginRoute(onSignInClick ={

        } , onBackPress = {
            navController.popBackStack()
        })

        signUpRoute(
            otherOptionClick = {
              navController.navigate(Screen.OtherSignUp.route)
            },
            onBackPress = {
            navController.popBackStack()
        })

        otherOptionRoute (onBackPress = {
            navController.popBackStack()
        })
    }
}

fun NavGraphBuilder.otherOptionRoute(
    onBackPress: () -> Unit
){
    composable(route = Screen.OtherSignUp.route){
        OtherOptionsScreen (
            onBackPress = onBackPress,
            firstName = "firstName",
            onFirstNameChange = {},
            lastName = "lastName",
            onLastNameChange = {},
            email = "email",
            onEmailChange = {},
            password = "password",
            onPasswordChange = {},
            signUp = {}
        )
    }
}

fun NavGraphBuilder.loginRoute(
    onSignInClick:() -> Unit,
    onBackPress: () -> Unit
){
    composable(route = Screen.Login.route){
        LoginScreen(
            onSignInClick = onSignInClick,
            email = "",
            password = "",
            onPasswordChange = {},
            onEmailChange = {},
            onForgotPasswordClick = {},
            onBackPress = onBackPress
        )
    }
}

fun NavGraphBuilder.rootRoute(
    onLoginClick:() -> Unit,
    onSignUpClick: () -> Unit
){
    composable(route = Screen.RootAuth.route){
        RootAuthScreen(
            onLoginClick = onLoginClick,
            onSignUpClick = onSignUpClick)
    }
}

fun NavGraphBuilder.signUpRoute(
    otherOptionClick:() -> Unit,
    onBackPress:() -> Unit
){
    composable(route = Screen.SignUp.route){

        val viewModel:SignUpViewModel = hiltViewModel()
        val context = LocalContext.current

        SignUpScreen(
            fullName = viewModel.signUpState.fullName,
            onFullNameChange = {
                viewModel.setFullName(it)
            },
            email = viewModel.signUpState.emailL,
            onEmailChange = {
                viewModel.setEmail(it)
            },
            passKeysSignUp = {
                viewModel.createPassKey(
                    context= context
                    , preferImmediatelyAvailableCredentials = true
                )
            },
            otherOptionsClick = otherOptionClick,
            onBackPress = onBackPress
        )
    }
}