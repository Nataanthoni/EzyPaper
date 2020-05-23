package com.kweracodes.ezypaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.killasites.magazine89.RetrofitClient
import com.kweracodes.ezypaper.models.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import com.kweracodes.ezypaper.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        buttonLogin.setOnClickListener {

            val email = emailaddress.text.toString().trim()
            val password = clientpassword.text.toString().trim()

            if (email.isEmpty()) {
                emailaddress.error = "Email required"
                emailaddress.requestFocus()
                return@setOnClickListener
            }


            if (password.isEmpty()) {
                clientpassword.error = "Password required"
                clientpassword.requestFocus()
                return@setOnClickListener
            }

            progressbarlogin.visibility = View.VISIBLE
            buttonLogin.visibility = View.GONE

            RetrofitClient.instance.userLogin(email, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        return
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if (response.isSuccessful) {

                            SharedPrefManager.getInstance(applicationContext)
                                .saveUser(response.body()?.user!!)

                            val intent = Intent(applicationContext, Login::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)

                            Toast.makeText(this@Login, "Login Succesful", Toast.LENGTH_SHORT).show()
                        } else {

                            progressbarlogin.setVisibility(View.INVISIBLE)
                            SweetAlertDialog(this@Login, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Login NOT Successful")
                                .show()
                            Toast.makeText(
                                applicationContext,
                                response.body()?.message,
                                Toast.LENGTH_LONG
                            ).show()
                            buttonLogin.setVisibility(View.VISIBLE)
                        }

                    }
                })

        }

        signup.setOnClickListener {
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        if (SharedPrefManager.getInstance(this).isLoggedIn) {
            val intent = Intent(applicationContext, Splash::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }
}
