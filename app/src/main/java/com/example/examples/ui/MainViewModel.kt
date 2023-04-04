package com.example.examples.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    sealed class UiEvent {
        data class ErrorEvent(val message: String) : UiEvent()
    }

    private val eventChannel = Channel<UiEvent.ErrorEvent>()
    val eventFlow = eventChannel.receiveAsFlow()

    fun triggerEvent() = viewModelScope.launch {
        eventChannel.send(UiEvent.ErrorEvent("This is err"))
    }
}