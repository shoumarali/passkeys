package com.alishoumar.passkeysandroid.presentation.screens.otherOptionsScreen

import android.annotation.SuppressLint
import androidx.annotation.UiThread
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OtherOptionsScreen(onBackPress:() -> Unit,
                       firstName:String,
                       onFirstNameChange:(String) ->Unit,
                       lastName:String,
                       onLastNameChange:(String) -> Unit,
                       email:String,
                       onEmailChange:(String)->Unit,
                       password:String,
                       onPasswordChange:(String) -> Unit,
                       signUp:() -> Unit
) {

    Scaffold(
        topBar = {
            OtherOptionsTopAppbar (onBackPress = onBackPress)
        },
        content = {
            OtherOptionsContent(paddingValues = it,
                firstName = firstName,
                onFirstNameChange = onFirstNameChange,
                lastName = lastName,
                onLastNameChange = onLastNameChange,
                email = email,
                onEmailChange = onEmailChange,
                password = password,
                onPasswordChange = onPasswordChange,
                signUp = signUp
            )
        }
    )
}

