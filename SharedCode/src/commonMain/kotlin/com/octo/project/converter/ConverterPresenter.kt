package com.octo.project.converter

interface ConverterPresenter {
    fun presentResult(base: String, to: String, value: String)
    fun presentReset(value: String)
    fun presentAppend(value: String)
    fun presentError()
}