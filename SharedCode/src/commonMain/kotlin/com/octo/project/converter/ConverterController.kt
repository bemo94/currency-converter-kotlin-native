package com.octo.project.converter

import com.octo.project.multi.CoroutineContextSwitcher

class ConverterController(
    private val threadManager: CoroutineContextSwitcher,
    private val interactor: ConverterInteractor
) {
    fun convert(base: String, to: String, value: String) {
        threadManager.onBackgroundThread {
            interactor.convert(base, to, value)
        }
    }

    fun reset() {
        threadManager.onBackgroundThread {
            interactor.reset()
        }
    }

    fun append(initial: String, value: String) {
        threadManager.onBackgroundThread {
            interactor.append(initial, value)
        }
    }
}
