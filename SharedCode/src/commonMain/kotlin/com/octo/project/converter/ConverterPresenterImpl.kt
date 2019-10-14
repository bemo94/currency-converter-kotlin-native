package com.octo.project.converter

import com.octo.project.multi.CoroutineContextSwitcher

class ConverterPresenterImpl(
    private val threadManager: CoroutineContextSwitcher,
    private val display: ConverterDisplay
) : ConverterPresenter {

    override fun presentResult(base: String, to: String, value: String) {
        threadManager.onMainThread {
            display.displayResult(base, to, value)
        }
    }

    override fun presentReset(value: String) {
        threadManager.onMainThread {
            display.displayReset(value)
        }
    }

    override fun presentAppend(value: String) {
        threadManager.onMainThread {
            display.displayAppend(value)
        }
    }

    override fun presentError() {
        threadManager.onMainThread {
            display.displayError()
        }
    }

}
