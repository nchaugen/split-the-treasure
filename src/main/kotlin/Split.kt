class Split(private val shares: List<Gems> = emptyList()) {

    fun isFair(): Boolean {
        if (shares.isEmpty()) return true
        val shareValuesSorted = shares.map(Gems::sum).sorted()
        return shareValuesSorted.first() == shareValuesSorted.last()
    }

    override fun equals(other: Any?) = other is Split && shares.containsAll(other.shares)
    override fun hashCode() = shares.hashCode()
    override fun toString() = "Split$shares"
    fun shareCount() = shares.count()

    companion object {
        fun of(vararg shares: Gems) = Split(shares.toList())
    }
}
