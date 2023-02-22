package com.example.recyclerviewex1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val cars: List<Cars>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)

    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myCars = cars[position]
        holder.bind(myCars)
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bind(cars: Cars) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = cars.name
        view.setOnClickListener {
            val intent = Intent(view.context, SecondActivity::class.java)
            view.context.startActivity(intent)
        }

        view.setOnLongClickListener {
            Toast.makeText(
                view.context,
                "This is ${myTextView.text}",
                Toast.LENGTH_SHORT
            ).show()
            return@setOnLongClickListener true
        }
    }
}