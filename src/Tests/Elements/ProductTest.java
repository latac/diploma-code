package Tests.Elements;

import Elements.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p;

    @BeforeEach
    void setUp() {

        p = new Product();
    }

    @AfterEach
    void tearDown() {

        p = null;
    }


    @Test
    void setName() {
        String mojaNazwa = "test";
        p.setName(mojaNazwa);
        assertEquals(mojaNazwa, p.getName());
    }

    @Test
    void setUnitOfMeasurement() {

        String mojaJednostka = "g";
        p.setUnitOfMeasurement(mojaJednostka);
        assertEquals(mojaJednostka, p.getUnitOfMeasurement());
    }

    @Test
    void setReferenceValue() {

        int mojaWartoscOdniesienia = 111;
        p.setReferenceValue(mojaWartoscOdniesienia);
        assertEquals(mojaWartoscOdniesienia, p.getReferenceValue());
    }

    @Test
    void setKcal() {
        float mojeKcal = 12.2f;
        p.setKcal(mojeKcal);
        assertEquals(mojeKcal, p.getKcal());
    }

    @Test
    void setCarbohydrates() {
        float mojeWeglowodany = 52.32f;
        p.setCarbohydrates(mojeWeglowodany);
        assertEquals(mojeWeglowodany, p.getCarbohydrates());
    }

    @Test
    void setProtein() {
        float mojeBialka = 752.787f;
        p.setProtein(mojeBialka);
        assertEquals(mojeBialka, p.getProtein());
    }

    @Test
    void setFat() {
        float mojeTluszcze = 98.4f;
        p.setFat(mojeTluszcze);
        assertEquals(mojeTluszcze, p.getFat());
    }

    @Test
    void setId() {

        int mojeId = 111;
        p.setId(mojeId);
        assertEquals(mojeId, p.getId());
    }

    @Test
    void setAmountOfProduct() {
        float mojaIlosc = 356.51f;
        p.setAmountOfProduct(mojaIlosc);
        assertEquals(mojaIlosc, p.getAmountOfProduct());
    }

    @Test
    void getName() {
        assertNull(p.getName());
    }

    @Test
    void getUnitOfMeasurement() {
        assertNull(p.getUnitOfMeasurement());
    }

    @Test
    void getReferenceValue() {
        assertNotNull(p.getReferenceValue());
    }

    @Test
    void getKcal() {
        assertNotNull(p.getKcal());
    }

    @Test
    void getCarbohydrates() {
        assertNotNull(p.getCarbohydrates());
    }

    @Test
    void getProtein() {
        assertNotNull(p.getProtein());
    }

    @Test
    void getFat() {
        assertNotNull(p.getFat());
    }

    @Test
    void getId() {
        assertNotNull(p.getId());
    }

    @Test
    void getAmountOfProduct() {
        assertNotNull(p.getAmountOfProduct());
    }


    @Test
    void testToStringAmount0() {
        String nazwa = "NazwaProduktu";
        p.setName(nazwa);
        p.setAmountOfProduct(0);
        assertEquals(nazwa, p.toString());
    }

    @Test
    void testToStringAmountNot0() {
        String nazwa = "NazwaProduktu";
        p.setName(nazwa);
        p.setAmountOfProduct(1);
        p.setUnitOfMeasurement("gram");
        assertEquals(nazwa + " (1.0 gram)", p.toString());
    }
}