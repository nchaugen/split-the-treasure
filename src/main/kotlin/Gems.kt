class Gems(gems: List<Int> = emptyList()) {
    constructor(vararg gems: Int) : this(gems.toList())

    private val gems = gems.sorted()

    fun count() = gems.count()
    fun sum() = gems.sum()

    fun splitAmong(count: Int) = if (count < 2) Split() else split(gems, count)

    private fun split(gems: List<Int>, count: Int): Split =
        if (gems.isEmpty()) emptySplit(count)
        else split(gems.drop(1), count).add(gems.first())

    private fun emptySplit(count: Int) = Split.by(count)

    operator fun plus(gem: Int) = Gems(gems + gem)
    operator fun plus(other: Gems) = Gems(gems + other.gems)
    override fun equals(other: Any?) = other is Gems && gems.containsAll(other.gems)
    override fun hashCode() = gems.hashCode()
    override fun toString() = "Gems$gems"
}
