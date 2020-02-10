package Tests.Elements;

import Elements.Day;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {
    Day d;

    @BeforeEach
    void setUp() {

        d = new Day();
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
        assertEquals(mojeId, d.getId());
    }

    @Test
    void getName() {
        assertNull(d.getName());
    }


}