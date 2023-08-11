package com.example.termproject2.retrofit

import android.util.Log
import com.example.termproject2.model.loginModel
import com.example.termproject2.model.userModel
import com.example.termproject2.model.validateModel
import com.example.termproject2.utils.API
import com.example.termproject2.utils.responseState

import retrofit2.Call
import retrofit2.Response


class Manager {
    companion object{
        val instance = Manager()
    }
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

    fun loginRequest(userID : String ,userPW :String, completion: (responseState, loginModel?) -> Unit){

        val call = iRetrofit?.loginRequest(userID=userID,
                                           userPassword = userPW).let { it }?: return
        call.enqueue(object : retrofit2.Callback<loginModel>{
            override fun onResponse(
                call: Call<loginModel>,
                response: Response<loginModel>
            ) {
                Log.d("hch", "Manager - onResponse() - called")
                completion(responseState.Okay, response.body())
            }

            override fun onFailure(call: Call<loginModel>, t: Throwable) {
                Log.d("hch", "Manager - onFailure() - called ${t}")
            }

        })

    }
    fun validate(userID: String, completion: (responseState, validateModel?) -> Unit){
        val call = iRetrofit?.idValidate(userID=userID).let { it }?: return

        call.enqueue(object : retrofit2.Callback<validateModel>{
            override fun onResponse(
                call: Call<validateModel>,
                response: Response<validateModel>
            ) {
                completion(responseState.Okay, response.body())
            }

            override fun onFailure(call: Call<validateModel>, t: Throwable) {
                Log.d("hch", "Manager - onFailure() - called ${t}")
            }

        })
    }
}