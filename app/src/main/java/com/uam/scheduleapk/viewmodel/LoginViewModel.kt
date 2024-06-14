package com.uam.scheduleapk.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(State())
        private set // la variable tiene set privado y get publico



    fun onEmailChange(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordChange(password: String){
        state = state.copy(password = password)
    }

    fun onLogin(){
        state = if(state.email.equals("admin") || state.password.equals("password")){
            state.copy(error = false, message = "Credenciales conectado")
    }
        else{
            state.copy(error = true, message = "Credenciales incorrectas")
        }

    }


    // un data class es como que tuvieramos un bean
    // donde todos sus valores son inicializados
    data class State(
        val email: String = "",
        val password: String = "",
        val message: String? = null,
        val error: Boolean? = false
    )
}