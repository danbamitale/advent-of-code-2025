package com.aoc.day_2

import java.io.InputStream

object InputParser {
    fun parseInput(stream: InputStream): List<IDRange> {
        val inputString =  stream.bufferedReader().use { it.readText() }

        return inputString.trim().split(",").map {
            val parts =  it.split("-")
            IDRange(parts[0].toLong(), parts[1].toLong())
        }
    }
}
