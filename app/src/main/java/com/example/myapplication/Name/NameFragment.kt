package com.example.myapplication.Name

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_name.*

class NameFragment : Fragment(R.layout.fragment_name) {
    private lateinit var viewModel: NameViewModel
    private lateinit var args: NameFragmentArgs
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        args = NameFragmentArgs.fromBundle(requireArguments())
        val viewModelFactory = NameViewModelFactory(args.registerer!!)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NameViewModel::class.java)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.title.observe(this.viewLifecycleOwner, Observer { title ->
            requireActivity().title = title
        })

        inputFirstName.requestFocus()
        submitName.setOnClickListener {
            when {
                inputFirstName.text!!.isBlank() -> {
                    inputFirstName.requestFocus()
                    viewModel.errorName.observe(this.viewLifecycleOwner, Observer { errorName ->
                        inputFirstName.error = errorName
                    })
                }
                inputLastName.text!!.isEmpty() -> {
                    inputLastName.requestFocus()
                    viewModel.errorName.observe(this.viewLifecycleOwner, Observer { errorName ->
                        inputLastName.error = errorName
                    })
                }
                else -> {
                    args.registerer.apply {
                        this!!.firstName = inputFirstName.text.toString()
                        lastName = inputLastName.text.toString()

                    }
                    val action = NameFragmentDirections.actionNameFragmentToInfoFragment(args.registerer)
                    findNavController().navigate(action)
                }
            }
        }
    }
}