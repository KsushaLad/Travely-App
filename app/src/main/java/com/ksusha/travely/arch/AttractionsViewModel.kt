package com.ksusha.travely.arch

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksusha.travely.data.Attraction
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AttractionsViewModel : ViewModel() {

    private val repository = AttractionsRepository()
    val attractionListLiveData = MutableLiveData<ArrayList<Attraction>>()
    val selectedAttractionLiveData = MutableLiveData<Attraction>()
    val locationSelectedLiveData = MutableLiveData<Attraction>()

    fun init(context: Context) {
        viewModelScope.launch {
            delay(2_000)
            val attractionsList = repository.parseAttractions(context)
            attractionListLiveData.postValue(attractionsList)
        }
    }

    fun onAttractionSelected(attractionId: String) {
        val attraction = attractionListLiveData.value?.find {
            it.id == attractionId
        } ?: return
        selectedAttractionLiveData.postValue(attraction)
    }
}