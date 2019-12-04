import filereader.FileReader

fun main(args: Array<String>) {

    println("Day1 part1: ${Day1().solvePart1(FileReader().readLines("day1.txt"))}");
    println("Day1 part2: ${Day1().solvePart2(FileReader().readLines("day1.txt"))}");

    println("Day2 part1: ${Day2().setupAndSolvePart1(FileReader().readLines("day2.txt").get(0))}");
    println("Day2 part2: ${Day2().setupAndSolvePart2(FileReader().readLines("day2.txt").get(0))}");

    val linesDay3 = FileReader().readLines("day3.txt")
    println("Day3 part1: ${Day3.solvePart1(linesDay3.get(0), linesDay3.get(1))}");

}