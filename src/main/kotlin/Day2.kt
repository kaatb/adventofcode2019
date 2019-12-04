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

    fun setupAndSolvePart2(intCodesAsString: String): Int {
        val intList = intCodesAsString.split(",").stream()
            .map { intcode -> intcode.toInt() }
            .collect(toList())
        for (noun in 0 .. 100){
            for (verb in 0 .. 100) {
                val newList = intList.toMutableList()
                newList.set(1, noun)
                newList.set(2, verb)
                if(solvePart1(newList as ArrayList<Int>).get(0) == 19690720){
                    return 100 * noun + verb
                }
            }
        }
        throw IllegalStateException()
    }

    tailrec fun solvePart1(memory: ArrayList<Int>, instructionPointer: Int = 0): ArrayList<Int> =
        when (memory.get(instructionPointer)) {
            1 -> {
                doInstruction(memory, instructionPointer) { a, b -> a + b }
                solvePart1(memory, instructionPointer + 4)
            }
            2 -> {
                doInstruction(memory, instructionPointer) { a, b -> a * b }
                solvePart1(memory, instructionPointer + 4)
            }
            99 -> memory
            else -> throw IllegalStateException();
        }

    fun doInstruction(memory: ArrayList<Int>, instructionPointer: Int, operation: (a: Int, b: Int) -> Int) =
        memory.set(
            memory.get(instructionPointer + 3),
            operation(memory.get(memory.get(instructionPointer + 1)), memory.get(memory.get(instructionPointer + 2)))
        );

}