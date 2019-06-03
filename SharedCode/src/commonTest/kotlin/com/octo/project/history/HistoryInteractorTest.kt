package com.octo.project.history

import com.octo.project.multi.runBlockingTest
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.Test


@ExperimentalCoroutinesApi
class HistoryInteractorTest {
    @Test
    fun `HistoryInteractor should presentHistory`() {
        // Given
        val presenter = mockk<HistoryPresenter>(relaxed = true)
        val repository = mockk<HistoryRepository> (relaxed = true)
        val interactor = HistoryInteractor(presenter, repository)

        // When
        runBlockingTest { interactor.loadHistory() }

        // Then
        coVerify { presenter.presentHistory(any()) }
    }
}