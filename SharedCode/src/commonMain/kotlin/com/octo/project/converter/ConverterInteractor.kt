package com.octo.project.converter

import com.octo.project.history.HistoryRepository

class ConverterInteractor(
    private val presenter: ConverterPresenter,
    private val converterRepository: ConverterRepository,
    private val historyRepository: HistoryRepository
) {
    suspend fun convert(base: String, to: String, value: String) {
        when (val response = converterRepository.convert(base)) {
            is Response.Result -> {
                val result = response.rates.rates[to]?.times(value.toFloat())
                // put result inside bdd here
                historyRepository.addRate(base, value, to, result.toString(), response.rates.date)
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
