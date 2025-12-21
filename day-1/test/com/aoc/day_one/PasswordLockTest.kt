package com.aoc.day_one

import kotlin.test.Test
import kotlin.test.assertEquals

class PasswordLockTest {

    @Test
    fun leftDial() {
        val passwordLock = PasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Left, 5))
        assertEquals(45, result)
    }

    @Test
    fun leftDialZero() {
        val passwordLock = PasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Left, 50))
        assertEquals(0, result)
    }


    @Test
    fun leftDialUnderflow() {
        val passwordLock = PasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Left, 68))
        assertEquals(82, result)
    }

    @Test
    fun rightDial() {
        val passwordLock = PasswordLock()
        val result = passwordLock.dial(DialInput(DialDirection.Right, 5))
        assertEquals(55, result)
    }

    @Test
    fun rightDialZero() {
        val passwordLock = PasswordLock()
        val result = passwordLock.dial(DialInput(DialDirection.Right, 50))
        assertEquals(0, result)
    }


    @Test
    fun rightDialOverflow() {
        val passwordLock = PasswordLock()
        val result = passwordLock.dial(DialInput(DialDirection.Right, 55))
        assertEquals(5, result)
    }

    @Test
    fun multiDial() {
        val passwordLock = PasswordLock()
        passwordLock.dial(DialInput(DialDirection.Left, 68))
        val result = passwordLock.dial(DialInput(DialDirection.Right, 50))

        assertEquals(32, result)
    }
}
