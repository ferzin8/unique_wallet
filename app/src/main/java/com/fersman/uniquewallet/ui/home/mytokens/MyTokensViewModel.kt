package com.fersman.uniquewallet.ui.home.mytokens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyTokensViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "My tokens"
    }
    val text: LiveData<String> = _text
}