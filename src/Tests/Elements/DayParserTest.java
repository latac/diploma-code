package Tests.Elements.Tests;

import Elements.DayParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayParserTest {
    private DayParser dp;

    @BeforeEach
    void setUp() {
        dp = new DayParser();
    }
    @AfterEach
    void tearDown() {
        dp = null;
    }


    @Test
    void zapytaniePobierzJedno(){
        assertEquals("select idMeal, m.name from `dayingredients` left join `meal` m on m.id = idMeal where idDay = ? ",dp.pobierzJeden());
    }

    @Test
    void zapytanieUsun(){
        assertEquals("delete from `day` where id = ?",dp.Usun());
    }


    @Test
    void zapytanieEdytuj(){
        assertEquals("update `day` SET VALUES name = ? where id = ?",dp.Edytuj());
    }

    @Test
    void zapytanieDodajPosilekDoDnia(){
        assertEquals("insert into `dayingredients` VALUES (?, ?)", dp.dodajPosilekDoDnia());
    }


    @Test
    void zapytanieUsunPosilekZDnia() {
        assertEquals("delete from `dayingredients` where idMeal = ? and idDay = ?", dp.usunPosilekZDnia());
    }

    @Test
    void zapytanieDodajSwieto() {
        assertEquals("insert into `dayholiday` VALUES (?)",dp.DodajSwieto());
    }

    @Test
    void zapytanieUsunSwieto() {
        assertEquals("delete from `dayholiday` where holiday = ?", dp.UsunSwieto());
    }

    @Test
    void zapytanieIleSwiat() {
        assertEquals("select COUNT(*) from `dayholiday` where holiday between ? and ?", dp.IleSwiat());
    }

    @Test
    void zapytanieCzyJestemSwietem() {
        assertEquals("select COUNT(*) from `dayholiday` where holiday = ?", dp.CzyJestemSwietem());
    }
}