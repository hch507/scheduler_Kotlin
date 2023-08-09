package com.example.termproject2.retrofit

import com.example.termproject2.model.loginModel
import retrofit2.Call
import com.example.termproject2.model.userModel
import com.example.termproject2.utils.API
import com.google.gson.JsonElement
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IRetrofit {

    @POST(API.registerPhp)
    fun registerRequest(
        //key=value&key=value
        @Field("userID") userID : String?,
        @Field("userPassword") userPassword : String?,
        @Field("userGender") userGender : String?,
        @Field("userGrade") userGrade : String?,
        @Field("userName") userName : String?,
    ):Call<userModel>



    @FormUrlEncoded
    @POST(API.loginPhp)
    fun loginRequest(

        @Field("userID") userID : String?,
        @Field("userPasswoer") userPassword: String?
    ):Call<loginModel>
}