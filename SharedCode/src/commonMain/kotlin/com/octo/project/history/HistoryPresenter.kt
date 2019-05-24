package com.octo.project.history

import com.octo.project.History

interface HistoryPresenter {
    fun presentHistory(history: MutableList<History>?)
}