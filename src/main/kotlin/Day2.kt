import java.util.stream.Collectors.toList

class Day2 {

    fun setupAndSolvePart1(intCodesAsString: String): Int {
        val intList = intCodesAsString.split(",").stream()
            .map { intcode -> intcode.toInt() }
            .collect(toList())
        intList.set(1, 12)
        intList.set(2, 2)
        return solvePart1(intList as ArrayList<Int>).get(0)
    }

    tailrec fun solvePart1(intList: ArrayList<Int>, index: Int = 0): ArrayList<Int> =
        when (intList.get(index)) {
            1 -> {
                doOperation(intList, index) { a, b -> a + b }
                solvePart1(intList, index + 4)
            }
            2 -> {
                doOperation(intList, index) { a, b -> a * b }
                solvePart1(intList, index + 4)
            }
            99 -> intList
            else -> throw IllegalStateException();
        }

    fun doOperation(intList: ArrayList<Int>, index: Int, operation: (a: Int, b: Int) -> Int) =
        intList.set(
            intList.get(index + 3),
            operation(intList.get(intList.get(index + 1)), intList.get(intList.get(index + 2)))
        );

}