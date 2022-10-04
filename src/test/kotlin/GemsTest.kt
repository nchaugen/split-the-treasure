import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GemsTest {

    @Test
    fun `should count gems`() {
        assertThat(Gems().count()).isEqualTo(0)
        assertThat(Gems(1).count()).isEqualTo(1)
        assertThat(Gems(1, 2, 3).count()).isEqualTo(3)
    }

    @Test
    fun `should sum gems`() {
        assertThat(Gems().sum()).isEqualTo(0)
        assertThat(Gems(1).sum()).isEqualTo(1)
        assertThat(Gems(1, 2, 3).sum()).isEqualTo(6)
    }

    @Test
    fun `should add gems`() {
        assertThat(Gems() + 1).isEqualTo(Gems(1))
        assertThat(Gems(1) + 2).isEqualTo(Gems(1, 2))
        assertThat(Gems(1, 2, 3) + 4).isEqualTo(Gems(1, 2, 3, 4))

        assertThat(Gems() + Gems()).isEqualTo(Gems())
        assertThat(Gems() + Gems(1)).isEqualTo(Gems(1))
        assertThat(Gems(1, 2) + Gems(3)).isEqualTo(Gems(1, 2, 3))
    }

    @Test
    fun `should split gems`() {
        assertThat(Gems().splitAmong(0)).isEqualTo(Split())
        assertThat(Gems().splitAmong(1)).isEqualTo(Split())
        assertThat(Gems().splitAmong(2)).isEqualTo(Split())

        assertThat(Gems(1).splitAmong(0)).isEqualTo(Split())
        assertThat(Gems(1).splitAmong(1)).isEqualTo(Split())
        assertThat(Gems(1).splitAmong(2)).isEqualTo(Split())

        assertThat(Gems(1, 1).splitAmong(0)).isEqualTo(Split())
        assertThat(Gems(1, 1).splitAmong(1)).isEqualTo(Split())
        assertThat(Gems(1, 1).splitAmong(2)).isEqualTo(Split.of(Gems(1), Gems(1)))
        assertThat(Gems(1, 1).splitAmong(3)).isEqualTo(Split())

        assertThat(Gems(1, 2, 3).splitAmong(2)).isEqualTo(Split.of(Gems(1, 2), Gems(3)))
        assertThat(Gems(1, 2, 3, 4).splitAmong(2)).isEqualTo(Split.of(Gems(3, 2), Gems(4, 1)))
        assertThat(Gems(1, 2, 3, 4, 5).splitAmong(2)).isEqualTo(Split.of(Gems(5, 2), Gems(4, 3, 1)))

        assertThat(Gems(27, 7, 20).splitAmong(2)).isEqualTo(Split.of(Gems(27), Gems(20, 7)))
    }
}
