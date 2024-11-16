package com.jesse.smallcch.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jesse.smallcch.Domain.GetDataUC
import com.jesse.smallcch.data.model.SmallResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SmallViewModel @Inject constructor(private val getDataUC: GetDataUC) : ViewModel() {

    private val _myData = MutableLiveData<List<SmallResponseItem>>()
    val myData: LiveData<List<SmallResponseItem>> = _myData

    private val _lastSelected = MutableLiveData<SmallResponseItem>()
    val lastSelected: LiveData<SmallResponseItem> = _lastSelected
    suspend fun getData() {
        // viewModelScope.launch(Dispatchers.IO) {
        val response = getDataUC()
        Log.d("TAG", "getData on VM: $response: ")
        _myData.postValue(response)
        // }
    }

    fun lastSelected(item: SmallResponseItem) {
        _lastSelected.postValue(item)
    }
}