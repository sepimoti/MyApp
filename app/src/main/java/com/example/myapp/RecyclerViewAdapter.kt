package com.example.myapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val myList : List<ElementItem>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtTitle=itemView.findViewById<TextView>(R.id.txtTitle)
        val txtDesc=itemView.findViewById<TextView>(R.id.txtDescription)
        val imgRecycler=itemView.findViewById<ImageView>(R.id.imgRecyclerView)
        val layout=itemView.findViewById<LinearLayout>(R.id.layout)
        init {
            layout.setOnClickListener(View.OnClickListener {
                val positon=adapterPosition+1
                Toast.makeText(itemView.context,"Item number is "+positon,Toast.LENGTH_SHORT).show()
                val intent=Intent(itemView.context,MainActivity2::class.java)
                itemView.context.startActivity(intent)
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        val holder=RecyclerViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem=myList[position]
        holder.imgRecycler.setImageResource(currentItem.img)
        holder.txtTitle.text=currentItem.title
        holder.txtDesc.text=currentItem.desc
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}