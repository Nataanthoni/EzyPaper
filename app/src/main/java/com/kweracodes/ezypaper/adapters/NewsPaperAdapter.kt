package com.kweracodes.ezypaper.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kweracodes.ezypaper.OperatorActivity
import com.kweracodes.ezypaper.R
import com.kweracodes.ezypaper.models.Newspaper

class NewsPaperAdapter(private  val newspapers: ArrayList<Newspaper>):RecyclerView.Adapter<NewsPaperAdapter.ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


            val view = LayoutInflater.from(parent.context).inflate(R.layout.newspaper_rows, parent, false)
            view.setOnClickListener {
                val intent = Intent(parent.context, OperatorActivity:: class.java)
                parent.context.startActivity(intent)
            }
            return ViewHolder(view)


        }

        override fun getItemCount() = newspapers.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //holder.title.text = newspapers[position].title
            //holder.name.text = newspapers[position].name


        }

        class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            //val title : TextView = itemView.findViewById(R.id.listingtitle)
//            val name : TextView = itemView.findViewById(R.id.name)
//            val photo : ImageView = itemView.findViewById(R.id.photo)
//            val price : TextView = itemView.findViewById(R.id.price)

        }
    }