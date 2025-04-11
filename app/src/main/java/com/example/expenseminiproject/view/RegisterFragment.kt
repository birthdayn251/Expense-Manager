package com.example.expenseminiproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.expenseminiproject.R
import com.example.expenseminiproject.databinding.FragmentRegisterBinding
import com.example.expenseminiproject.utils.navigateSafe

/**
 * NhatNS
 * 11/04/2025
 * first sprint
 */
class RegisterFragment : BaseFragment() {

    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMainViewModel.mRegisterResult.observe(viewLifecycleOwner) { rs ->
            if (rs > -1) {
                Toast.makeText(requireContext(), "Register Success", Toast.LENGTH_SHORT).show()
                findNavController().navigateSafe(R.id.action_registerFragment_to_loginFragment)
            } else {
                Toast.makeText(requireContext(), "Something went wrong, please try again later", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener()
        {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            if (username != "" && password != "") {
                mMainViewModel.handleRegister(username, password)
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener()
        {
            findNavController().navigateSafe(R.id.action_registerFragment_to_loginFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}