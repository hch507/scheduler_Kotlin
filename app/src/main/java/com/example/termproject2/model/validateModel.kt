package com.example.termproject2.model

import com.google.gson.annotations.SerializedName

data class validateModel(
    @SerializedName("success")
    var success : String,

    @SerializedName("userID")
    var userID : String

)