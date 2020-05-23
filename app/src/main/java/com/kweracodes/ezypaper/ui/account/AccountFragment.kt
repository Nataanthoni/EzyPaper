package com.kweracodes.ezypaper.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.kweracodes.ezypaper.About
import com.kweracodes.ezypaper.Communications
import com.kweracodes.ezypaper.Help
import com.kweracodes.ezypaper.R
import kotlinx.android.synthetic.main.fragment_account.*

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
        about.setOnClickListener {
            val intent = Intent(activity, About::class.java)
            startActivity(intent)
        }


    }
}