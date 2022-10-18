package com.example.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            if (isInputValid()) {
                navigateToWelcomeScreen()
            }

        }
        binding.btnJoin.setOnClickListener {
            if (isInputValid()) {
                navigateToWelcomeScreen()
            }
        }
    }

    private fun navigateToWelcomeScreen() {
        val action =
            LoginFragmentDirections.actionLoginFragmentToWelcomeOnBoardingFragment()
        findNavController().navigate(action)
    }

    private fun isEmailValid(): Boolean {
        return !binding.tietEmail.text.isNullOrEmpty()
    }

    private fun isPasswordValid(): Boolean {
        return !binding.tietPassword.text.isNullOrEmpty()
    }

    private fun isInputValid(): Boolean {
        binding.tilEmail.error=requireContext().getText(R.string.email_error_msg)
        binding.tilPassword.error=requireContext().getText(R.string.password_error_msg)
        binding.tilEmail.isErrorEnabled = !isEmailValid()
        binding.tilPassword.isErrorEnabled = !isPasswordValid()
        return isEmailValid() && isPasswordValid()
    }
}