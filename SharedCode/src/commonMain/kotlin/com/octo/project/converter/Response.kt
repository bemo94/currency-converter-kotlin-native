package com.octo.project.converter

import com.octo.project.app.Rates

sealed class Response {
    class Result(val rates: Rates) : Response()
    object Error: Response()
}
