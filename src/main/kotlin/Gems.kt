class Gems(private val gems: List<Int> = emptyList()) {
    constructor(vararg gems: Int) : this(gems.toList())

    fun count() = gems.count()
    fun sum() = gems.sum()

    fun splitAmong(count: Int) = if (count < 2) Split() else split(gems.sorted(), count)

    private fun split(sortedGems: List<Int>, count: Int): Split =
        if (sortedGems.isEmpty()) emptySplit(count)
        else split(sortedGems.drop(1), count).add(sortedGems.first())

    private fun emptySplit(count: Int) = Split.by(count)

    operator fun plus(gem: Int) = Gems(gems + gem)
    operator fun plus(other: Gems) = Gems(gems + other.gems)
    override fun equals(other: Any?) = other is Gems && gems.containsAll(other.gems)
    override fun hashCode() = gems.hashCode()
    override fun toString() = "Gems$gems"
}
