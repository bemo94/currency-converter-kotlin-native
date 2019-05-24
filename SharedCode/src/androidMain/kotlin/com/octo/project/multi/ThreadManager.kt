package com.octo.project.multi

import kotlinx.coroutines.*

internal actual val MainDispatcher: CoroutineDispatcher = Dispatchers.Main
internal actual val BackGroundDispatcher: CoroutineDispatcher = Dispatchers.IO

internal actual fun execute(func: suspend CoroutineScope.() -> Unit, dispatcher: CoroutineDispatcher) {
    GlobalScope.launch(dispatcher) { func() }
}

actual fun<T> runBlockingTest(block: suspend () -> T): T {
    return runBlocking {
        block()
    }
}


