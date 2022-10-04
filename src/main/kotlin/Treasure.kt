class Treasure(private val gems: List<Int>) {

    companion object {
        fun of(vararg gems: Int): Treasure = Treasure(gems.toList())
    }

    fun split() = split(candidateCrewSizes(gems.sum(), gems.count())).map(List<Int>::toSet).toSet()

    fun split(possibleCrewSizes: List<Int>) =
        if (possibleCrewSizes.isEmpty()) emptyList()
        else possibleCrewSizes
            .map { crewSize -> share(gems.sorted(), crewSize) }
            .filter(::isEqualSplit)
            .firstOrNull() ?: emptyList()

    fun isEqualSplit(split: List<List<Int>>): Boolean {
        val bagValuesSorted = split.map(List<Int>::sum).sorted()
        return bagValuesSorted.first() == bagValuesSorted.last()
    }

    fun share(gems: List<Int>, hunters: Int): List<List<Int>> {
        if (gems.isEmpty()) return emptyBags(hunters)
        return giveToPoorest(gems.first(), share(gems.drop(1), hunters))
    }

    private fun giveToPoorest(gem: Int, bags: List<List<Int>>): List<List<Int>> {
        val poorestFirst = bags.sortedBy(List<Int>::sum)
        return poorestFirst.drop(1) + setOf(poorestFirst.first() + gem)
    }

    fun emptyBags(count: Int) = (0 until count).map { i -> emptyList<Int>() }.toList()

    private fun candidateCrewSizes(gemsSum: Int, crewSize: Int): List<Int> =
        if (crewSize < 2) emptyList()
        else if (crewSize.canShareEqually(gemsSum)) candidateCrewSizes(gemsSum, crewSize - 1) + crewSize
        else candidateCrewSizes(gemsSum, crewSize - 1)

    private fun Int.canShareEqually(gemsSum: Int) = gemsSum % this == 0

}
