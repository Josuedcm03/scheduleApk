package com.uam.scheduleapk.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uam.scheduleapk.repository.RepositoryUsuario
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val repository = RepositoryUsuario()
    var state by mutableStateOf(State())
        private set // la variable tiene set privado y get publico



    fun onEmailChange(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordChange(password: String){
        state = state.copy(password = password)
    }

    fun onLogin(){

        viewModelScope.launch {
           val result = repository.login(state.email, state.password)

            if (result.isSuccess){
                state = if(result.getOrNull() == 1)
                    state.copy(error = false, message = "Credenciales conectado")
                else
                    state.copy(error = true, message = "Credenciales incorrectas")
            }
            else{
                state = state.copy(error = true, message = "Error al conectarse a la red")
            }
        }


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