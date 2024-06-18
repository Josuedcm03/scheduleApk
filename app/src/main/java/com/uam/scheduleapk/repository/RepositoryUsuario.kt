package com.uam.scheduleapk.repository

import android.util.Log
import com.uam.scheduleapk.reboot.ApiAdapter
import com.uam.scheduleapk.reboot.ApiUsuario
import retrofit2.Response

class RepositoryUsuario {
    private val apiUsuario: ApiUsuario by lazy {
        ApiAdapter.getInstance().create(ApiUsuario::class.java)
    }

    suspend fun login(email: String, password: String): Result<Int> {
        val retorno: Int
        return try {
            val response: Response<Int> = apiUsuario.login(email, password)
            retorno = response.body() as Int
            Log.d("OK", "%{retorno}")
            Result.success(retorno)
        } catch (e: Exception) {
            Log.d("ERROR", "%{e.message}")
            Result.failure(e)
        }
    }
}