package com.a548bky4474.intermediatesub.data.retrofit

import com.a548bky4474.intermediatesub.data.response.LoginResponse
import com.a548bky4474.intermediatesub.data.response.RegisterResponse
import com.a548bky4474.intermediatesub.data.response.StoryResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

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
}