package com.kweracodes.ezypaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.killasites.magazine89.RetrofitClient
import com.kweracodes.ezypaper.models.DefaultResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        login.setOnClickListener {
            startActivity(Intent(this@SignUp, Login::class.java))
        }


        buttonSignUp.setOnClickListener {

            val name = text_name.text.toString().trim()
            val country = text_country.text.toString().trim()
            val email = text_email.text.toString().trim()
            val password = text_password.text.toString().trim()


            if (name.isEmpty()) {
                text_name.error = "Name is required"
                text_name.requestFocus()
                return@setOnClickListener
            }


            if (country.isEmpty()) {
                text_country.error = "Lastname is required"
                text_country.requestFocus()
                return@setOnClickListener
            }


            if (email.isEmpty()) {
                text_email.error = "Please enter email"
                text_email.requestFocus()
                return@setOnClickListener
            }


            if (password.isEmpty()) {
                text_password.error = "Password is required"
                text_password.requestFocus()
                return@setOnClickListener
            }
            progresscreateaccount.visibility = View.VISIBLE

            RetrofitClient.instance.createUser(name, country, email, password)
                .enqueue(object : Callback<DefaultResponse> {
                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        Toast.makeText(this@SignUp, "Sign Up not Succesful", Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onResponse(
                        call: Call<DefaultResponse>,
                        response: Response<DefaultResponse>
                    ) {
                        Toast.makeText(
                            applicationContext,
                            response.body()?.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }

                })

        }
    }


}
