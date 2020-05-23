package com.kweracodes.ezypaper


import com.kweracodes.ezypaper.models.DefaultResponse
import com.kweracodes.ezypaper.models.LoginResponse
import com.kweracodes.ezypaper.models.LogoutResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("createuser")
    fun createUser(
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("country") country: String,
        @Field("password") password: String


    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("auth/login")
    fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>


    @FormUrlEncoded
    @POST("auth/logout")
    fun userLogout(
    ): Call<LogoutResponse>
}