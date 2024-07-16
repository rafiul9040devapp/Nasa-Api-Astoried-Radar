package com.mehedi.nasaapiastoroiedradar.views.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.mehedi.nasaapiastoroiedradar.R
import com.mehedi.nasaapiastoroiedradar.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    
    private val viewModel by viewModels<HomeViewModel>()
    
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false);
        
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = "https://apod.nasa.gov/apod/image/2407/TadpoleGalaxy_HubblePathak_3751.jpg"

        viewModel.imageOfTheDay.observe(viewLifecycleOwner) { imageOfTheDay ->
            Log.d("TAG", "imageOfTheDay: $imageOfTheDay")
            binding.apply {
                response = imageOfTheDay
            }
        }
        
        
    }
    
    
}