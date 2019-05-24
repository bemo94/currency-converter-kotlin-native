package com.octo.project.history

import com.octo.project.MockDispatcherProvider
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
        val provider = MockDispatcherProvider()
        val controller = HistoryController(provider, interactor)

        // When
        controller.loadHistory()

        // Then
        coVerify { interactor.loadHistory() }
    }
}