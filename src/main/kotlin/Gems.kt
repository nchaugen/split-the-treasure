class Gems(private val gems: List<Int> = emptyList()) {
    constructor(vararg gems: Int) : this(gems.toList())

    fun count() = gems.count()
    fun sum() = gems.sum()

    fun splitAmong(count: Int) = if (count < 2) Split() else Split(share(gems.sorted(), count))

    private fun share(sortedGems: List<Int>, count: Int): List<Gems> =
        if (sortedGems.isEmpty()) shareNothing(count)
        else giveToPoorest(sortedGems.first(), share(sortedGems.drop(1), count))

    private fun shareNothing(count: Int) = (0 until count).map { i -> Gems() }.toList()

    private fun giveToPoorest(gem: Int, shares: List<Gems>): List<Gems> {
        val poorestFirst = shares.sortedBy(Gems::sum)
        return poorestFirst.drop(1) + (poorestFirst.first() + gem)
    }

    operator fun plus(gem: Int) = Gems(gems + gem)
    operator fun plus(other: Gems) = Gems(gems + other.gems)
    override fun equals(other: Any?) = other is Gems && gems.containsAll(other.gems)
    override fun hashCode() = gems.hashCode()
    override fun toString() = "Gems$gems"
}
