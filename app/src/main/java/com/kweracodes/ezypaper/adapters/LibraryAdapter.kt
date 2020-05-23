package com.kweracodes.ezypaper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kweracodes.ezypaper.R
import com.kweracodes.ezypaper.models.Library

class LibraryAdapter(private  val libraries: ArrayList<Library>):RecyclerView.Adapter<LibraryAdapter.ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.library_row, parent, false)
            return ViewHolder(view)

        }

        override fun getItemCount() = libraries.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //holder.title.text = newspapers[position].title
            holder.name.text = libraries[position].name


        }

        class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            //val title : TextView = itemView.findViewById(R.id.listingtitle)
            val name : TextView = itemView.findViewById(R.id.name)
            val photo : ImageView = itemView.findViewById(R.id.photo)
            val price : TextView = itemView.findViewById(R.id.price)
        }
    }