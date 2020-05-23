package com.kweracodes.ezypaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kweracodes.ezypaper.models.Operator

class OperatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operator)


        val operators = arrayListOf<Operator>()
        for (i in 0..9){
            operators.add(Operator("Daily Monitor", "", 293.00))
        }
    }


}
