package com.octo.project

import platform.UIKit.UIDevice

actual fun getDeviceOs(): String = "Hello ${UIDevice.currentDevice.systemName()}"
