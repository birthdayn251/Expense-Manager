package com.example.expenseminiproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.expenseminiproject.R
import com.example.expenseminiproject.database.reposity.UserRepository
import com.example.expenseminiproject.databinding.FragmentLoginBinding
import com.example.expenseminiproject.utils.navigateSafe
import com.example.expenseminiproject.viewmodel.MainViewModel

/**
 * NhatNS
 * 11/04/2025
 * first sprint
 */
class LoginFragment : BaseFragment() {

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

        mMainViewModel.mLoginResult.observe(viewLifecycleOwner) { rs ->
            when (rs) {
                1 -> {
                    Toast.makeText(requireContext(), "Welcome, ${mMainViewModel.mSessionManager.getUser()?.username}", Toast.LENGTH_SHORT).show()
                    findNavController().navigateSafe(R.id.action_loginFragment_to_homeFragment)
                }

                0 -> {
                    Toast.makeText(requireContext(), "Invalid Credential", Toast.LENGTH_SHORT).show()
                }

                -1 -> {
                    Toast.makeText(requireContext(), "Something went wrong, please try again later", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnLogin.setOnClickListener() {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            if (username != "" && password != "")
                mMainViewModel.handleLogin(username, password)
            else Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()

        }

        binding.btnRegister.setOnClickListener() {
            findNavController().navigateSafe(R.id.action_loginFragment_to_registerFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}