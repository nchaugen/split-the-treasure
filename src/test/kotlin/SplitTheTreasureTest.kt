import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SplitTheTreasureTest {

    @Test
    fun `empty treasure can not be split`() {
        assertThat(Treasure.of().split()).isEmpty()
    }

    @Test
    fun `treasure of one gem can not be split`() {
        assertThat(Treasure.of(1).split()).isEmpty()
    }

    @Test
    fun `treasure of two equally valuable gems can be split in two`() {
        assertThat(Treasure.of(2, 2).split()).contains(bag(2), bag(2))
    }

    @Test
    fun `assignment examples`() {
        assertThat(Treasure.of(4, 4, 4).split()).contains(bag(4), bag(4), bag(4))
        assertThat(Treasure.of(27, 7, 20).split()).contains(bag(27), bag(7, 20))
        assertThat(Treasure.of(6, 3, 2, 4, 1).split()).contains(bag(6, 2), bag(3, 4, 1))
        assertThat(Treasure.of(3,2,7,7,14,5,3,4,9,2).split()).contains(bag(14), bag(7, 4, 3), bag(7, 5, 2), bag(9, 3, 2))
        assertThat(Treasure.of(3,3,3,3,2,2,2,2,2,2,2,2).split()).contains(bag(3, 2, 2), bag(3, 2, 2), bag(3, 2, 2), bag(3, 2, 2))
    }

    private fun bag(vararg gems: Int) = gems.toSet()


}
