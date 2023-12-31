package com.a548bky4474.intermediatesub.data.retrofit

import com.a548bky4474.intermediatesub.data.response.LoginResponse
import com.a548bky4474.intermediatesub.data.response.RegisterResponse
import com.a548bky4474.intermediatesub.data.response.StoryResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("stories")
    fun getStories(): Call<StoryResponse>

    @GET("stories")
    suspend fun getStoriesForPaging(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 20
    ): StoryResponse

    @GET("stories")
    fun getStoriesWithLocation(
        @Query("location") location : Int = 1,
    ): Call<StoryResponse>

    @Multipart
    @POST("stories")
    fun uploadImage(
        @Part file: MultipartBody.Part,
        @Part("lat") lat: Double ?= null,
        @Part("lon") lon: Double ?= null,
        @Part("description") description: RequestBody,
    ): Call<RegisterResponse>

    @Multipart
    @POST("stories")
    fun uploadImageWithoutLocation(
        @Part("description") description: RequestBody,
    ): Call<RegisterResponse>
}