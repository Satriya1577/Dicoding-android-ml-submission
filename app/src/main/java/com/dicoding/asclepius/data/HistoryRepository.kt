package com.dicoding.asclepius.data

import android.app.Application
import com.dicoding.asclepius.data.local.History
import com.dicoding.asclepius.data.local.HistoryDao
import com.dicoding.asclepius.data.local.HistoryDatabase

class HistoryRepository(application: Application) {
    private val historyDao: HistoryDao

    init {
        val db = HistoryDatabase.getDatabase(application)
        historyDao = db.noteDao()
    }

    suspend fun getAllHistory(): List<History> = historyDao.getAllHistory()

    suspend fun insertHistory(history: History) {
        historyDao.insertIntoHistory(history)
    }
}