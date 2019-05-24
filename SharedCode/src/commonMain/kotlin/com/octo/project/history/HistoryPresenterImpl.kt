package com.octo.project.history

import com.octo.project.History
import com.octo.project.app.DispatchProvider
import com.octo.project.multi.execute

class HistoryPresenterImpl(private val provider: DispatchProvider, private val display: HistoryDisplay): HistoryPresenter {
    override fun presentHistory(history: MutableList<History>?) {
        execute({ display.displayHistory(history) }, provider.main)
    }
}