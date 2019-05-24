package com.octo.project.converter

interface ConverterDisplay {
    fun displayResult(base: String, to: String, value: String)
    fun displayError()
    fun displayAppend(value: String)
    fun displayReset(value: String)
}
