package view;

import javax.swing.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ViewMenageMain extends JFrame {

    private JPanel panel;
    private JButton produkt;
    private JButton danie;
    private JButton posilek;
    private JButton organizacja;
    private JButton zapisz;
    private JLabel kcal;
    private JLabel weglowodany;
    private JLabel bialka;
    private JLabel tluszcze;
    private JLabel poniedzialek;
    private JLabel wtorek;
    private JLabel sroda;
    private JLabel czwartek;
    private JLabel piatek;
    private JLabel sobota;
    private JLabel niedziela;
    private ArrayList<JButton> miesiac;

    Date aktualnaData;

    public ViewMenageMain() {
        super("Przypisanie jednostki organizacyjnej");

        aktualnaData = new Date();
        miesiac = new ArrayList<>();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1400, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        przyciskProdukt();
        przyciskDanie();
        przyciskPosilek();
        przyciskOrganizacji();
        przyciskZapisz();
        wierszKcal();
        wierszBialka();
        wierszTluszczy();
        wierszWeglowodanow();
        przyciskiDni();
        wierszNazwDni();


        panel.updateUI();


        WybierzNastepnyMiesiac();
    }

    private void przyciskProdukt() {
        produkt = new JButton("produkt");
        produkt.setBounds(0, 0, 100, 25);
        panel.add(produkt);
    }
    private void przyciskDanie(){
        danie = new JButton("danie");
        danie.setBounds(100, 0, 100, 25);
        panel.add(danie);

    }


    private void przyciskPosilek(){
        posilek = new JButton("posiłek");
        posilek.setBounds(200, 0, 100, 25);
        panel.add(posilek);

    }

    private void przyciskOrganizacji(){
        organizacja = new JButton("Organizacyjna");
        organizacja.setBounds(400, 0, 150, 25);
        panel.add(organizacja);

    }

    private void przyciskZapisz(){
        zapisz = new JButton("zapisz");
        zapisz.setBounds(600, 0, 100, 25);
        panel.add(zapisz);

    }
    private void wierszKcal() {
        kcal = new JLabel("kcal");
        kcal.setBounds(0, 40, 200, 25);
        panel.add(kcal);

    }

    private void wierszWeglowodanow() {
        weglowodany = new JLabel("węglowodany");
        weglowodany.setBounds(0, 70, 200, 25);
        panel.add(weglowodany);

    }

    private void wierszBialka() {
        bialka = new JLabel("białka");
        bialka.setBounds(0, 100, 200, 25);
        panel.add(bialka);

    }

    private void wierszTluszczy() {
        tluszcze = new JLabel("tłuszcze");
        tluszcze.setBounds(0, 130, 200, 25);
        panel.add(tluszcze);

    }
    private void wierszNazwDni(){
        poniedzialek = new JLabel("pon");
        poniedzialek.setBounds(410,100,50,25);
        panel.add(poniedzialek);

        wtorek = new JLabel("wt");
        wtorek.setBounds(460,100,50,25);
        panel.add(wtorek);

        sroda = new JLabel("śr");
        sroda.setBounds(510,100,50,25);
        panel.add(sroda);

        czwartek = new JLabel("czw");
        czwartek.setBounds(560,100,50,25);
        panel.add(czwartek);

        piatek = new JLabel("pt");
        piatek.setBounds(610,100,50,25);
        panel.add(piatek);

        sobota = new JLabel("sob");
        sobota.setBounds(660,100,50,25);
        panel.add(sobota);

        niedziela = new JLabel("ndz");
        niedziela.setBounds(710,100,50,25);
        panel.add(niedziela);

    }

    private void WybierzNastepnyMiesiac() {
        Calendar kalendarz = Calendar.getInstance();
        kalendarz.setTime(aktualnaData);
        kalendarz.add(Calendar.MONTH, 1);
        aktualnaData = kalendarz.getTime();
        przyciskiDni();
    }

    private void przyciskiDni(){
        for (JButton button: miesiac) {
            panel.remove(button);
        }
        miesiac = new ArrayList<>();

        int wybranyMiesiacLiczba = aktualnaData.getMonth();

        Calendar kalendarz = Calendar.getInstance();
        kalendarz.setTime(new Date(aktualnaData.getYear(), wybranyMiesiacLiczba, 0));
        int dzienTygodnia = kalendarz.get(Calendar.DAY_OF_WEEK) - 1;
        int przesuniecie = 0;
        int prawidlowyNumerDnia = 0;
        boolean czyMogeZapisac = false;
        int obliczonyNumerDnia = 0;

        YearMonth yearMonthObject = YearMonth.of(aktualnaData.getYear(), wybranyMiesiacLiczba +1);
        int daysInMonth = yearMonthObject.lengthOfMonth();


        int iloscDni = 7;
        int tydzien = 5;
        miesiac = new ArrayList<>();
        for(int numerTygodnia=0; numerTygodnia<tydzien; numerTygodnia++) {
            for(int numerDnia=0; numerDnia<iloscDni;numerDnia++) {
                obliczonyNumerDnia = numerTygodnia * 7 + numerDnia;
                if (obliczonyNumerDnia == dzienTygodnia) {
                    czyMogeZapisac = true;
                    przesuniecie = obliczonyNumerDnia;
                }
                prawidlowyNumerDnia = obliczonyNumerDnia - przesuniecie +1;
                if (czyMogeZapisac && prawidlowyNumerDnia <= daysInMonth) {
                    JButton button =new JButton(String.valueOf(prawidlowyNumerDnia));
                    button.setBounds(numerDnia * 50 + 400, numerTygodnia * 50 + 130, 50, 50);
                    panel.add(button);
                    miesiac.add(button);
                }
            }
        }

        panel.updateUI();
    }

}
