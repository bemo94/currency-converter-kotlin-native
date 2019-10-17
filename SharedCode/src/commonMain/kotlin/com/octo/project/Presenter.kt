package com.octo.project

class Presenter(private val stringRepository: StringRepository, private val intRepository: IntRepository, private val displayer: Displayer) {
    fun presentConcat() {
        val string: String = stringRepository.getKotlinString() + intRepository.getInt() + stringRepository.getEverString()
        displayer.display(string)
    }
}
