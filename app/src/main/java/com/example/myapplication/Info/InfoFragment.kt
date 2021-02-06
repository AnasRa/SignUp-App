package com.example.myapplication.Info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Name.NameFragmentArgs
import com.example.myapplication.R
import com.example.myapplication.Registerer
import com.example.myapplication.database.RegistererDatabase
import kotlinx.android.synthetic.main.fragment_info.*


class InfoFragment : Fragment(R.layout.fragment_info) {

    lateinit var viewModel: InfoViewModel
    lateinit var registererObject: Registerer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = NameFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val dataSource = RegistererDatabase.getInstance(application).registrationDatabaseDao
        val viewModelFactory = InfoViewModelFactory(dataSource,application,args.registerer!!)
        viewModel = ViewModelProvider(this, viewModelFactory).get(InfoViewModel::class.java)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.title.observe(this.viewLifecycleOwner, Observer { title ->
            requireActivity().title = title
        })
        viewModel.registerer.observe(this.viewLifecycleOwner, Observer { registerer ->
            registererObject = registerer
            outputFirstName.text = registerer.firstName
            outputLastName.text = registerer.lastName
            outputEmail.text = registerer.email
            outputPassword.text = registerer.password
        })

        confirm.setOnClickListener {
            viewModel.initializeNew()
            val action =
                InfoFragmentDirections.actionInfoFragmentToRegisterersFragment(registererObject)
            findNavController().navigate(action)
        }
    }
}
