package com.example.termproject2.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofitClient :Retrofit? =null
    private val gson = GsonBuilder().setLenient().create()
    fun getClient(baseUrl:String): Retrofit? {

        if(retrofitClient==null) {
            retrofitClient=Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofitClient
    }

}