package com.octo.project.multi

import kotlinx.coroutines.*

internal expect val MainDispatcher: CoroutineDispatcher
internal expect val BackGroundDispatcher: CoroutineDispatcher

internal expect fun execute(func: suspend CoroutineScope.() -> Unit, dispatcher: CoroutineDispatcher)

internal expect fun<T> runBlockingTest(block: suspend () -> T): T