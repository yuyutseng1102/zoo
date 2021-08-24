package com.chloetseng.zoo.exhibit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chloetseng.zoo.R
import com.chloetseng.zoo.databinding.FragmentExhibitBinding
import com.chloetseng.zoo.databinding.FragmentHomeBinding
import com.chloetseng.zoo.factory.ExhibitViewModelFactory
import com.chloetseng.zoo.factory.ViewModelFactory
import com.chloetseng.zoo.home.HomeAdapter
import com.chloetseng.zoo.home.HomeViewModel

class ExhibitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModelFactory = ExhibitViewModelFactory(ExhibitFragmentArgs.fromBundle(requireArguments()).exhibitKey)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ExhibitViewModel::class.java)
        val adapter = ExhibitAdapter(viewModel)
        val binding = FragmentExhibitBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerPlant.adapter = adapter
//        viewModel.setData()

        return binding.root
    }

}