package com.octo.project.converter

import com.octo.project.app.DispatchProvider
import com.octo.project.multi.execute

class ConverterPresenterImpl(private val provider: DispatchProvider, private val display: ConverterDisplay): ConverterPresenter {
    override fun presentResult(base: String, to: String, value: String) {
        execute({ display.displayResult(base, to, value) }, provider.main)
    }

    override fun presentReset(value: String) {
        execute({ display.displayReset(value) }, provider.main)
    }

    override fun presentAppend(value: String) {
        execute({ display.displayAppend(value) }, provider.main)
    }

    override fun presentError() {
        execute({ display.displayError() }, provider.main)
    }

}
