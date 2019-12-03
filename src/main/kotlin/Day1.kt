class Day1 {

    fun solvePart1(moduleMasses: List<String>): Int {
        return moduleMasses.map { module -> module.toInt() }.sumBy { module -> calculateFuelBasedOnMass(module) }
    }

    fun solvePart2(moduleMasses: List<String>): Int {
        return moduleMasses
            .map { module -> module.toInt() }
            .sumBy { module -> calculateRemainingMassUntilZero(calculateFuelBasedOnMass(module)) }
    }

    private fun calculateFuelBasedOnMass(moduleMass: Int) = Math.floorDiv(moduleMass, 3) - 2

    private fun calculateRemainingMassUntilZero(fuelMass: Int): Int {
        print(fuelMass)
        println(" --> " + calculateFuelBasedOnMass(fuelMass));

        if (calculateFuelBasedOnMass(fuelMass) <= 0)
            return fuelMass;
        else
            return fuelMass + calculateRemainingMassUntilZero(calculateFuelBasedOnMass(fuelMass));
    }
}

