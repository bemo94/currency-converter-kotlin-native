package com.octo.project.history

import com.octo.project.History
import com.octo.project.MockDispatcherProvider
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.Test

@ExperimentalCoroutinesApi
class HistoryPresenterTest {
    @Test
    fun `HistoryPresenter should call displayHistory`() {
        // Given
        val expected: MutableList<History> = arrayListOf()
        val display = mockk<HistoryDisplay>(relaxed = true)
        val provider = MockDispatcherProvider()
        val presenter = HistoryPresenterImpl(provider, display)

        // When

        presenter.presentHistory(expected)

        // Then
        verify { display.displayHistory(expected) }
    }
}