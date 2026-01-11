package com.aoc.day_2

import kotlin.math.ceil

data class IDRange(val start: Long, val end: Long)

val IDRange.invalidValues: List<Long>
    get() {
        return (start..end).filter {
            val string = it.toString()
            val midPoint = string.length / 2
            val firstPart = string.substring(0..<midPoint)
            val lastPart = string.substring(midPoint)
            firstPart == lastPart
        }
    }


fun IDRange.isValid(): Boolean {
    return invalidValues.isEmpty()
}


val IDRange.invalidValuesV2: List<Long>
    get() {
        return (start..end).filter {
            val string = it.toString()

            val len = string.length
            val midPoint =  ceil(len.toDouble() / 2).toLong()

            var isInvalid = false
            for (i in 1..midPoint) {
                val pattern = string.substring(0, i.toInt())
                val matches = Regex(pattern).findAll(string)

                val count = matches.count()
                if (count > 1 && (string.length == (count * pattern.length))) {
                    isInvalid = true
                    break
                }
            }

            isInvalid
        }
    }
