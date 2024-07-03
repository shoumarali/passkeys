package com.alishoumar.passkeysandroid.presentation.screens.otherOptionsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OtherOptionsContent(
    paddingValues: PaddingValues,
    firstName:String,
    onFirstNameChange:(String) -> Unit,
    lastName:String,
    onLastNameChange:(String)->Unit,
    email:String,
    onEmailChange:(String) -> Unit,
    password:String,
    onPasswordChange:(String)->Unit,
    signUp: ()-> Unit
) {


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding() + 40.dp)
            .padding(horizontal = 12.dp)
            .background(MaterialTheme.colorScheme.surface)
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)

        ){
            Text(text = "Sign Up With Password",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(vertical = 24.dp)
                    .fillMaxWidth()
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                TextField(
                    value = firstName,
                    onValueChange = onFirstNameChange)

                Spacer(modifier = Modifier.size(24.dp))

                TextField(
                    value = lastName,
                    onValueChange = onLastNameChange)

                Spacer(modifier = Modifier.size(24.dp))

                TextField(
                    value = email,
                    onValueChange = onEmailChange)

                Spacer(modifier = Modifier.size(24.dp))

                TextField(value = password,
                    onValueChange = onPasswordChange)
                Spacer(modifier = Modifier.size(24.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    onClick = { signUp() }) {
                    Text(text = "Sign Up")
                }

            }
        }
    }


}


//@Preview
//@Composable
//private fun PrevOther() {
//    OtherOptionsScreen {
//
//    }
//}