package com.octo.project.converter

import com.octo.project.app.DispatchProvider
import com.octo.project.multi.execute

class ConverterController(private val provider: DispatchProvider, private val interactor: ConverterInteractor) {
    fun convert(base: String, to: String, value: String) {
        execute({ interactor.convert(base, to, value) }, provider.background)
    }

    fun reset() {
        execute({ interactor.reset() }, provider.background)
    }

    fun append(initial: String, value: String) {
        execute({ interactor.append(initial, value) }, provider.background)
    }
}
