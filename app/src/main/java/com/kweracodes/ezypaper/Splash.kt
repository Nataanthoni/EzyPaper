package com.kweracodes.ezypaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //4second splash time
        Handler().postDelayed({
            //start Main page
            startActivity(Intent(this@Splash, MainActivity::class.java))
            //finish this activity
            finish()
        }, 1000)

    }
}
