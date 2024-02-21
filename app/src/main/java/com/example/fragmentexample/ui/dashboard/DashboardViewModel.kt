package com.example.fragmentexample.ui.dashboard

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fragmentexample.R
import com.example.fragmentexample.models.DashboardButtonsModel

class DashboardViewModel(private val application: DashboardFragment) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private fun listButton() : List<DashboardButtonsModel> = listOfNotNull(
        DashboardButtonsModel(
            application.getString(R.string.title_1),
            application.getString(R.string.title_1),
            R.drawable.ic_launcher_foreground
        ),
        DashboardButtonsModel(
            application.getString(R.string.app_name),
            application.getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        ),
        DashboardButtonsModel(
            application.getString(R.string.app_name),
            application.getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        ),
        DashboardButtonsModel(
            application.getString(R.string.app_name),
            application.getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        )
    )

    private val _button = MutableLiveData<List<DashboardButtonsModel>>().apply {
        value = listButton()
    }

    val button: LiveData<List<DashboardButtonsModel>> = _button

}