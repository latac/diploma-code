package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ViewMenageDayTest {
    private Date dzien;
    private AncestorListener listener;
    private ViewMenageDay vmd;

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
    void polozenieKcal(){
        JLabel kcal = new JLabel();
        kcal.setBounds(0,40,200,25);
        assertEquals(vmd.getKcal().getBounds(), kcal.getBounds());
    }
    @Test
    void iloscKcal(){
        assertEquals("0,000", vmd.getWyliczoneKcal().getText());
    }
    @Test
    void polozenieIlosciKcal(){
        JLabel wyliczoneKcal = new JLabel();
        wyliczoneKcal.setBounds(200,40,200,25);
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
    void polozenieWeglowodany(){
        JLabel weglowodany = new JLabel();
        weglowodany.setBounds(0,70,200,25);
        assertEquals(vmd.getWeglowodany().getBounds(), weglowodany.getBounds());
    }
    @Test
    void iloscWeglowodanow(){
        assertEquals("0,000", vmd.getWyliczoneWeglowodany().getText());
    }
    @Test
    void polozenieIlosciWeglowodanow(){
        JLabel wyliczoneweglowodany = new JLabel();
        wyliczoneweglowodany.setBounds(200,70,200,25);
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
    void polozenieBialka(){
        JLabel bialka = new JLabel();
        bialka.setBounds(0,100,200,25);
        assertEquals(vmd.getBialka().getBounds(), bialka.getBounds());
    }
    @Test
    void iloscBialek(){
        assertEquals("0,000", vmd.getWyliczoneBialka().getText());
    }
    @Test
    void polozenieIlosciBialek(){
        JLabel wyliczoneBialka = new JLabel();
        wyliczoneBialka.setBounds(200,100,200,25);
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
    void polozenieTluszczy(){
        JLabel tluszcz = new JLabel();
        tluszcz.setBounds(0,130,200,25);
        assertEquals(vmd.getTluszcze().getBounds(), tluszcz.getBounds());
    }
    @Test
    void iloscTluszczy(){
        assertEquals("0,000", vmd.getWyliczoneTluszcze().getText());
    }
    @Test
    void polozenieIlosciTluszczy(){
        JLabel wyliczoneTluszczu = new JLabel();
        wyliczoneTluszczu.setBounds(200,130,200,25);
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
    void polozenieWroc(){
        JLabel wroc = new JLabel();
        wroc.setBounds(100,200,100,25);
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
    void polozeniePodajPosilek(){
        JLabel podajPosilek = new JLabel();
        podajPosilek.setBounds(600,0,200,25);
        assertEquals(vmd.getPodajPosilek().getBounds(), podajPosilek.getBounds());
    }
    @Test
    void polozenieListyPosilkow(){
        JLabel listaPosilkow = new JLabel();
        listaPosilkow.setBounds(600,30,100,25);
        assertEquals(vmd.getListaWyboruPosilku().getBounds(), listaPosilkow.getBounds());
    }


}