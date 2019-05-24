package com.octo.project.converter

import com.octo.project.app.Rates
import com.octo.project.multi.runBlockingTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class ConverterRepositoryTest {

    @Test
    fun `ConverterRepositoryImpl should return Result`() {

        // Given
        val rates = emptyMap<String, Float>().toMutableMap()
        rates["EU"] = 1.1F
        val expectedRates = Rates("EU", rates, "2019-01-01")
        val expectedResult = Response.Result(expectedRates)

        val repository = mockk<ConverterRepositoryImpl> {
           coEvery { convert("EUR") } coAnswers { expectedResult }
        }

        // When
        val result = runBlockingTest { repository.convert("EUR") }

        // Then
        coVerify { repository.convert("EUR") }
        assertEquals(result, expectedResult)
    }

    @Test
    fun `ConverterRepositoryImpl should return Error`() {

        // Given
        val expected = Response.Error

        val repository = mockk<ConverterRepository> {
            coEvery { convert("EUR") } coAnswers { expected }
        }

        // When
        val result = runBlockingTest { repository.convert("EUR") }

        // Then
        coVerify { repository.convert("EUR") }
        assertEquals(result, expected)
    }
}
