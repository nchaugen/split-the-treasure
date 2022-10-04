import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SplitTest {

    @Test
    fun `should decide if split is fair`() {
        assertThat(Split.of(Gems(), Gems()).isFair()).isTrue()
        assertThat(Split.of(Gems(), Gems(1)).isFair()).isFalse()
        assertThat(Split.of(Gems(2), Gems(1, 1)).isFair()).isTrue()
        assertThat(Split.of(Gems(1), Gems(1, 2)).isFair()).isFalse()
    }

    @Test
    fun `should add gems to least valuable share`() {
        assertThat(Split.of(Gems(), Gems()).add(1)).isEqualTo(Split.of(Gems(1), Gems()))
        assertThat(Split.of(Gems(1), Gems()).add(2)).isEqualTo(Split.of(Gems(1), Gems(2)))
        assertThat(Split.of(Gems(2), Gems(1)).add(3)).isEqualTo(Split.of(Gems(2), Gems(1, 3)))

        assertThat(Split.of(Gems(), Gems()).add(3)).isEqualTo(Split.of(Gems(3), Gems()))
        assertThat(Split.of(Gems(3), Gems()).add(2)).isEqualTo(Split.of(Gems(3), Gems(2)))
        assertThat(Split.of(Gems(3), Gems(2)).add(1)).isEqualTo(Split.of(Gems(3), Gems(2, 1)))
    }
}
