package Tests.View;

import Elements.Dish;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ViewMenageDish;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ViewMenageDishTest {

    private Dish danie;
    private AncestorListener listener;
    private ViewMenageDish vmd;

    @BeforeEach
    void setUp() {
        danie = new Dish();
        listener = new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        };
        vmd = new ViewMenageDish();
    }

    @AfterEach
    void tearDown() {
        danie = null;
        listener = null;
        vmd = null;
    }


    @Test
    void constructorDefaultPanel() {
        assertNotNull(vmd.getPanel());
    }

    @Test
    void defaultNazwtDania() {

        assertNotNull(vmd.getNazwaDania());
    }

    @Test
    void sprawdzaniePolozeniaNazwyDania() {
        JLabel nazwaDania = new JLabel();
        nazwaDania.setBounds(0, 10, 200, 25);
        assertEquals(vmd.getNazwaDania().getBounds(), nazwaDania.getBounds());
    }

    @Test
    void kcal() {
        assertNotNull(vmd.getKcal());
    }

    @Test
    void nazwaKcal() {
        assertEquals("kcal", vmd.getKcal().getText());
    }

    @Test
    void polozenieKcal() {
        JLabel kcal = new JLabel();
        kcal.setBounds(0, 40, 200, 25);
        assertEquals(vmd.getKcal().getBounds(), kcal.getBounds());
    }

    @Test
    void iloscKcal() {
        assertNotEquals("0,000", vmd.getWyliczoneKcal().getText());
    }
    @Test
    void polozenieIlosciKcal() {
        JLabel wyliczoneKcal = new JLabel();
        wyliczoneKcal.setBounds(200, 40, 200, 25);
        assertEquals(vmd.getWyliczoneKcal().getBounds(), wyliczoneKcal.getBounds());
    }

    @Test
    void weglowodany() {
        assertNotNull(vmd.getWeglowodany());
    }

    @Test
    void nazwaWeglowodany() {
        assertEquals("węglowodany", vmd.getWeglowodany().getText());
    }

    @Test
    void polozenieWeglowodany() {
        JLabel weglowodany = new JLabel();
        weglowodany.setBounds(0, 70, 200, 25);
        assertEquals(vmd.getWeglowodany().getBounds(), weglowodany.getBounds());
    }

    @Test
    void iloscWeglowodanow() {
        assertNotEquals("0,000", vmd.getWyliczoneWeglowodany().getText());
    }

    @Test
    void polozenieIlosciWeglowodanow() {
        JLabel wyliczoneweglowodany = new JLabel();
        wyliczoneweglowodany.setBounds(200, 70, 200, 25);
        assertEquals(vmd.getWyliczoneWeglowodany().getBounds(), wyliczoneweglowodany.getBounds());
    }

    @Test
    void bialka() {
        assertNotNull(vmd.getBialka());
    }

    @Test
    void nazwaBialka() {
        assertEquals("białka", vmd.getBialka().getText());
    }

    @Test
    void polozenieBialka() {
        JLabel bialka = new JLabel();
        bialka.setBounds(0, 100, 200, 25);
        assertEquals(vmd.getBialka().getBounds(), bialka.getBounds());
    }

    @Test
    void iloscBialek() {
        assertNotEquals("0,000", vmd.getWyliczoneBialka().getText());
    }

    @Test
    void polozenieIlosciBialek() {
        JLabel wyliczoneBialka = new JLabel();
        wyliczoneBialka.setBounds(200, 100, 200, 25);
        assertEquals(vmd.getWyliczoneBialka().getBounds(), wyliczoneBialka.getBounds());
    }

    @Test
    void tluszcz() {
        assertNotNull(vmd.getTluszcze());
    }

    @Test
    void nazwaTluszcz() {
        assertEquals("tłuszcze", vmd.getTluszcze().getText());
    }

    @Test
    void polozenieTluszczy() {
        JLabel tluszcz = new JLabel();
        tluszcz.setBounds(0, 130, 200, 25);
        assertEquals(vmd.getTluszcze().getBounds(), tluszcz.getBounds());
    }

    @Test
    void iloscTluszczy() {
        assertNotEquals("0,000", vmd.getWyliczoneTluszcze().getText());
    }

    @Test
    void polozenieIlosciTluszczy() {
        JLabel wyliczoneTluszczu = new JLabel();
        wyliczoneTluszczu.setBounds(200, 130, 200, 25);
        assertEquals(vmd.getWyliczoneTluszcze().getBounds(), wyliczoneTluszczu.getBounds());
    }

    @Test
    void dodaj() {
        assertNotNull(vmd.getDodaj());
    }

    @Test
    void nazwaDodaj() {
        assertEquals("dodaj", vmd.getDodaj().getText());
    }

    @Test
    void polozenieDodaj() {
        JLabel dodaj = new JLabel();
        dodaj.setBounds(100, 200, 100, 25);
        assertEquals(vmd.getDodaj().getBounds(), dodaj.getBounds());
    }

    @Test
    void wroc() {
        assertNotNull(vmd.getWroc());
    }

    @Test
    void nazwaWroc() {
        assertEquals("wróć", vmd.getWroc().getText());
    }

    @Test
    void polozenieWroc() {
        JLabel wroc = new JLabel();
        wroc.setBounds(400, 200, 100, 25);
        assertEquals(vmd.getWroc().getBounds(), wroc.getBounds());
    }
    @Test
    void usun() {
        assertNotNull(vmd.getUsun());
    }

    @Test
    void nazwaUsun() {
        assertEquals("usuń", vmd.getUsun().getText());
    }

    @Test
    void polozenieUsun() {
        JLabel usun = new JLabel();
        usun.setBounds(200, 200, 100, 25);
        assertEquals(vmd.getUsun().getBounds(), usun.getBounds());
    }
    @Test
    void aktualizuj() {
        assertNotNull(vmd.getAktualizuj());
    }

    @Test
    void nazwaAktualizuj() {
        assertEquals("aktualizuj", vmd.getAktualizuj().getText());
    }

    @Test
    void polozenieAktualizuj() {
        JLabel aktualizuj = new JLabel();
        aktualizuj.setBounds(300, 200, 100, 25);
        assertEquals(vmd.getAktualizuj().getBounds(), aktualizuj.getBounds());
    }
    @Test
    void szukanieProduktu() {
        assertNotNull(vmd.getPodajProdukt());
    }

    @Test
    void nazwaPodajProdukt() {
        assertEquals("Wpisz nazwę produktu:", vmd.getPodajProdukt().getText());
    }

    @Test
    void polozeniePodajProdukt() {
        JLabel podajProdukt = new JLabel();
        podajProdukt.setBounds(600, 0, 200, 25);
        assertEquals(vmd.getPodajProdukt().getBounds(), podajProdukt.getBounds());
    }
    @Test
    void polozenieListyProduktow() {
        JLabel listaProduktow = new JLabel();
        listaProduktow.setBounds(600, 30, 100, 25);
        assertEquals(vmd.getListaWyboruProduktow().getBounds(), listaProduktow.getBounds());
    }

}