package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBun {
    Bun bun = new Bun("Bun", 100F);

    @Test
    public void returnName() {
        assertEquals(bun.getName(), "Bun");
    }

    @Test
    public void returnPrice() {
        assertEquals(bun.getPrice(), 100, 0);
    }
}
