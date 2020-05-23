package com.kweracodes.ezypaper.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.kweracodes.ezypaper.R
import com.kweracodes.ezypaper.adapters.NewsPaperAdapter
import com.kweracodes.ezypaper.models.Newspaper
import kotlinx.android.synthetic.main.fragment_dashboard.*

@Suppress("DEPRECATION")
class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newspapers = arrayListOf<Newspaper>()
        for (i in 0..3){
            newspapers.add(Newspaper("", "", 383.0))
        }
        recyclerview_newspaper.apply {
            layoutManager = GridLayoutManager(activity,2)
            adapter = NewsPaperAdapter(newspapers)

        }


    }


}