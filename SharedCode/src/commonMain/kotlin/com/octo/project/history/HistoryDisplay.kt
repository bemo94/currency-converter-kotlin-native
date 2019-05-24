package com.octo.project.history

import com.octo.project.History

interface HistoryDisplay {
    fun displayHistory(history: MutableList<History>?)
}