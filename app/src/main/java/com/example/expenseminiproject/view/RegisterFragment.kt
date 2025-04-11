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

/**
 * NhatNS
 * 11/04/2025
 * first sprint
 */
class RegisterFragment : Fragment() {

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

        binding.btnLogin.setOnClickListener()
        {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        binding.btnRegister.setOnClickListener()
        {
            Toast.makeText(requireContext(), "Register Success", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}