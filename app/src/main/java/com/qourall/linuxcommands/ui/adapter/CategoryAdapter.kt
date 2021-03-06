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
import com.qourall.linuxcommands.ui.fragment.CategoryFragmentDirections
import javax.sql.StatementEvent

class CategoryAdapter(private val context: Context, private val data: List<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.itemTitle.text = data[position]

        holder.itemView.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToCommandsFragment(data[position])
            Navigation.findNavController(holder.itemView).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CategoryViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val itemTitle: TextView = v.findViewById(R.id.itemCat)
    }

}