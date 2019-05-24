package com.octo.project.app

import kotlinx.serialization.Serializable

@Serializable
data class Rates(val base: String, val rates: Map<String, Float>, val date: String)