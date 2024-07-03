package com.alishoumar.passkeysandroid.presentation.screens.login

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreenContent(
    paddingValues: PaddingValues,
    email:String,
    onEmailChange:(String) -> Unit,
    password:String,
    onPasswordChange:(String) -> Unit,
    signing:() -> Unit,
    onForgotPasswordClick:() -> Unit
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
            Text(text = "Sign In",
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
                    value = email,
                    onValueChange = onEmailChange)

                Spacer(modifier = Modifier.size(24.dp))
                TextField(value = password,
                    onValueChange = onPasswordChange)
                Spacer(modifier = Modifier.size(24.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Text(text = "Forgot password?",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.clickable {
                            onForgotPasswordClick()
                        },
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                        )
                }
                Spacer(modifier = Modifier.size(24.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    onClick = { signing() }) {
                    Text(text = "Sign In")
                }

            }
        }
    }
}

@Preview
@Composable
private fun PrevSignUpContent() {
    LoginScreenContent(
        paddingValues = PaddingValues(12.dp),
        email = "",
         onEmailChange =  {},
        password= "",
        onPasswordChange = {},
        signing = {},
        onForgotPasswordClick = {}
    )
}