package com.a548bky4474.intermediatesub.repository

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.a548bky4474.intermediatesub.data.paging.StoryPagingSource
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.data.pref.UserPreference
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.data.response.LoginResponse
import com.a548bky4474.intermediatesub.data.response.RegisterResponse
import com.a548bky4474.intermediatesub.data.response.StoryResponse
import com.a548bky4474.intermediatesub.data.retrofit.ApiConfig
import com.a548bky4474.intermediatesub.data.retrofit.ApiConfig.getApiServiceWithToken
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class StoryRepository private constructor(
    private val userPreference: UserPreference
) {

    suspend fun registerUser(name: String, email: String, password: String): RegisterResponse {
        return withContext(Dispatchers.IO) {
            val response = ApiConfig.getApiService().register(name, email, password).execute()
            if (response.isSuccessful) {
                return@withContext response.body()!!
            } else {
                val jsonInString = response.errorBody()?.string()
                return@withContext Gson().fromJson<RegisterResponse?>(jsonInString, RegisterResponse::class.java)
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

    fun getStoriesRepo(token: String): StoryResponse {
        return if (token.isEmpty()) {
            StoryResponse()
        } else {
            getApiServiceWithToken(token).getStories().execute().body()!!

        }
    }
    suspend fun getStoriesWithLocationRepo(token: String): StoryResponse {
        return withContext(Dispatchers.IO) {
            if (token.isEmpty()) {
                return@withContext StoryResponse()
            } else {
                return@withContext ApiConfig.getApiServiceWithToken(token).getStoriesWithLocation().execute().body()!!

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

    suspend fun uploadImage(imageFile: File, currentLocation: Location?,description: String, token: String): RegisterResponse {
        return withContext(Dispatchers.IO) {
            val requestBody = description.toRequestBody("text/plain".toMediaType())
            val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
            val multipartBody = MultipartBody.Part.createFormData(
                "photo",
                imageFile.name,
                requestImageFile
            )
            var lon: Double? = null
            var lat: Double? = null

            if (currentLocation != null) {
                lon = currentLocation.longitude
                lat = currentLocation.latitude
            }
//            val lat: Double? = if (currentLocation.latitude == 0.0) null else currentLocation.latitude

            val response = ApiConfig.getApiServiceWithToken(token).uploadImage(
                multipartBody,
                lat,
                lon,
                requestBody
            ).execute()
            return@withContext if (response.isSuccessful) {
                response.body()!!
            } else {
                val jsonInString = response.errorBody()?.string()
                Gson().fromJson<RegisterResponse?>(jsonInString, RegisterResponse::class.java)
            }
        }
    }

    fun getStoriesPagingRepo(token: String): LiveData<PagingData<ListStoryItem>> {
        var apiService = getApiServiceWithToken(token)
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                StoryPagingSource(apiService)
            }
        ).liveData
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