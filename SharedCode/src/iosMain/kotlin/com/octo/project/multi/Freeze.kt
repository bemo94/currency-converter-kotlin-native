package com.octo.project.multi

import kotlin.native.concurrent.freeze

actual fun <T> T.freeze() = freeze()