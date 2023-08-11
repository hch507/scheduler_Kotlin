package com.example.termproject2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class loginModel(
    @Expose
    @SerializedName("userID")
    val userID :String?,
    @Expose
    @SerializedName("userPassword")
    val userPassword:String?
)
