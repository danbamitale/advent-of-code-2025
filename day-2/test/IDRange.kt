import com.aoc.day_2.IDRange
import com.aoc.day_2.invalidValues
import com.aoc.day_2.invalidValuesV2
import com.aoc.day_2.isValid
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IDRange {

    @Test
    fun testHasValidRange() {
        val range = IDRange(12L, 21L)
        assertTrue(range.isValid(), "Range is valid")
    }

    @Test
    fun testHasInvalidRange() {
        val range = IDRange(11L, 22L)
        assertFalse(range.isValid(), "Range is invalid")
    }

    @Test
    fun testExtendedHasValidRange() {
        val range = IDRange(1698522L, 1698528L)
        assertTrue(range.isValid(), "Range is valid")
    }

    @Test
    fun testExtendedInvalidRange() {
        val range = IDRange(38593856L, 38593862L)
        assertFalse(range.isValid(), "Range is invalid")
    }

    @Test
    fun testEmptyInvalidValues() {
        val range = IDRange(12L, 21L)
        assertEquals(range.invalidValues.size, 0, "Range has not invalid ids")
    }


    @Test
    fun testSingleInvalidValues() {
        val range = IDRange(38593856L, 38593862L)
        assertEquals(range.invalidValues.size, 1, "Range has 1 invalid id")
    }

    @Test
    fun testDoubleInvalidValues() {
        val range = IDRange(11L, 22L)
        assertEquals(range.invalidValues.size, 2, "Range has 2 invalid id")
    }

    @Test
    fun testInvalidValuesV2Simple() {
        val range = IDRange(11L, 22L)
        assertEquals(range.invalidValuesV2.size, 2, "Range has 2 invalid ids")
    }

    @Test
    fun testInvalidValuesV2Simple2() {
        val range = IDRange(95L, 115L)
        val result = range.invalidValuesV2
        assertEquals(result.size, 2, "Range has 2 invalid ids")
    }

    @Test
    fun testInvalidValuesV2Complex() {
        val range = IDRange(998L, 1012L)
        val result = range.invalidValuesV2
        assertEquals(result.size, 2, "Range has 2 invalid ids")
    }

    @Test
    fun testInvalidValuesV2Complex1() {
        val range = IDRange(1188511880L, 1188511890L)
        val result = range.invalidValuesV2
        assertEquals(result.size, 1, "Range has 1 invalid id")
    }

    @Test
    fun testInvalidValuesV2Complex2() {
        val range = IDRange(38593856L, 38593862L)
        val result = range.invalidValuesV2
        assertEquals(result.size, 1, "Range has 1 invalid id")
    }
}
