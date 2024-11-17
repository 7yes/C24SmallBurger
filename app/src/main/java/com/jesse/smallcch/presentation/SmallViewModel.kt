package com.jesse.smallcch.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jesse.smallcch.Domain.GetDataUC
import com.jesse.smallcch.data.model.SmallResponseItem
import com.jesse.smallcch.presentation.ui.uiStates.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SmallViewModel @Inject constructor(private val getDataUC: GetDataUC) : ViewModel() {

    private val _lastSelected = MutableLiveData<SmallResponseItem>()
    val lastSelected: LiveData<SmallResponseItem> = _lastSelected

    private val _state = MutableLiveData<UIState>(UIState.Loading)
    val state: LiveData<UIState> = _state


    suspend fun getData() {
        _state.postValue(UIState.Loading)
        // viewModelScope.launch(Dispatchers.IO) {
        val response = getDataUC()
        Log.d("TAG", "getData on VM: $response: ")
        _state.postValue(UIState.Success(response))
        //_myData.postValue(response)
        // }
    }

    fun lastSelected(item: SmallResponseItem) {
        _lastSelected.postValue(item)
    }
}