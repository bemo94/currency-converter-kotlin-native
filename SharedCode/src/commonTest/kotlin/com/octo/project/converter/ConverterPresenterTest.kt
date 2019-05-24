package com.octo.project.converter

import com.octo.project.MockDispatcherProvider
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
        val provider = MockDispatcherProvider()
        val presenter = ConverterPresenterImpl(provider, display)

        // When
        presenter.presentResult("USD", "EUR", "1200")

        // Then
        verify { display.displayResult("USD", "EUR", "1200") }
    }

    @Test
    fun `ConverterPresenter should call displayAppend`() {
        // Given
        val display = mockk<ConverterDisplay>(relaxed = true)
        val provider = MockDispatcherProvider()
        val presenter = ConverterPresenterImpl(provider, display)

        // When
        presenter.presentAppend("11")

        // Then
        verify { display.displayAppend("11") }
    }

    @Test
    fun `ConverterPresenter should call displayError`() {
        // Given
        val display = mockk<ConverterDisplay>(relaxed = true)
        val provider = MockDispatcherProvider()
        val presenter = ConverterPresenterImpl(provider, display)

        // When
        presenter.presentError()

        // Then
        verify { display.displayError() }
    }

    @Test
    fun `ConverterPresenter should call displayReset`() {
        // Given
        val display = mockk<ConverterDisplay>(relaxed = true)
        val provider = MockDispatcherProvider()
        val presenter = ConverterPresenterImpl(provider, display)

        // When
        presenter.presentReset("0")

        // Then
        verify { display.displayReset("0") }
    }
}