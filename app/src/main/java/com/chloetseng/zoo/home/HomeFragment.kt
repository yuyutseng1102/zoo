package com.chloetseng.zoo.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.chloetseng.zoo.NavigationDirections
import com.chloetseng.zoo.databinding.FragmentHomeBinding
import com.chloetseng.zoo.factory.ViewModelFactory


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewModelFactory = ViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        val adapter = HomeAdapter(viewModel)
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerHome.adapter = adapter
        viewModel.setData()

        viewModel.navToExhibit.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(NavigationDirections.navigateToExhibitFragment(it))
                viewModel.onExhibitNav()
            }
        })

        return binding.root

    }
}