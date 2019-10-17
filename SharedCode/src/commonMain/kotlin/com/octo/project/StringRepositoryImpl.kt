package com.octo.project

class StringRepositoryImpl: StringRepository {
    override fun getKotlinString(): String {
        return "Kotlin"
    }

    override fun getEverString(): String {
        return "Ever"
    }
}
