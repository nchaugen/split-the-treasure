import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TreasureTest {

    @Test
    fun `empty treasure has no split`() {
        assertThat(Treasure.of().splitFairly()).isEmpty()
    }

    @Test
    fun `treasure of one gem has no split`() {
        assertThat(Treasure.of(1).splitFairly()).isEmpty()
    }

    @Test
    fun `treasure of two equally valuable gems can be split in two`() {
        assertThat(
            Treasure.of(2, 2).splitFairly()
        ).containsExactly(
            Split.of(Gems(2), Gems(2))
        )
    }

    @Test
    fun `treasure of four equally valuable gems can be split in two or four`() {
        assertThat(
            Treasure.of(2, 2, 2, 2).splitFairly()
        ).containsExactly(
            Split.of(Gems(2, 2), Gems(2, 2)),
            Split.of(Gems(2), Gems(2), Gems(2), Gems(2))
        )
    }

    @Test
    fun `assignment example 1`() {
        assertThat(Treasure.of(4, 4, 4).splitFairly()).containsExactly(Split.of(Gems(4), Gems(4), Gems(4)))
    }

    @Test
    fun `assignment example 2`() {
        assertThat(Treasure.of(27, 7, 20).splitFairly()).containsExactly(Split.of(Gems(27), Gems(7, 20)))
        assertThat(Treasure.of(20, 27, 7).splitFairly()).containsExactly(Split.of(Gems(27), Gems(7, 20)))
        assertThat(Treasure.of(7, 27, 20).splitFairly()).containsExactly(Split.of(Gems(27), Gems(7, 20)))
    }

    @Test
    fun `assignment example 3`() {
        val treasure = Treasure.of(6, 3, 2, 4, 1)

        assertThat(treasure.canBeSplitFairlyBy(2)).isTrue()
        assertThat(treasure.canBeSplitFairlyBy(3)).isFalse()
        assertThat(treasure.canBeSplitFairlyBy(4)).isFalse()

        assertThat(treasure.splitFairly()).containsExactly(Split.of(Gems(6, 2), Gems(3, 4, 1)))
    }

    @Test
    fun `assignment example 4`() {
        val treasure = Treasure.of(3, 2, 7, 7, 14, 5, 3, 4, 9, 2)

        assertThat(treasure.canBeSplitFairlyBy(4)).isTrue()
        assertThat(treasure.splitFairly()).containsExactly(Split.of(Gems(14), Gems(7, 4, 3), Gems(7, 5, 2), Gems(9, 3, 2)))
    }

    @Test
    fun `assignment example 5`() {
        assertThat(Treasure.of(3,3,3,3,2,2,2,2,2,2,2,2).splitFairly()).containsExactly(
            Split.of(Gems(3, 2, 2), Gems(3, 2, 2), Gems(3, 2, 2), Gems(3, 2, 2)),
            Split.of(Gems(3, 3, 2, 2, 2, 2), Gems(3, 3, 2, 2, 2, 2))
        )
    }


}
