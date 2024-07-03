package com.alishoumar.passkeysandroid.presentation.screens.signup

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
fun SignUpContent(
    paddingValues: PaddingValues,
    fullName:String,
    onFullNameChange:(String) -> Unit,
    email:String,
    onEmailChange:(String) -> Unit,
    passkeysSignUp:() -> Unit,
    otherOptionsClick:() -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding()+40.dp)
            .padding(horizontal = 12.dp)
            .background(MaterialTheme.colorScheme.surface)
    ){
        Column (
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 12.dp)

        ){
            Text(text = "Create Account",
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
                    value = fullName,
                    onValueChange = onFullNameChange)

                Spacer(modifier = Modifier.size(24.dp))
                TextField(value = email, onValueChange = onEmailChange)
                Spacer(modifier = Modifier.size(24.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    onClick = { passkeysSignUp() }) {
                    Text(text = "Sign Up with passkeys",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize)
                }
                Row (
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "or",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize)
                }
                Row (
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .clickable{
                            otherOptionsClick()
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Other Options",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PrevSignUpContent() {
    SignUpContent(
        paddingValues = PaddingValues(12.dp),
        fullName = "",
        onFullNameChange = {},
        email = "",
        onEmailChange = {},
        passkeysSignUp = {},
        otherOptionsClick = {}
    )
}