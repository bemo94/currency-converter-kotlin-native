package com.octo.project.history

import com.octo.project.History
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
    fun `HistoryRepositoryImpl should return Result`() {

        // Given
        val expected: MutableList<History> = arrayListOf()

        val repository = mockk<HistoryRepository> {
            coEvery { getHistory() } coAnswers { expected }
        }

        // When
        val result = runBlockingTest { repository.getHistory() }

        // Then
        coVerify { repository.getHistory() }
        assertEquals(result, expected)
    }
}