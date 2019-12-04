object Day3 {


    fun solvePart1(wire1: String, wire2: String): Int? {
        val wireLocation1 = followWire(wire1);
        val wireLocation2 = followWire(wire2);

        val intersect: Set<Pair<Int, Int>> = wireLocation1.intersect(wireLocation2);
        return intersect.filterNot { pair -> pair == 0 to 0 }
            .map {
                Math.abs(0 - it.first) + Math.abs(0 - it.second)
            }.min()
    }

    private fun followWire(wire: String): ArrayList<Pair<Int, Int>> {
        val wireLocation: ArrayList<Pair<Int, Int>> = ArrayList();
        wireLocation.add(0 to 0);

        wire.split(",")
            .forEach {
                if (it.startsWith("U")) goUp(wireLocation, it.removeRange(0, 1).toInt());
                if (it.startsWith("D")) goDown(wireLocation, it.removeRange(0, 1).toInt());
                if (it.startsWith("L")) goLeft(wireLocation, it.removeRange(0, 1).toInt());
                if (it.startsWith("R")) goRight(wireLocation, it.removeRange(0, 1).toInt());
            }
        return wireLocation
    }

    private fun goUp(wireLocation: ArrayList<Pair<Int, Int>>, numberOfSteps: Int) {
        repeat(numberOfSteps) {
            val getPreviousLocation = wireLocation.get(wireLocation.lastIndex)
            wireLocation.add(getPreviousLocation.first to wireLocation.get(wireLocation.lastIndex).second + 1)
        }
    }

    private fun goLeft(wireLocation: ArrayList<Pair<Int, Int>>, numberOfSteps: Int) {
        repeat(numberOfSteps) {
            val getPreviousLocation = wireLocation.get(wireLocation.lastIndex)
            wireLocation.add(getPreviousLocation.first - 1 to wireLocation.get(wireLocation.lastIndex).second)
        }
    }

    private fun goDown(wireLocation: ArrayList<Pair<Int, Int>>, numberOfSteps: Int) {
        repeat(numberOfSteps) {
            val getPreviousLocation = wireLocation.get(wireLocation.lastIndex)
            wireLocation.add(getPreviousLocation.first to wireLocation.get(wireLocation.lastIndex).second - 1)
        }
    }

    private fun goRight(wireLocation: ArrayList<Pair<Int, Int>>, numberOfSteps: Int) {
        repeat(numberOfSteps) {
            val getPreviousLocation = wireLocation.get(wireLocation.lastIndex)
            wireLocation.add(getPreviousLocation.first + 1 to wireLocation.get(wireLocation.lastIndex).second)
        }
    }

}