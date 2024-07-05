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
    private val credentialManager: CredentialManager,
    private val context: Context,
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
  fun createPassKey(requestJson:String= createRegistrationRequest()){

      val createPublicKeyCredentialRequest = CreatePublicKeyCredentialRequest(
          requestJson = requestJson,
      )

      viewModelScope.launch (Dispatchers.Main){
          try {
              Log.d("tag", "createPassKey: $context")
              Log.d("tag", "createPassKey: $requestJson")

              val result= credentialManager.createCredential(
                  request = createPublicKeyCredentialRequest,
                  context = context
              )
              Log.d("tag", "createPassKey: $result")
          }catch (e: CreateCredentialException){
              Log.d("tag", "createPassKey: ${e.message}")
          }
      }
  }

    private fun createRegistrationRequest(): String {

        val challenge = ByteArray(32)
        SecureRandom().nextBytes(challenge)

        val json = JSONObject().apply {
            put("challenge", getEncodedChallenge())
            put("rp", JSONObject().apply {
                put("id", "passkeys-codelab.glitch.me")
                put("name", "PassKeysAndroid")
            })
            put("user", JSONObject().apply {
                put("id", getEncodedUserId())
                put("name", signUpState.emailL)
                put("displayName", signUpState.fullName)
            })
            put("pubKeyCredParams", JSONArray().apply {
                put(JSONObject().apply {
                    put("type", "public-key")
                    put("alg", -7)
                })
            })
            put("authenticatorSelection", JSONObject().apply {
                put("authenticatorAttachment", "platform")
                put("residentKey", "required")
            })
        }


        return json.toString()
    }

    private fun getEncodedUserId(): String {
        val random = SecureRandom()
        val bytes = ByteArray(64)
        random.nextBytes(bytes)
        return Base64.encodeToString(
            bytes,
            Base64.NO_WRAP or Base64.URL_SAFE or Base64.NO_PADDING
        )
    }
    private fun getEncodedChallenge(): String {
        val random = SecureRandom()
        val bytes = ByteArray(32)
        random.nextBytes(bytes)
        return Base64.encodeToString(
            bytes,
            Base64.NO_WRAP or Base64.URL_SAFE or Base64.NO_PADDING
        )
    }
}