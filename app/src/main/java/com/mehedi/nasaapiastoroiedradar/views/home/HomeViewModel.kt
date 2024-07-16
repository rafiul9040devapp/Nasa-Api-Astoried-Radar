package com.mehedi.nasaapiastoroiedradar.views.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.nasaapiastoroiedradar.data.local.AppDatabase
import com.mehedi.nasaapiastoroiedradar.data.local.ImageOfTheDayDao
import com.mehedi.nasaapiastoroiedradar.data.local.ImageOfTheDayEntity
import com.mehedi.nasaapiastoroiedradar.data.models.ResponseImageOfTheDay
import com.mehedi.nasaapiastoroiedradar.data.remote.api.Network
import com.mehedi.nasaapiastoroiedradar.utils.ImageOfTheDayMapper
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val dayDao: ImageOfTheDayDao = AppDatabase.getDatabase(application).imageOfTheDayDao()

    private val _imageOfTheDay = MutableLiveData<List<ImageOfTheDayEntity>>()
    val imageOfTheDay: LiveData<List<ImageOfTheDayEntity>>
        get() = _imageOfTheDay

    init {
        getImageOfTheDay()
        fetchImagesFromLocal()
    }

    private fun getImageOfTheDay() {
        viewModelScope.launch {
            try {
                val response = Network.imageOfTheDayService.getImageOfTheDay()
                if (response.isSuccessful) {
                    response.body()?.let {
                        val responseBody = ImageOfTheDayMapper.toEntity(it)
                        dayDao.insertImageOfTheDay(responseBody)
                    }
                }
            } catch (e: Exception) {
                Log.d("TAG", e.toString())
            }
        }
    }

    private fun fetchImagesFromLocal() {
        viewModelScope.launch {
            dayDao.getAllImagesOfTheDay().collect{images->
                _imageOfTheDay.postValue(images)
            }
        }
    }
}