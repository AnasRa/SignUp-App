package com.example.myapplication.Registerers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.database.RegistererData
import kotlinx.android.synthetic.main.list_item.view.*
import java.text.DateFormat

class ListAdapter(private val dataSet: List<RegistererData>) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.outputFirstName
        val lastName: TextView = itemView.outputLastName
        val email: TextView = itemView.outputEmail
        val password: TextView = itemView.outputPassword
        val regTime: TextView = itemView.regTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MyViewHolder(textView)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.firstName.text = dataSet[position].firstName
        holder.lastName.text = dataSet[position].lastName
        holder.email.text = dataSet[position].email
        holder.password.text = dataSet[position].password
        holder.regTime.text =
            DateFormat.getTimeInstance().format(dataSet[position].registrationTime)
    }

    override fun getItemCount(): Int = dataSet!!.size
}