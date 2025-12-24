package com.aoc.day_one

internal const val LOCK_LIMIT = 100
internal const val INITIAL_LOCK_STATE = 50

interface Lock {
    fun dial(input: DialInput): Int
}

