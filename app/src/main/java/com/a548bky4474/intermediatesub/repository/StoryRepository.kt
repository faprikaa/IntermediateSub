package com.a548bky4474.intermediatesub.repository

import android.util.Log
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.data.retrofit.ApiConfig
import com.a548bky4474.intermediatesub.data.pref.UserPreference
import com.a548bky4474.intermediatesub.data.response.LoginResponse
import com.a548bky4474.intermediatesub.data.response.RegisterResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class StoryRepository private constructor(
    private val userPreference: UserPreference
) {

    suspend fun registerUser(name: String, email: String, password: String): RegisterResponse {
        return withContext(Dispatchers.IO) {
            val response = ApiConfig.getApiService().register(name, email, password).execute()
            if (response.isSuccessful) {
                Log.i("ingfo", response.message())
                return@withContext response.body()!!
            } else {
                val jsonInString = response.errorBody()?.string()
                val errorResponse = Gson().fromJson(jsonInString, RegisterResponse::class.java)
                return@withContext errorResponse
            }
        }
    }

    suspend fun loginUser(email: String, password: String): LoginResponse {
        return withContext(Dispatchers.IO) {
            val response = ApiConfig.getApiService().login(email, password).execute()
            if (response.isSuccessful) {
                return@withContext response.body()!!
            } else {
                val jsonInString = response.errorBody()?.string()
                return@withContext Gson().fromJson<LoginResponse?>(jsonInString, LoginResponse::class.java)
            }
        }
    }

    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    companion object {
        @Volatile
        private var instance: StoryRepository? = null
        fun getInstance(
            userPreference: UserPreference
        ): StoryRepository =
            instance ?: synchronized(this) {
                instance ?: StoryRepository(userPreference)
            }.also { instance = it }

        val ONRESPONSE_TAG = "Error@StoryRepository#OnResponse"
        val ONFAILURE_TAG = "Error@StoryRepository#OnFailure"
    }

}