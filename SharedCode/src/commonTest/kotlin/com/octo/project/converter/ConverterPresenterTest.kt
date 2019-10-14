package com.octo.project.converter

import com.octo.project.multi.CoroutineContextSwitcher
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.Test

@ExperimentalCoroutinesApi
class ConverterPresenterTest {
    @Test
    fun `ConverterPresenter should call displayResult`() {
        // Given
        val display = mockk<ConverterDisplay>(relaxed = true)
        val threadManager = mockk<CoroutineContextSwitcher>(relaxed = true)
        val presenter = ConverterPresenterImpl(threadManager, display)

        // When
        presenter.presentResult("USD", "EUR", "1200")

        // Then
        threadManager.onMainThread { verify { display.displayResult("USD", "EUR", "1200") } }
    }

    @Test
    fun `ConverterPresenter should call displayAppend`() {
        // Given
        val display = mockk<ConverterDisplay>(relaxed = true)
        val threadManager = mockk<CoroutineContextSwitcher>(relaxed = true)
        val presenter = ConverterPresenterImpl(threadManager, display)

        // When
        presenter.presentAppend("11")

        // Then
        threadManager.onMainThread { verify { display.displayAppend("11") } }
    }

    @Test
    fun `ConverterPresenter should call displayError`() {
        // Given
        val display = mockk<ConverterDisplay>(relaxed = true)
        val threadManager = mockk<CoroutineContextSwitcher>(relaxed = true)
        val presenter = ConverterPresenterImpl(threadManager, display)

        // When
        presenter.presentError()

        // Then
        threadManager.onMainThread { verify { display.displayError() } }
    }

    @Test
    fun `ConverterPresenter should call displayReset`() {
        // Given
        val display = mockk<ConverterDisplay>(relaxed = true)
        val threadManager = mockk<CoroutineContextSwitcher>(relaxed = true)
        val presenter = ConverterPresenterImpl(threadManager, display)

        // When
        presenter.presentReset("0")

        // Then
        threadManager.onMainThread { verify { display.displayReset("0") } }
    }
}