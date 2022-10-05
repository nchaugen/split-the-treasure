class Split(shares: List<Gems> = emptyList()) {

    private val shares = shares.sortedBy(Gems::sum)

    fun isFair() =
        if (shares.isEmpty()) true
        else shares.first().sum() == shares.last().sum()

    fun add(gem: Int) = Split(shares.drop(1) + (shares.first() + gem))

    fun shareCount() = shares.count()

    override fun equals(other: Any?) = other is Split && shares.containsAll(other.shares)
    override fun hashCode() = shares.hashCode()
    override fun toString() = "Split$shares"

    companion object {
        fun of(vararg shares: Gems) = Split(shares.toList())
        fun by(count: Int) = Split((0 until count).map { i -> Gems() }.toList())
    }
}
