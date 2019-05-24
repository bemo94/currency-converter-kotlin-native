package com.octo.project.converter

interface ConverterRepository {
    suspend fun convert(base: String): Response
}
