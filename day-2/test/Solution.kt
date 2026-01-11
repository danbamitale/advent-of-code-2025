import com.aoc.day_2.InputParser
import com.aoc.day_2.Solution
import kotlin.test.Test
import kotlin.test.assertEquals


class Solution {
    @Test
    fun testExampleSolution() {
        val stream = javaClass.getResourceAsStream("test-input.txt")
        val inputs = InputParser.parseInput(stream)
        val result = Solution.part1(inputs)

        assertEquals(1227775554L, result, "Result should be 1227775554L")
    }


    @Test
    fun testExampleSolution2() {
        val stream = javaClass.getResourceAsStream("test-input.txt")
        val inputs = InputParser.parseInput(stream)
        val result = Solution.part2(inputs)

        assertEquals(4174379265L, result, "Result should be 4174379265")
    }
}
