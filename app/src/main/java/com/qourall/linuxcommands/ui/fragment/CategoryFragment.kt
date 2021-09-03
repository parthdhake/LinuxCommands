package com.qourall.linuxcommands.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qourall.linuxcommands.R
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.ui.adapter.CategoryAdapter
import com.qourall.linuxcommands.ui.adapter.CommandsAdapter
import com.qourall.linuxcommands.ui.viewModel.CategoryViewModel
import com.qourall.linuxcommands.ui.viewModel.CommandsViewModel


class CategoryFragment : Fragment() {


    lateinit var categoryAdapter: CategoryAdapter
    var category : List<String> = emptyList()
    lateinit var categoryRecyclerView: RecyclerView
    val viewModel: CategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_category, container, false)

        categoryRecyclerView = root.findViewById<RecyclerView>(R.id.CategoryRecyclerView)

        return root    }

    override fun onStart() {
        super.onStart()

        viewModel.getCategory().observe(viewLifecycleOwner, {
            category = it
            val linearLayoutManager = LinearLayoutManager(requireContext())
            categoryRecyclerView.layoutManager = linearLayoutManager
            categoryAdapter = CategoryAdapter(requireContext(), it)
            categoryRecyclerView.adapter = categoryAdapter
        })

    }
}