package com.octo.project.multi

actual fun <T> T.freeze(): T {
    return this
}