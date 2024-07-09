package com.multiplying_numbers.Utils

import android.util.Log
import kotlinx.coroutines.delay



suspend fun String.printString(delay: Long, stringForPrint: (String) -> Unit) {
     this.split("").forEach {
        delay(delay )
        stringForPrint(it)
    }
}
