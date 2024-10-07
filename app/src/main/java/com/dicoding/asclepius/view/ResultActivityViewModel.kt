package com.dicoding.asclepius.view

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.data.HistoryRepository
import com.dicoding.asclepius.data.local.History
import kotlinx.coroutines.launch

class ResultActivityViewModel(application: Application): ViewModel() {

    private val historyRepository: HistoryRepository = HistoryRepository(application)

    fun insertHistory(history: History) {
        viewModelScope.launch {
            historyRepository.insertHistory(history)
        }
    }
}