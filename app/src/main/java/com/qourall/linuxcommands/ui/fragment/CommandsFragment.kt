package com.qourall.linuxcommands.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qourall.linuxcommands.R
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.ui.adapter.CommandsAdapter
import com.qourall.linuxcommands.ui.viewModel.CommandsViewModel
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.coroutines.Dispatchers

class CommandsFragment : Fragment() {

    val args: CommandsFragmentArgs by navArgs()

    lateinit var commandsAdapter: CommandsAdapter
    var commands : List<CommandsData> = emptyList()
    lateinit var commandsRecyclerView: RecyclerView
    val viewModel: CommandsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_commands, container, false)

        commandsRecyclerView = root.findViewById<RecyclerView>(R.id.CommandsRecyclerView)

        return root
    }

    override fun onStart() {
        super.onStart()
        viewModel.getCommandsDetails()

        viewModel.commandsDetails.observe(viewLifecycleOwner, { list ->
            commands = if (args.category == "default"){
                list
            }else{
                list.filter {
                    it.command_category == args.category
                }
            }
            val linearLayoutManager = LinearLayoutManager(requireContext())
            commandsRecyclerView.layoutManager = linearLayoutManager
            commandsAdapter = CommandsAdapter(requireContext(), commands)
            commandsRecyclerView.adapter = commandsAdapter
        })

    }
}