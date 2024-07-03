package com.alishoumar.passkeysandroid.presentation.screens.signup

import android.annotation.SuppressLint
import android.content.Context
import android.util.Base64
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.credentials.CreatePublicKeyCredentialRequest
import androidx.credentials.CredentialManager
import androidx.credentials.exceptions.CreateCredentialException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.security.SecureRandom
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val credentialManager: CredentialManager
):ViewModel() {

     var signUpState by mutableStateOf(SignUpState())
        private set


    fun setFullName(fullName:String){
        signUpState = signUpState.copy(
            fullName = fullName
        )
    }

    fun setEmail(email:String){
        signUpState = signUpState.copy(
            emailL = email
        )
    }

  @SuppressLint("PublicKeyCredential")
  fun createPassKey(requestJson:String= createRegistrationRequest(),
                    context: Context,
                    preferImmediatelyAvailableCredentials: Boolean){




      val createPublicKeyCredentialRequest = CreatePublicKeyCredentialRequest(
          requestJson = requestJson,
          preferImmediatelyAvailableCredentials = preferImmediatelyAvailableCredentials
      )

      viewModelScope.launch (Dispatchers.Main){
          try {
              Log.d("tag", "createPassKey: $context")
              val result= credentialManager.createCredential(
                  request = createPublicKeyCredentialRequest,
                  context = context
              )
              Log.d("tag", "createPassKey: $result")
          }catch (e: CreateCredentialException){
              Log.d("tag", "createPassKey: $e")
          }
      }
  }

    private fun createRegistrationRequest(): String {
        // Generate random challenge bytes
        val challenge = ByteArray(32)
        SecureRandom().nextBytes(challenge)

        // Create the JSON structure
        val json = JSONObject().apply {
            put("challenge", Base64.encodeToString(challenge, Base64.NO_WRAP))
            put("rp", JSONObject().apply {
                put("name", "PassKeysAndroid")
                put("id", "alishoumar.passkeysandroid.com")
            })
            put("user", JSONObject().apply {
                put("id", ByteArray(16)) // Empty 16-byte array
                put("name", signUpState.emailL)
                put("displayName", signUpState.fullName)
            })
            put("pubKeyCredParams", JSONArray().apply {
                put(JSONObject().apply {
                    put("type", "public-key")
                    put("alg", -7)
                })
            })
        }

        return json.toString()
    }
}