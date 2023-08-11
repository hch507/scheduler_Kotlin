package com.example.termproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.termproject2.databinding.ActivityRegisterBinding
import com.example.termproject2.retrofit.Manager
import com.example.termproject2.utils.responseState

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.validateButton.setOnClickListener {
            var userID = binding.idText.text.toString()
            Manager.instance.validate(userID, completion = {
                reponseState , s ->
                when(reponseState){
                    responseState.Okay->{
                        Log.d("hch", "RegisterActivity-onCreate() called${s}")
                    }
                    responseState.Fail->{
                        Log.d("hch", "RegisterActivity-onCreate() called")
                    }
                }
            })
        }
        binding.registerButton.setOnClickListener {

        }
    }
}