package com.example.expenseminiproject.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.expenseminiproject.database.reposity.UserRepository
import com.example.expenseminiproject.viewmodel.MainViewModel

open class BaseFragment : Fragment() {
    protected val mMainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory(
            requireActivity().application,
            UserRepository.getInstance(requireActivity().application)
        )
    }
}