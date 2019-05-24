package com.octo.project.history

import com.octo.project.app.DispatchProvider
import com.octo.project.multi.execute

class HistoryController (private val provider: DispatchProvider, private val interactor: HistoryInteractor) {
    fun loadHistory() {
        execute({ interactor.loadHistory() }, provider.background)
    }
}