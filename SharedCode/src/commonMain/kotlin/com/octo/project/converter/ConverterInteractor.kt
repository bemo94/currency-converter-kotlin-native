package com.octo.project.converter

import com.octo.project.app.LocalRepository

class ConverterInteractor(
    private val presenter: ConverterPresenter,
    private val repository: ConverterRepository,
    private val repository2: LocalRepository
) {
    suspend fun convert(base: String, to: String, value: String) {
        when (val response = repository.convert(base)) {
            is Response.Result -> {
                val result = response.rates.rates[to]?.times(value.toFloat())
                // put result inside bdd here
                repository2.addRate(base, value, to, result.toString(), response.rates.date)
                presenter.presentResult(base, to, result.toString())
            }
            is Response.Error -> {
                presenter.presentError()
            }
        }
    }

    fun reset() {
        presenter.presentReset("0")
    }

    fun append(initial: String, value: String) {
        if (value == ".") {
            if (!initial.contains('.')) {
                presenter.presentAppend("$initial.")
            }
        } else {
            if (initial != "0") {
                presenter.presentAppend(initial + value)
            } else {
                presenter.presentAppend(value)
            }
        }
    }
}
