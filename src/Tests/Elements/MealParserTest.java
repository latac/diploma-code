package Tests.Elements.Tests;

import Elements.MealParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealParserTest {
    private MealParser mp;

    @BeforeEach
    void setUp() {
        mp = new MealParser();
    }
    @AfterEach
    void tearDown() {
        mp = null;
    }
@Test
    void pobierzWszystkie(){
        assertEquals("select * from `meal`", mp.pobierzWszystkie());
}
@Test
    void pobierzJeden(){
        assertEquals("select * from `meal` where id = ?", mp.pobierzJeden());
}
@Test
    void usun(){
        assertEquals("delete from `meal` where id = ?", mp.usun());
}

@Test
    void edytuj(){
        assertEquals("update `meal` SET name = ? where id = ?", mp.edytuj());
}
@Test
    void UsunPowiazane(){
        assertEquals("delete from `mealingredients` where idMeal = ?",mp.UsunPowiazane());
}
@Test
    void dodajDanieDoPosilku(){
        assertEquals("insert into `mealingredients` VALUES (?, ?)", mp.dodajDanieDoPosilku());
}
@Test
    void usunDanieZPosilku(){
        assertEquals("delete from `mealingredients` where idMeal = ? and idDish = ?", mp.usunDanieZPosilku());
}
}
