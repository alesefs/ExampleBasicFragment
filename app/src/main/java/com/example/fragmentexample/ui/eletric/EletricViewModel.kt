package com.example.fragmentexample.ui.eletric

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EletricViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is eletric Fragment"
    }
    val text: LiveData<String> = _text
}