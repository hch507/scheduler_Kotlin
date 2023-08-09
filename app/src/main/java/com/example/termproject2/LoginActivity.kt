package com.example.termproject2

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity

import com.example.termproject2.databinding.ActivityLoginBinding
import com.example.termproject2.model.loginModel

import com.example.termproject2.retrofit.Manager

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("hch", "LoginActivity - onCreate() - called")
        var userID = binding.idText.text.toString()
        var userPW = binding.passwordText.text.toString()
        var userInfo = loginModel(userID, userPW)
        binding.loginButton.setOnClickListener{
            Manager.instance.loginRequest(userInfo, completion = {
                responseState, s ->
                when(responseState){
                    com.example.termproject2.utils.responseState.Okay -> {
                        Log.d("hch", "LoginActivity - onCreate() - called ${s}")

                    }
                    else -> {
                        Log.d("hch", "LoginActivity - onCreate() - called")
                    }
                }
            })
        }
        binding.registerButton.setOnClickListener {

        }
        }
}
