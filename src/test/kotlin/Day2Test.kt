import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day2Test {

    @Test
    fun day2part1_examples() {
        assertThat(Day2().solvePart1(arrayListOf(1,0,0,0,99))).isEqualTo(arrayListOf(2,0,0,0,99));
        assertThat(Day2().solvePart1(arrayListOf(2,3,0,3,99))).isEqualTo(arrayListOf(2,3,0,6,99));
        assertThat(Day2().solvePart1(arrayListOf(2,4,4,5,99,0))).isEqualTo(arrayListOf(2,4,4,5,99,9801));
        assertThat(Day2().solvePart1(arrayListOf(1,1,1,4,99,5,6,0,99))).isEqualTo(arrayListOf(30,1,1,4,2,5,6,0,99));
    }
}