package Tests.Elements;

import Elements.Norma;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormaTest {
    Norma n;
    float poprawneKcal, poprawneFat, poprawneProtein, poprawneCarbohydrtes;
    float niepoprawneKcalOdGory, niepoprawneKcalOdDolu, niepoprawneFatOdGory, niepoprawneFatOdDolu, niepoprawneProteinOdGory,
            niepoprawneProteinOdDolu, niepoprawneCarbohydrtesOdGory, niepoprawneCarbohydrtesOdDolu;
    float dolnaGranicaKcal, gornaGranicaKcal, dolnaGranicaFat, gornaGranicaFat,
            dolnaGranicaProtein, gornaGranicaProtein, dolnaGranicaCarbohydrtes, gornaGranicaCarbohydrtes;

    @BeforeEach
    void setUp() {
        n = new Norma();
        poprawneKcal = 950.0f;
        poprawneFat = 33.67f;
        poprawneProtein = 36.75f;
        poprawneCarbohydrtes = 133.75f;

        niepoprawneKcalOdDolu = 0;
        niepoprawneKcalOdGory = 4000;
        niepoprawneFatOdDolu = 0;
        niepoprawneFatOdGory = 4000;
        niepoprawneCarbohydrtesOdDolu = 0;
        niepoprawneCarbohydrtesOdGory = 4000;
        niepoprawneProteinOdDolu = 0;
        niepoprawneProteinOdGory = 4000;

        dolnaGranicaKcal = 931;
        gornaGranicaKcal = 1029;
        dolnaGranicaProtein = 34.9125f;
        gornaGranicaProtein = 38.5875f;
        dolnaGranicaCarbohydrtes = 128.0125f;
        gornaGranicaCarbohydrtes = 141.4875f;
        dolnaGranicaFat = 31.036499f; // TODO: opisz w pracy precyzja
        gornaGranicaFat = 34.3035f;

    }

    @AfterEach
    void tearDown() {

        n = null;

    }

    @Test
    void czyKcalWPrzedziale() {
        boolean result = n.czyKcalWPrzedziale(poprawneKcal);
        assertTrue(result);

    }

    @Test
    void czyProteinWPrzedziale() {
        boolean result = n.czyProteinWPrzedziale(poprawneProtein);
        assertTrue(result);
    }

    @Test
    void czyCarbohydratesWPrzedziale() {

        boolean result = n.czyCarbohydratesWPrzedziale(poprawneCarbohydrtes);
        assertTrue(result);
    }

    @Test
    void czyFatWPrzedziale() {

        boolean result = n.czyFatWPrzedziale(poprawneFat);
        assertTrue(result);
    }

    @Test
    void gornaGranicaKcalWPrzedziale() {

        boolean result = n.czyKcalWPrzedziale(gornaGranicaKcal);
        assertFalse(result);

    }

    @Test
    void dolnaGranicaKcalWPrzedziale() {

        boolean result = n.czyKcalWPrzedziale(dolnaGranicaKcal);
        assertFalse(result);
    }

    @Test
    void gornaGranicaCarbohydratesWPrzedziale() {

        boolean result = n.czyCarbohydratesWPrzedziale(gornaGranicaCarbohydrtes);
        assertFalse(result);
    }

    @Test
    void dolnaGranicaCarbohydratesWPrzedziale() {
        boolean result = n.czyCarbohydratesWPrzedziale(dolnaGranicaCarbohydrtes);
        assertFalse(result);
    }

    @Test
    void gornaGranicaProteinWPrzedziale() {

        boolean result = n.czyProteinWPrzedziale(gornaGranicaProtein);
        assertFalse(result);
    }

    @Test
    void dolnaGranicaProteinWPrzedziale() {
        boolean result = n.czyProteinWPrzedziale(dolnaGranicaProtein);
        assertFalse(result);
    }

    @Test
    void gornaGranicaFatWPrzedziale() {

        boolean result = n.czyFatWPrzedziale(gornaGranicaFat);
        assertFalse(result);
    }

    @Test
    void dolnaGranicaFatWPrzedziale() {

        boolean result = n.czyFatWPrzedziale(dolnaGranicaFat);
        assertFalse(result);
    }

    @Test
    void zleDolKcal() {

        boolean result = n.czyKcalWPrzedziale(niepoprawneKcalOdDolu);
        assertFalse(result);
    }

    @Test
    void zleGoraKcal() {
        boolean result = n.czyKcalWPrzedziale(niepoprawneKcalOdGory);
        assertFalse(result);
    }

    @Test
    void zleDolCarbohydrates() {
        boolean result = n.czyCarbohydratesWPrzedziale(niepoprawneCarbohydrtesOdDolu);
        assertFalse(result);
    }

    @Test
    void zleGoraCarbohydrates() {

        boolean result = n.czyCarbohydratesWPrzedziale(niepoprawneCarbohydrtesOdGory);
        assertFalse(result);
    }

    @Test
    void zleDolProtein() {

        boolean result = n.czyProteinWPrzedziale(niepoprawneProteinOdDolu);
        assertFalse(result);
    }

    @Test
    void zleGoraProtein() {

        boolean result = n.czyProteinWPrzedziale(niepoprawneProteinOdGory);
        assertFalse(result);
    }

    @Test
    void zleDolFat() {

        boolean result = n.czyFatWPrzedziale(niepoprawneFatOdDolu);
        assertFalse(result);
    }

    @Test
    void zleGoraFat() {

        boolean result = n.czyFatWPrzedziale(niepoprawneFatOdGory);
        assertFalse(result);
    }
}