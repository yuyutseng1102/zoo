package com.chloetseng.zoo.plant

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.chloetseng.zoo.ZooApplication
import com.chloetseng.zoo.databinding.FragmentPlantBinding
import com.chloetseng.zoo.factory.ExhibitViewModelFactory

class PlantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args by navArgs<PlantFragmentArgs>()
        val repository = (requireContext().applicationContext as ZooApplication).repository
        val viewModelFactory = ExhibitViewModelFactory(repository, args.plantKey)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(PlantViewModel::class.java)

        val binding = FragmentPlantBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

}
