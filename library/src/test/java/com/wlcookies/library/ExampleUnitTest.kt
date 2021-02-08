package com.wlcookies.library

import com.wlcookies.library.utils.getTimeUUID
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println(getTimeUUID())
        println(getTimeUUID(7))
        println(getTimeUUID(8))
    }
}