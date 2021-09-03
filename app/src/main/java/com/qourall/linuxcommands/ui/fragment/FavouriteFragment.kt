package com.qourall.linuxcommands.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qourall.linuxcommands.R
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.ui.adapter.FavouritesAdapter
import com.qourall.linuxcommands.ui.viewModel.FavouriteViewModel

class FavouriteFragment : Fragment() {

    lateinit var favouritesAdapter: FavouritesAdapter
    var commands : List<CommandsData> = emptyList()
    lateinit var favouritesRecyclerView : RecyclerView
    val viewModel: FavouriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_favourite, container, false)
        favouritesRecyclerView = root.findViewById<RecyclerView>(R.id.FavouriteRecyclerView)
        return root

    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllFavourites()
        viewModel.commandDetails.observe(viewLifecycleOwner, {
            commands = it
            val linearLayoutManager = LinearLayoutManager(requireContext())
            favouritesRecyclerView.layoutManager = linearLayoutManager
            favouritesAdapter = FavouritesAdapter(requireContext(), it)
            favouritesRecyclerView.adapter = favouritesAdapter
        })
    }
}