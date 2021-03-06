package com.chloetseng.zoo.exhibit

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.chloetseng.zoo.*
import com.chloetseng.zoo.ServiceLocator.repository
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
        val args by navArgs<ExhibitFragmentArgs>()
        val repository = (requireContext().applicationContext as ZooApplication).repository
        val viewModelFactory = ExhibitViewModelFactory(repository, args.exhibitKey)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ExhibitViewModel::class.java)

        val adapter = ExhibitAdapter(viewModel)
        val binding = FragmentExhibitBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerPlant.adapter = adapter

        viewModel.navToPlant.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(NavigationDirections.navigateToPlantFragment(it))
                viewModel.onPlantNav()
            }
        })


        viewModel.apply {
            getExhibitDone.observe(viewLifecycleOwner, Observer {
                it?.let {
                    exhibit.value?.let { exhibit ->
                        getPlantList(DataType.PLANT_TYPE.value, SCOPE, exhibit.name)
                        onExhibitGot()
                    }
                }
            })
        }

        binding.exhibitUrl.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.addCategory(Intent.CATEGORY_BROWSABLE)
                viewModel.exhibit.value?.let {
                    intent.setData(Uri.parse(it.url))
                }
                startActivity(intent)
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

}