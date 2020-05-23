package com.kweracodes.ezypaper.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kweracodes.ezypaper.R
import com.kweracodes.ezypaper.adapters.LibraryAdapter
import com.kweracodes.ezypaper.models.Library
import com.kweracodes.ezypaper.ui.library.MoreViewModel
import kotlinx.android.synthetic.main.fragment_library.*

class MoreFragment : Fragment() {

    private lateinit var moreViewModel: MoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moreViewModel =
            ViewModelProviders.of(this).get(MoreViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_library, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val libraries = arrayListOf<Library>()
        for (i in 0..9){
            libraries.add(Library("Listing Title", "", "",383.0))
        }
        recyclerview_library.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = LibraryAdapter(libraries)

        }

    }
}