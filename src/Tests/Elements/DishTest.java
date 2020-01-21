package Tests.Elements;

import Elements.Dish;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishTest {

    Dish d;

    @BeforeEach
    void setUp() {

        d = new Dish();
    }

    @AfterEach
    void tearDown() {

        d = null;
    }

    @Test
    void setName() {
        String mojaNazwa = "test";
        d.setName(mojaNazwa);
        assertEquals(mojaNazwa, d.getName());
    }

    @Test
    void setId() {
        int mojeId = 111;
        d.setId(mojeId);
        assertEquals(mojeId,d.getId());
    }

    @Test
    void getName() {
        assertNull(d.getName());
    }

    @Test
    void getId() {
        assertNull(d.getName());
    }
}