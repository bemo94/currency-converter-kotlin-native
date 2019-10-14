package com.octo.project.history

import com.octo.project.multi.CoroutineContextSwitcher

class HistoryController(
    private val threadManager: CoroutineContextSwitcher,
    private val interactor: HistoryInteractor
) {
    fun loadHistory() {
        threadManager.onBackgroundThread { interactor.loadHistory() }
    }
}