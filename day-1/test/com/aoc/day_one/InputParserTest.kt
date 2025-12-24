package com.aoc.day_one

import java.io.ByteArrayInputStream
import kotlin.test.Test
import kotlin.test.assertEquals

class InputParserTest {

    @Test
    fun testSingleLineParse() {
        val stream = ByteArrayInputStream("L68".encodeToByteArray())
        val inputs = InputParser.parse(stream)
        assertEquals(1, inputs.size, "Input parser should have exactly 1 item")
        assertEquals(DialInput(DialDirection.Left, 68), inputs.first(), "Correctly parse input")
    }

    @Test
    fun testMultipleLineParse() {
       val stringInput = """
           L68
           L30
           R48
           L5
           R60
           L55
           L1
           L99
           R14
           L82
       """.trimIndent()

        val stream = ByteArrayInputStream(stringInput.encodeToByteArray())
        val inputs = InputParser.parse(stream)
        assertEquals(10, inputs.size, "Input parser should have exactly 10 item")
        assertEquals(DialInput(DialDirection.Left, 68), inputs.first(), "Correctly parse input")
        assertEquals(DialInput(DialDirection.Right, 48), inputs[2], "Correctly parse input")
        assertEquals(DialInput(DialDirection.Left, 82), inputs.last(), "Correctly parse input")
    }

    @Test
    fun testFileInputParse() {
        val stream = javaClass.getResourceAsStream("/test-input.txt")
        val inputs = InputParser.parse(stream)
        assertEquals(17, inputs.size, "Input parser should have exactly 10 item")
        assertEquals(DialInput(DialDirection.Right, 46), inputs.first(), "Correctly parse input")
        assertEquals(DialInput(DialDirection.Left, 29), inputs[3], "Correctly parse input")
        assertEquals(DialInput(DialDirection.Right, 35), inputs.last(), "Correctly parse input")
    }
}
