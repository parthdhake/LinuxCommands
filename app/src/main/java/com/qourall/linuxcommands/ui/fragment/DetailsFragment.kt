package com.qourall.linuxcommands.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.qourall.linuxcommands.R
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.ui.viewModel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private val args : DetailsFragmentArgs by navArgs()
    lateinit var details : CommandsData
    private val viewModel : DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onStart() {
        super.onStart()
        details = args.commandDetails

        if (details.favourite_boolean == 0) {
            star_img.setImageResource(R.drawable.ic_star_border);
        }else {
            star_img.setImageResource(R.drawable.ic_star);
        }

        name.text = details.command_name
        category.text = "Category: " + details.command_category
        desciption.text = details.command_description
        ref_web.loadDataWithBaseURL(null, details.command_quick_ref, "text/html", "utf-8", null);
        syntax_web.loadDataWithBaseURL(null, details.command_syntax, "text/html", "utf-8", null);
        options_web.loadDataWithBaseURL(null, details.command_option, "text/html", "utf-8", null);
        examples_web.loadDataWithBaseURL(null, details.command_example, "text/html", "utf-8", null);



        name_card.setOnClickListener {
            if (details.favourite_boolean == 0) {
                viewModel.favourite(details._id)
                details.favourite_boolean = 1
                star_img.setImageResource(R.drawable.ic_star);
            }else {
                viewModel.unfavourite(details._id)
                details.favourite_boolean = 0
                star_img.setImageResource(R.drawable.ic_star_border);
            }
        }

    }

}