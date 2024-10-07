package com.dicoding.asclepius.ui.history

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.data.HistoryRepository
import com.dicoding.asclepius.data.local.History
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : ViewModel() {

    private val historyRepository: HistoryRepository = HistoryRepository(application)
    private val _listHistory = MutableLiveData<List<History>>()
    val listHistory: LiveData<List<History>>  = _listHistory

    init {
        getAllHistory()
    }

    fun getAllHistory() {
        viewModelScope.launch {
            _listHistory.value = historyRepository.getAllHistory()
        }
    }
}