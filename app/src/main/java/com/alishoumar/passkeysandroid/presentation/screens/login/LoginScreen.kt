package com.alishoumar.passkeysandroid.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    onBackPress:() -> Unit,
    email:String,
    password:String,
    onPasswordChange:(String) -> Unit,
    onEmailChange:(String) -> Unit,
    onSignInClick:() -> Unit,
    onForgotPasswordClick:() -> Unit
) {
    Scaffold (

        topBar = {
            LoginTopBar(
                onBackPress = onBackPress
            )
        }, content = {
            LoginScreenContent(
                paddingValues = it,
                email = email,
                onEmailChange = onEmailChange,
                password = password,
                onPasswordChange = onPasswordChange,
                signing = onSignInClick,
                onForgotPasswordClick = onForgotPasswordClick
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PrevLogin() {
//    LoginScreen(onBackPress = {}) {
//
//    }
}