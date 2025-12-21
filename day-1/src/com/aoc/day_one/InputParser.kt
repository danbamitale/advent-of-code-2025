package com.aoc.day_one

import java.io.InputStream

interface InputParser {
    fun parse(stream: InputStream): List<DialInput>


    companion object: InputParser{
        override fun parse(stream: InputStream): List<DialInput> {
            val list = ArrayList<DialInput>()
            stream.use {
                val lines = stream.reader().readLines()
                for (line in lines) {
                    val direction = DialDirection.from(line[0])
                    val count =  line.substring(1).toInt()
                    list.add(DialInput(direction, count))
                }
            }
            return list
        }
    }
}

