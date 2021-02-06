package com.example.myapplication.Registerers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Info.InfoFragmentArgs
import com.example.myapplication.R
import com.example.myapplication.database.RegistererDatabase
import kotlinx.android.synthetic.main.fragment_registerer.*


class RegistererFragment : Fragment(R.layout.fragment_registerer) {

    private lateinit var viewModel: RegistererViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val dataSource = RegistererDatabase.getInstance(application).registrationDatabaseDao
        val viewModelFactory = RegistererViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegistererViewModel::class.java)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.all.observe(this.viewLifecycleOwner, Observer {
            recycleView.layoutManager = LinearLayoutManager(this.context)
            recycleView.adapter = ListAdapter(it)
        })
        clear.setOnClickListener {
            viewModel.onClear()
        }
    }
}