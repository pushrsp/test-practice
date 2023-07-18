package sample.firsttest.unit.beverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AmericanoTest {
    @Test
    public void getName() throws Exception {
        Americano americano = new Americano();
        assertThat(americano.getName()).isEqualTo("아메리카노");
    }

    @Test
    public void getPrice() throws Exception {
        Americano americano = new Americano();
        assertThat(americano.getPrice()).isEqualTo(4000);
    }
}
