package Tests.Elements.Tests;

import Elements.ProduktParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduktParserTest {
    private ProduktParser pp;

    @BeforeEach
    void setUp() {
        pp = new ProduktParser();
    }

    @AfterEach
    void tearDown() {
        pp = null;
    }

    @Test
    void pobierzWszystkie() {
        assertEquals("select * from `product`", pp.pobierzWszystkie());
    }

    @Test
    void pobierzJeden() {
        assertEquals("select * from `product` where id = ?", pp.pobierzJeden());
    }

    @Test
    void usun() {
        assertEquals("delete from `product` where id = ?", pp.Usun());
    }

    @Test
    void edytuj() {
        assertEquals("update `product` SET name = ?, unitOfMeasurement = ?, referenceValue = ?, kcal = ?, carbohydrates = ?, protein = ?, fat = ? where id = ?", pp.Edytuj());
    }

    @Test
    void PobierzProduktyZDania() {
        assertEquals("select p.*, di.amountOfProduct from dishingredients as di left join product as p on di.idProduct = p.id left join dish d on di.idDish = d.id where d.id = ?", pp.PobierzProduktyZDania());
    }

    @Test
    void UsunPowiazane() {
        assertEquals("delete from `dishingredients` where idProduct = ?", pp.UsunPowiazane());
    }
}

