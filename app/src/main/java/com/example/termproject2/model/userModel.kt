package com.example.termproject2.model

import com.google.gson.annotations.SerializedName

data class userModel(

    @SerializedName("userID")
    var userID : String? = null,
    @SerializedName("userPassword")
    var userPassword : String? = null,
    @SerializedName("userGender")
    var userGender : String? = null,
    @SerializedName("userGrade")
    var userGrade : String? = null,
    @SerializedName("userName")
    var userName: String?= null
)
