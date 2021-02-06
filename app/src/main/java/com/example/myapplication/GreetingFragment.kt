package com.example.myapplication


import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.greeting_fragment.*


class GreetingFragment : Fragment(R.layout.greeting_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seeAll.setOnClickListener {
            findNavController().navigate(R.id.action_greetingFragment_to_registerersFragment)
        }
        startButton.setOnClickListener {
            findNavController().navigate(R.id.action_placeholder_to_emailFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().title = "Welcome"
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
