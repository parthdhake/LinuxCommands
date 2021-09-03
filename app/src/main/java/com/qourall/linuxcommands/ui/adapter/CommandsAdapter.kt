package com.qourall.linuxcommands.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.qourall.linuxcommands.R
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.ui.fragment.CommandsFragmentDirections

class CommandsAdapter(private val context: Context, private val data: List<CommandsData>) : RecyclerView.Adapter<CommandsAdapter.CommandsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandsViewHolder {
        return CommandsViewHolder(LayoutInflater.from(context).inflate(R.layout.primary_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: CommandsViewHolder, position: Int) {
        holder.itemTitle.text = data[position].command_name
        holder.itemDesc.text = data[position].command_description

        holder.itemView.setOnClickListener {
            val action = CommandsFragmentDirections.actionCommandsFragmentToDetailsFragment(data[position])
            Navigation.findNavController(holder.itemView).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CommandsViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val itemTitle: TextView = v.findViewById(R.id.itemTitle)
        val itemDesc: TextView = v.findViewById(R.id.itemDesc)
    }

}