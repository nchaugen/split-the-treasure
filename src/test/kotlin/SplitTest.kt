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
}
