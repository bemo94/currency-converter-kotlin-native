package com.octo.project.converter

import com.octo.project.MockDispatcherProvider
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.Test

@ExperimentalCoroutinesApi
class ConverterControllerTest {
    @Test
    fun `ConverterController should call convert`() {
        // Give
        val interactor = mockk<ConverterInteractor>(relaxed = true)
        val provider = MockDispatcherProvider()
        val controller = ConverterController(provider, interactor)

        // When
        controller.convert("EUR", "USD", "1200")

        // Then
        coVerify { interactor.convert("EUR", "USD", "1200") }
    }

    @Test
    fun `ConverterController should call reset`() {
        // Give
        val interactor = mockk<ConverterInteractor>(relaxed = true)
        val provider = MockDispatcherProvider()
        val controller = ConverterController(provider, interactor)

        // When
        controller.reset()

        // Then
        coVerify { interactor.reset() }
    }

    @Test
    fun `ConverterController should call append`() {
        // Give
        val interactor = mockk<ConverterInteractor>(relaxed = true)
        val provider = MockDispatcherProvider()
        val controller = ConverterController(provider, interactor)

        // When
        controller.append("10", "1")

        // Then
        coVerify { interactor.append("10", "1") }
    }
}