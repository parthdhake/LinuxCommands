package com.qourall.linuxcommands.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.qourall.linuxcommands.R
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.ui.fragment.CommandsFragmentDirections
import com.qourall.linuxcommands.ui.fragment.FavouriteFragmentDirections

class FavouritesAdapter(private val context: Context, private val data: List<CommandsData>) : RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        return FavouritesViewHolder(LayoutInflater.from(context).inflate(R.layout.primary_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        holder.itemTitle.text = data[position].command_name
        holder.itemDesc.text = data[position].command_description

        holder.itemView.setOnClickListener {
            val action = FavouriteFragmentDirections.actionFavouriteFragmentToDetailsFragment(data[position])
            Navigation.findNavController(holder.itemView).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class FavouritesViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val itemTitle: TextView = v.findViewById(R.id.itemTitle)
        val itemDesc: TextView = v.findViewById(R.id.itemDesc)
    }

}