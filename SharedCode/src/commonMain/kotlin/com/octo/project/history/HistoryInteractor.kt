package com.octo.project.history

class HistoryInteractor(
    private val presenter: HistoryPresenter,
    private val repository: HistoryRepository
) {
    fun loadHistory() {
        val result = repository.getHistory()
        presenter.presentHistory(result)
    }
}