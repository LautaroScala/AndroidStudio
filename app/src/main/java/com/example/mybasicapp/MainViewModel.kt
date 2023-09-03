package com.example.mybasicapp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val resultText = MutableLiveData<String>()

    fun compareTexts(text1: String, text2: String) {
        resultText.value = if (text1 == text2) {
            "Los textos son iguales."
        } else {
            "Los textos son diferentes."
        }
    }
}
