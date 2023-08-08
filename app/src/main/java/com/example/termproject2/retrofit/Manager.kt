package com.example.termproject2.retrofit

import com.example.termproject2.model.userModel
import com.example.termproject2.utils.API
import com.example.termproject2.utils.responseState
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response


class Manager {
    private var iRetrofit : IRetrofit? =RetrofitClient.getClient(API.baseUrl)?.create(IRetrofit::class.java)

    fun userRequest(userInfo : userModel, completion : (responseState, String) -> Unit){

        val call = iRetrofit?.registerRequest(userID=userInfo.userID,
            userPassword = userInfo.userPassword,
            userGender = userInfo.userGender,
            userGrade = userInfo.userGrade,
            userName = userInfo.userName).let { it } ?: return
        call.enqueue(object:retrofit2.Callback<userModel>{
            override fun onResponse(call: Call<userModel>, response: Response<userModel>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<userModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}