package Tests.Elements;

import Elements.Meal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {
    Meal m;

    @BeforeEach
    void setUp() {

        m = new Meal();
    }

    @AfterEach
    void tearDown() {

        m = null;
    }

    @Test
    void setName() {
        String mojaNazwa = "test";
        m.setName(mojaNazwa);
        assertEquals(mojaNazwa, m.getName());
    }

    @Test
    void setId() {
        int mojeId = 111;
        m.setId(mojeId);
        assertEquals(mojeId, m.getId());
    }

    @Test
    void getName() {
        assertNull(m.getName());
    }

    @Test
    void getId() {
        assertNotNull(m.getId());

    }
}