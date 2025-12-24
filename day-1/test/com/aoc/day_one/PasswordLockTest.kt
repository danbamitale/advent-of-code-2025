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

    @Test
    fun leftDial100() {
        val passwordLock = PasswordLock()
        val result = passwordLock.dial(DialInput(DialDirection.Left, 100))
        assertEquals(50, result)
    }

    @Test
    fun rightDial100() {
        val passwordLock = PasswordLock()
        val result = passwordLock.dial(DialInput(DialDirection.Right, 100))
        assertEquals(50, result)
    }

    @Test
    fun leftDial1032() {
        val passwordLock = PasswordLock()
        val result = passwordLock.dial(DialInput(DialDirection.Left, 1032))
        assertEquals(18, result)
    }

    @Test
    fun leftDialWrapCounterZero() {
        val passwordLock = TransitionTrackingPasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Left, 32))
        assertEquals(18, result, "state is 18")
        assertEquals(0, passwordLock.zeroCounter, "Wrap counter is 0")
    }

    @Test
    fun leftDialWrapCounterOne() {
        val passwordLock = TransitionTrackingPasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Left, 50))
        assertEquals(0, result, "state is zero")
        assertEquals(1, passwordLock.zeroCounter, "Wrap counter is 1")
    }

    @Test
    fun leftDialWrapCounterOneState82() {
        val passwordLock = TransitionTrackingPasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Left, 68))
        assertEquals(82, result, "state is 82")
        assertEquals(1, passwordLock.zeroCounter, "Wrap counter is 1")
    }

    @Test
    fun leftDialWrapCounterOneState82Alternate() {
        val passwordLock = TransitionTrackingPasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Left, 168))
        assertEquals(82, result, "state is 82")
        assertEquals(2, passwordLock.zeroCounter, "Wrap counter is 2")
    }


    @Test
    fun leftDialWrapCounter1000() {
        val passwordLock = TransitionTrackingPasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Left, 1000))
        assertEquals(50, result, "state is 50")
        assertEquals(10, passwordLock.zeroCounter, "Wrap counter is 10")
    }

    @Test
    fun rightDialWrapCounterZero() {
        val passwordLock = TransitionTrackingPasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Right, 32))
        assertEquals(82, result, "state is zero")
        assertEquals(0, passwordLock.zeroCounter, "Wrap counter is 0")
    }

    @Test
    fun rightDialWrapCounterOne() {
        val passwordLock = TransitionTrackingPasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Right, 50))
        assertEquals(0, result, "state is zero")
        assertEquals(1, passwordLock.zeroCounter, "Wrap counter is 1")
    }


    @Test
    fun rightDialWrapCounter1000() {
        val passwordLock = TransitionTrackingPasswordLock()

        val result = passwordLock.dial(DialInput(DialDirection.Right, 1000))
        assertEquals(50, result, "state is 50")
        assertEquals(10, passwordLock.zeroCounter, "Wrap counter is 10")
    }
}
