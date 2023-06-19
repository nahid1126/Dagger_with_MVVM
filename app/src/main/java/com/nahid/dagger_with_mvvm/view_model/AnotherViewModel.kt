package com.nahid.dagger_with_mvvm.view_model

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AnotherViewModel @Inject constructor(private val random: Randomize) : ViewModel() {
    init {
        random.doAction()
    }
}