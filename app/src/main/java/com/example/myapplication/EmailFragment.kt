package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.email_fragment.*


class EmailFragment : Fragment(R.layout.email_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = "Email Registration"

        InputEmail.requestFocus()
        submitEmail.setOnClickListener {
            when {
                InputEmail.text!!.isBlank() -> {
                    InputEmail.requestFocus()
                    InputEmail.error = "Sorry Invalid Email!"

                }
                inputPassword.text!!.isEmpty() -> {
                    inputPassword.requestFocus()
                    inputPassword.error = "Sorry Invalid Password"
                }
                else -> {
                    val register = Registerer()
                    register.apply {
                        email = InputEmail.text.toString()
                        password = inputPassword.text.toString()
                    }
                    val action = EmailFragmentDirections.actionEmailFragmentToNameFragment(register)
                    findNavController().navigate(action)
                }
            }
        }
    }
}
