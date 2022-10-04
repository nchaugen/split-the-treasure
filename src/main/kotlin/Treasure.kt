class Treasure(private val gems: Gems) {

    companion object {
        fun of(vararg gems: Int): Treasure = Treasure(Gems(gems.toList()))
    }

    fun splitFairly() = splitFairly(candidateCounts(gems.sum(), gems.count()))

    fun canBeSplitFairlyBy(count: Int) = splitFairly()
            .find { split -> split.shareCount() == count }
            .let { true }

    private fun splitFairly(candidateCounts: List<Int>) =
        if (candidateCounts.isEmpty()) emptySet()
        else candidateCounts
            .map(gems::splitAmong)
            .filter(Split::isFair)
            .toSet()

    private fun candidateCounts(gemsSum: Int, count: Int): List<Int> =
        if (count < 2) emptyList()
        else if (count.canShareFairly(gemsSum)) candidateCounts(gemsSum, count - 1) + count
        else candidateCounts(gemsSum, count - 1)

    private fun Int.canShareFairly(gemsSum: Int) = gemsSum % this == 0

}
