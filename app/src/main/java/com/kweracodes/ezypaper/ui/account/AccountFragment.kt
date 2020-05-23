package com.kweracodes.ezypaper.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import cn.pedant.SweetAlert.SweetAlertDialog
import com.killasites.magazine89.RetrofitClient
import com.kweracodes.ezypaper.*
import com.kweracodes.ezypaper.models.LogoutResponse
import com.kweracodes.ezypaper.storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_account.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountFragment : Fragment() {

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        accountViewModel =
            ViewModelProviders.of(this).get(AccountViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_account, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Opens communications activity chen clicked
        communications.setOnClickListener {
            val intent = Intent(activity, Communications::class.java)
            startActivity(intent)
        }


        //Opens Some Other activity chen clicked
        someother.setOnClickListener {
            val intent = Intent(activity, Communications::class.java)
            startActivity(intent)
        }


        //Opens Help activity chen clicked
        help.setOnClickListener {
            val intent = Intent(activity, Help::class.java)
            startActivity(intent)
        }

        //Opens About activity chen clicked
        logout.setOnClickListener {
            val intent = Intent(activity, About::class.java)
            startActivity(intent)
        }

        fun logOut(){
            RetrofitClient.instance.userLogout()
                .enqueue(object : Callback<LogoutResponse>{
                    override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(
                        call: Call<LogoutResponse>,
                        response: Response<LogoutResponse>
                    ) {
                        if (response.isSuccessful) {


                            val intent = Intent(activity, MainActivity ::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)

                            Toast.makeText(activity, "Logout Succesful", Toast.LENGTH_SHORT).show()
                        } else {

                            progressbarlogin.setVisibility(View.INVISIBLE)
                            SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Login NOT Successful")
                                .show()
                        }

                    }

                })
        }


    }
}