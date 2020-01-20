package Tests.View;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.createMock;

import data.DayDatabase;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import Elements.Dish;
import Elements.Meal;
import Elements.Product;
import data.DataConnector;
import data.DishDatabase;
import data.ProduktDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import view.ViewMenageDay;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.configuration.ConfigurationType.PowerMock;

class ViewMenageDayTest {
    private Date dzien;
    private AncestorListener listener;
    private ViewMenageDay vmd;

    @Mock
    DataConnector dc;
    DishDatabase dishDB;
    ProduktDatabase productDB;

    @BeforeEach
    void setUp() {
        dzien = new Date(2020, Calendar.FEBRUARY, 1);
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
        vmd = new ViewMenageDay(dzien, listener);
    }

    @AfterEach
    void tearDown() {
        dzien = null;
        listener = null;
        vmd = null;
    }

    @Test
    void constructorDefaultPanel() {


        assertNotNull(vmd.getPanel());
    }

    @Test
    void defaultSwieto() {


        assertNotNull(vmd.getCzyToSwieto());
    }

    @Test
    void napisSwieto() {
        assertEquals("Święto", vmd.getCzyToSwieto().getText());
    }

    @Test
    void sprawdzeniePolozeniaChcekBoxa() {
        JCheckBox czyToSwieto = new JCheckBox();
        czyToSwieto.setBounds(250, 10, 200, 25);
        assertEquals(vmd.getCzyToSwieto().getBounds(), czyToSwieto.getBounds());
    }

    @Test
    void defaultNumerDnia() {

        assertNotNull(vmd.getNazwaDania());
    }

    @Test
    void sprawdzaniePolozeniaNazwyDnia() {
        JLabel nazwaDnia = new JLabel();
        nazwaDnia.setBounds(0, 10, 200, 25);
        assertEquals(vmd.getNazwaDania().getBounds(), nazwaDnia.getBounds());
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
        wroc.setBounds(100, 200, 100, 25);
        assertEquals(vmd.getWroc().getBounds(), wroc.getBounds());
    }

    @Test
    void szukaniePosilku() {
        assertNotNull(vmd.getPodajPosilek());
    }

    @Test
    void nazwaPodajPosilek() {
        assertEquals("Wpisz nazwę posiłku:", vmd.getPodajPosilek().getText());
    }

    @Test
    void polozeniePodajPosilek() {
        JLabel podajPosilek = new JLabel();
        podajPosilek.setBounds(600, 0, 200, 25);
        assertEquals(vmd.getPodajPosilek().getBounds(), podajPosilek.getBounds());
    }

    @Test
    void polozenieListyPosilkow() {
        JLabel listaPosilkow = new JLabel();
        listaPosilkow.setBounds(600, 30, 100, 25);
        assertEquals(vmd.getListaWyboruPosilku().getBounds(), listaPosilkow.getBounds());
    }

    // @Test
    void testowanieKliknieciaDodaj() throws Exception {
        float a = 2.0f;
        float b = 3.0f;
        Product p1 = new Product();
        p1.setKcal(a);
        Product p2 = new Product();
        p2.setKcal(b);
        List<Product> listaProduktow = new ArrayList<>();
        listaProduktow.add(p1);
        listaProduktow.add(p2);

        List<Dish> listaDish = new ArrayList<Dish>();

        listaDish.add(new Dish());
        listaDish.add(new Dish());

        List<Meal> listaPosilkow = new ArrayList<Meal>();
        listaPosilkow.add(new Meal());

        vmd.getListaPosilkow().setListData(listaPosilkow.toArray());

        dc = createMock(DataConnector.class);
        try {
            Date date = new Date();
            dishDB = createMock(DishDatabase.class);
            expect(dishDB.PobierzDaniaZPosilku(anyInt())).andReturn(listaDish);
            productDB = createMock(ProduktDatabase.class);
            DayDatabase dayDB = createMock(DayDatabase.class);

            expect(dc.Dish()).andReturn(dishDB);
            expect(dc.Day()).andReturn(dayDB);

            expect(dc.Produkty()).andReturn(productDB);
            expect(productDB.PobierzProduktyZDania(anyInt())).andReturn(listaProduktow);

            vmd.getDodajPosilek().doClick();
            assertEquals(vmd.getWyliczoneKcal().getText(), "409,500");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void przyciskUsunPosilek() {
        assertNotNull(vmd.getUsunPosilek());
    }

    @Test
    void nazwaUsunPosilek() {
        assertEquals("-", vmd.getUsunPosilek().getText());
    }

    @Test
    void polozenieUsunPosilek() {
        JButton usunPosilek = new JButton();
        usunPosilek.setBounds(850, 30, 50, 25);
        assertEquals(vmd.getUsunPosilek().getBounds(), usunPosilek.getBounds());
    }
    @Test
    void sprawdzanieKoloruCzerwonego1(){
        vmd.UstawTeksty(1,1,1,1);
        assertEquals(vmd.getWyliczoneKcal().getForeground(), Color.RED);
    }
    @Test
    void sprawdzanieKoloruZielonego1(){
        vmd.UstawTeksty(980,36.75f,134.75f,32.67f);
        assertEquals(vmd.getWyliczoneKcal().getForeground(), Color.GREEN);
    }
    @Test
    void sprawdzanieKoloruCzerwonego2(){
        vmd.UstawTeksty(1,1,1,1);
        assertEquals(vmd.getWyliczoneBialka().getForeground(), Color.RED);
    }
    @Test
    void sprawdzanieKoloruZielonego2(){
        vmd.UstawTeksty(980,36.75f,134.75f,32.67f);
        assertEquals(vmd.getWyliczoneBialka().getForeground(), Color.GREEN);
    }
    @Test
    void sprawdzanieKoloruCzerwonego3(){
        vmd.UstawTeksty(1,1,1,1);
        assertEquals(vmd.getWyliczoneWeglowodany().getForeground(), Color.RED);
    }
    @Test
    void sprawdzanieKoloruZielonego3(){
        vmd.UstawTeksty(980,36.75f,134.75f,32.67f);
        assertEquals(vmd.getWyliczoneWeglowodany().getForeground(), Color.GREEN);
    }
    @Test
    void sprawdzanieKoloruCzerwonego4(){
        vmd.UstawTeksty(1,1,1,1);
        assertEquals(vmd.getWyliczoneTluszcze().getForeground(), Color.RED);
    }
    @Test
    void sprawdzanieKoloruZielonego4(){
        vmd.UstawTeksty(980,36.75f,134.75f,32.67f);
        assertEquals(vmd.getWyliczoneTluszcze().getForeground(), Color.GREEN);
    }
    @Test
    void ustawListe(){
        assertNotNull(vmd.getListaPosilkow());
    }
    @Test
    void posilkiDoListy(){
        assertNotNull(vmd.getPosilkiDoListy());
    }
    @Test
    void posilkiDoCombo(){
        assertNotNull(vmd.getPosilkiDoCombo());
    }
}