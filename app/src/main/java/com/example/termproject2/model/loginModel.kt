package com.example.termproject2.model

import com.google.gson.annotations.SerializedName

data class loginModel(
    @SerializedName("userID")
    val userID :String?,
    @SerializedName("userPassword")
    val userPassword:String?
)
