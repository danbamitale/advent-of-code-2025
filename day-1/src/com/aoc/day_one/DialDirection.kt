package com.aoc.day_one

enum class DialDirection {
    Right, Left;

    companion object {
        fun from(char: Char): DialDirection {
            return when (char)  {
                'R' -> Right
                'L' -> Left
                else -> throw RuntimeException("Unexpected character $char")
            }
        }
    }
}
