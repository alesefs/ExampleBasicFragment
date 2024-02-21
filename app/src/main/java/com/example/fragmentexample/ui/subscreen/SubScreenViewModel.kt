package com.example.fragmentexample.ui.subscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubScreenViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is SubScreen Fragment"
    }
    val text: LiveData<String> = _text
}