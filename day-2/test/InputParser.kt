import com.aoc.day_2.InputParser
import com.aoc.day_2.IDRange
import java.io.ByteArrayInputStream
import kotlin.test.Test
import kotlin.test.assertEquals

class InputParser {

    @Test
    fun testInputParsing() {
        val inputs = InputParser.parseInput(ByteArrayInputStream("11-22,95-115".encodeToByteArray()))
        assertEquals(inputs.size, 2, "Input should contain exactly 2 inputs")
    }

    @Test
    fun testFileInputParsing() {
        val stream = javaClass.getResourceAsStream("test-input.txt")
        val inputs = InputParser.parseInput(stream)
        assertEquals(inputs.size, 11, "Input should contain exactly 11 inputs")
    }

    @Test
    fun testFileInputParsedCorrectly() {
        val stream = javaClass.getResourceAsStream("test-input.txt")
        val inputs = InputParser.parseInput(stream)
        assertEquals(inputs.first(), IDRange(11L, 22L), "Input at each index should be equal")
        assertEquals(inputs.last(), IDRange(2121212118L, 2121212124L), "Input at each index should be equal")
    }

}
