package com.example.learnviewmodel

import ApiService
import LoginPayload
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learnviewmodel.databinding.ActivityLoginBinding
import com.example.learnviewmodel.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {


    private val baseurl = "https://api-test.egolepay.com/api/"
    private val tag: String = "CHECK_RESPONSE"

    private val deviceType = "POS Application"
    private val deviceName = "Topwise MP35P"
    private val brandName = "Topwise"
    private val brand = "MP35P"
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.loginBtn.setOnClickListener {
            val username = binding.phoneNumber.text.toString()
            val password = binding.Password .text.toString()
            val versioncode = "2.44"
            val deviceserialnumber = "P260300469678"
            val useragent = "android/$versioncode/$deviceserialnumber"





            val loginrequest = LoginPayload(
                EmailOrPhone = username,
                password = password,
                deviceType = deviceType,
                deviceName =  deviceName,
                userAgent = useragent,
                brandName = brandName,
                brand = brand,
                deviceSerialNumber = deviceserialnumber

            )
            getLogin(loginrequest)
        }
    }


    private fun getLogin(body : LoginPayload){
        val api = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        api.getLogin(body).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    response.body()?.let{

                        Log.i(tag, "onResponse: ${response.body()}")
                        //val str = send_text.text.toString()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)

                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.i(tag,"onFailure: ${t.message}" )
            }

        })
    }
}