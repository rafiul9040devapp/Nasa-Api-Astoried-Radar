package com.mehedi.nasaapiastoroiedradar.views.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mehedi.nasaapiastoroiedradar.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    
    private val viewModel by viewModels<HomeViewModel>()
    
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.imageOfTheDay.observe(viewLifecycleOwner) { imageOfTheDay ->
            Log.d("TAG", "imageOfTheDay: $imageOfTheDay")
            
            
        }
        
        
    }
    
    
}