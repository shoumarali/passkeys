package com.alishoumar.passkeysandroid.presentation.screens.signup

import android.annotation.SuppressLint
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    fullName: String,
    onFullNameChange: (String) -> Unit,
    email: String,
    onEmailChange:(String) -> Unit,
    passKeysSignUp:() -> Unit,
    otherOptionsClick:() -> Unit,
    onBackPress:() -> Unit) {
    Scaffold (
        topBar = {
            SignUpTopBar(onBackPress = onBackPress)
        },
        content = { paddingValues ->
            SignUpContent(
                paddingValues = paddingValues,
                fullName = fullName,
                onFullNameChange = onFullNameChange,
                email = email,
                onEmailChange = onEmailChange,
                passkeysSignUp = passKeysSignUp,
                otherOptionsClick = otherOptionsClick)
        }
    )
}