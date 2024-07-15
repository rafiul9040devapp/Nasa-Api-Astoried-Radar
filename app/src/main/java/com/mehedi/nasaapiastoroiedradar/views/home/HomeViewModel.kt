package com.mehedi.nasaapiastoroiedradar.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.nasaapiastoroiedradar.data.models.ResponseImageOfTheDay
import com.mehedi.nasaapiastoroiedradar.data.remote.api.Network
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    
    private val _imageOfTheDay = MutableLiveData<ResponseImageOfTheDay>()
    val imageOfTheDay: LiveData<ResponseImageOfTheDay>
        get() = _imageOfTheDay
    
    init {
        getImageOfTheDay()
    }
    
    private fun getImageOfTheDay() {
        
        viewModelScope.launch {
            
            val response = Network.imageOfTheDayService.getImageOfTheDay()
            
            if (response.isSuccessful) {
                _imageOfTheDay.postValue(response.body())
            }
            
            
        }
        
        
    }
    
    
}