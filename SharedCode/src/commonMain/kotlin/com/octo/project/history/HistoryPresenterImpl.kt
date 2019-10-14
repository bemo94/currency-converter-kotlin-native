package com.octo.project.history

import com.octo.project.History
import com.octo.project.multi.CoroutineContextSwitcher

class HistoryPresenterImpl(
    private val threadManager: CoroutineContextSwitcher,
    private val display: HistoryDisplay
) : HistoryPresenter {
    override fun presentHistory(history: MutableList<History>?) {
        threadManager.onMainThread {
            val reversed = history?.asReversed()
            display.displayHistory(reversed)
        }
    }
}