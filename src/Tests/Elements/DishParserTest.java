package Tests.Elements.Tests;

import Elements.DishParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishParserTest {
    private DishParser dp;

    @BeforeEach
    void setUp() {
        dp = new DishParser();
    }
    @AfterEach
    void tearDown() {
        dp = null;
    }

    @Test
    void pobierzWszystkie(){
    assertEquals("select * from `dish`", dp.pobierzWszystkie());
    }
    @Test
    void pobierzJeden(){
        assertEquals("select * from `dish` where id = ?", dp.pobierzJeden());
    }
    @Test
    void dodajProduktDoDania(){
    assertEquals("insert into `dishingredients` VALUES (?, ?, ?)", dp.dodajProduktDoDania());
    }
    @Test
    void usunProduktZDania(){
        assertEquals("delete from `dishingredients` where idDish = ? and idProduct = ?", dp.usunProduktZDania());
    }
    @Test
    void UsunPowiazane(){
        assertEquals("delete from `dishingredients` where idDish = ?", dp.UsunPowiazane());
    }
    @Test
    void Usun(){
        assertEquals("delete from `dish` where id = ?", dp.Usun());
    }
    @Test
    void Edytuj(){
    assertEquals("update `dish` SET name = ? where id = ?", dp.Edytuj());
    }
    @Test
    void PobierzDaniaZPosilku(){
        assertEquals("select d.* from mealingredients as mi left join dish as d on mi.idDish = d.id left join meal m on mi.idMeal = m.id where m.id = ?", dp.PobierzDaniaZPosilku());
    }
}
