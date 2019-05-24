package com.octo.project.converter

import com.octo.project.app.Rates
import com.octo.project.multi.runBlockingTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.Test

@ExperimentalCoroutinesApi
class ConverterInteractorTest {
    @Test
    fun `ConverterInteractor should presentAppend`() {
        // Given
        val presenter = mockk<ConverterPresenter>(relaxed = true)
        val repository = mockk<ConverterRepository> (relaxed = true)
        val interactor = ConverterInteractor(presenter, repository, repository2)

        // When
        runBlockingTest { interactor.append("1", "1") }

        // Then
        coVerify { presenter.presentAppend("11") }
    }

    @Test
    fun `ConverterInteractor should presentResult`() {
        // Give
        val presenter = mockk<ConverterPresenterImpl>(relaxed = true)
        val expected = mockk<Rates>(relaxed = true)
        val repository = mockk<ConverterRepositoryImpl> {
            coEvery { convert("EUR") } coAnswers { Response.Result(expected) }
        }
        val interactor = ConverterInteractor(presenter, repository, repository2)

        // When
        runBlockingTest { interactor.convert("EUR", "USD", "1200") }

        // Then
        coVerify { presenter.presentResult("EUR", "USD", "1200") }
    }

    @Test
    fun `ConverterInteractor should presentReset`() {
        // Give
        val presenter = mockk<ConverterPresenterImpl>(relaxed = true)
        val repository = mockk<ConverterRepositoryImpl> (relaxed = true)
        val interactor = ConverterInteractor(presenter, repository, repository2)

        // When
        runBlockingTest { interactor.reset() }

        // Then
        coVerify { presenter.presentReset("0") }
    }

    @Test
    fun `ConverterInteractor should presentError`() {
        // Give
        val presenter = mockk<ConverterPresenterImpl>(relaxed = true)
        val repository = mockk<ConverterRepositoryImpl> {
            coEvery { convert("EUR") } coAnswers { Response.Error }
        }
        val interactor = ConverterInteractor(presenter, repository, repository2)

        // When
        runBlockingTest { interactor.convert("EUR", "USD", "1200") }

        // Then
        coVerify { repository.convert("EUR") }
        coVerify { presenter.presentError() }
    }
}
