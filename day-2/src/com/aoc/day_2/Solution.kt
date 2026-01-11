package com.aoc.day_2

object Solution {
    fun part1(list: List<IDRange>): Long {
       return list.map {
           it.invalidValues
       }.sumOf {
           it.sum()
       }
    }

    fun part2(list: List<IDRange>): Long {
        return list.map {
            it.invalidValuesV2
        }.sumOf {
            it.sum()
        }
    }
}
