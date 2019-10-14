package com.octo.project.history

import com.octo.project.multi.CoroutineContextSwitcher
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.Test

@ExperimentalCoroutinesApi
class HistoryControllerTest {
    @Test
    fun `HistoryController should call loadHistory`() {
        // Give
        val interactor = mockk<HistoryInteractor>(relaxed = true)
        val threadManager = CoroutineContextSwitcher.newInstance()

        val controller = HistoryController(threadManager, interactor)

        // When
        controller.loadHistory()

        // Then
        coVerify { interactor.loadHistory() }
    }
}