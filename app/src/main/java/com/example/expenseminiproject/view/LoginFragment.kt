package com.example.expenseminiproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.expenseminiproject.R
import com.example.expenseminiproject.databinding.FragmentLoginBinding

/**
 * NhatNS
 * 11/04/2025
 * first sprint
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener() {
            Toast.makeText(requireContext(), "Login Success", Toast.LENGTH_SHORT).show()
        }

        binding.btnRegister.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}