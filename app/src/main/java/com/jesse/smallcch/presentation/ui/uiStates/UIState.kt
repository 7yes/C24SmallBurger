package com.jesse.smallcch.presentation.ui.uiStates

import com.jesse.smallcch.data.model.SmallResponseItem

sealed class UIState {
    data object Loading:UIState()
    data class Error(val error:String):UIState()
    data class Success(val horoscopeList:List<SmallResponseItem>):UIState()
}

