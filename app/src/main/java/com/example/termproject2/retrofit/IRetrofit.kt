package com.example.termproject2.retrofit

import com.example.termproject2.model.loginModel
import retrofit2.Call
import com.example.termproject2.model.userModel
import com.example.termproject2.model.validateModel
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
    // 보내는 데이터를 URL인코딩 이라고 부르는 방식으로 인코딩 후에 웹서버로 보내는 방식
    @POST(API.loginPhp)
    fun loginRequest(
        @Field("userID") userID : String?,
        @Field("userPasswoer") userPassword: String?
    ):Call<loginModel>

    @FormUrlEncoded
    @POST(API.validatePhp)
    fun idValidate(
        @Field("userID") userID : String?
    ):Call<validateModel>
}