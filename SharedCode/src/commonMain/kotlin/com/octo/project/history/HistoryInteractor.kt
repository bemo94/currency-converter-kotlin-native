package com.octo.project.history

import com.octo.project.app.LocalRepository

class HistoryInteractor(
    private val presenter: HistoryPresenter,
    private val repository: LocalRepository
) {
    fun loadHistory() {
        val result = repository.getHistory()
        presenter.presentHistory(result)
    }
}