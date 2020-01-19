package view;

import Elements.Dish;
import Elements.Meal;
import Elements.Norma;
import Elements.Product;
import data.DataConnector;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ViewMenageMain extends JFrame {

    private JPanel panel;
    private JButton produkt;
    private JButton danie;
    private JButton posilek;
    private JButton organizacja;
    private JButton zapisz;
    private JButton poprzedniMiesiac;
    private JButton nastepnyMiesiac;
    private JLabel kcal;
    private JLabel wyliczoneKcal;
    private JLabel weglowodany;
    private JLabel wyliczoneWeglowodany;
    private JLabel bialka;
    private JLabel wyliczoneBialka;
    private JLabel tluszcze;
    private JLabel wyliczoneTluszcze;
    private JLabel poniedzialek;
    private JLabel wtorek;
    private JLabel sroda;
    private JLabel czwartek;
    private JLabel piatek;
    private JLabel sobota;
    private JLabel niedziela;
    private JLabel wyswietlanyMiesiac;
    private ArrayList<JButton> miesiac;

    private Date poczatekDekady, koniecDekady;
    private Date poczatekProgramu;

    Date aktualnaData;

    public ViewMenageMain() {
        super("Jadłospis");


        Calendar c = Calendar.getInstance();
        c.set(2020, 0, 1, 0, 0);
        poczatekProgramu =c.getTime();
                aktualnaData = new Date();
        miesiac = new ArrayList<>();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 850, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        przyciskProdukt();
        przyciskDanie();
        przyciskPosilek();
        przyciskNormy();
        przyciskZapisz();
        wierszKcal();
        wierszBialka();
        wierszTluszczy();
        wierszWeglowodanow();
        wierszNazwDni();
        wierszZmianyMiesiaca();
        UstawAktualnaDekade(aktualnaData);


        panel.updateUI();
    }

    private void przyciskProdukt() {
        produkt = new JButton("produkt");
        produkt.setBounds(0, 0, 100, 25);
        produkt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewMenageProduct().setVisible(true);
            }
        });
        panel.add(produkt);
    }
    private void przyciskDanie(){
        danie = new JButton("danie");
        danie.setBounds(100, 0, 100, 25);
        danie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewMenageDish().setVisible(true);
            }
        });
        panel.add(danie);

    }


    private void przyciskPosilek(){
        posilek = new JButton("posiłek");
        posilek.setBounds(200, 0, 100, 25);
        posilek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewMenageMeal().setVisible(true);
            }
        });
        panel.add(posilek);

    }

    private void przyciskNormy(){
        organizacja = new JButton("Norma");
        organizacja.setBounds(400, 0, 150, 25);
        organizacja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewMenageWorker().setVisible(true);
            }
        });
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

        wyliczoneKcal = new JLabel("0");
        wyliczoneKcal.setBounds(200, 40, 200, 25);
        panel.add(wyliczoneKcal);

    }

    private void wierszWeglowodanow() {
        weglowodany = new JLabel("węglowodany");
        weglowodany.setBounds(0, 70, 200, 25);
        panel.add(weglowodany);

        wyliczoneWeglowodany = new JLabel("0");
        wyliczoneWeglowodany.setBounds(200, 70, 200, 25);
        panel.add(wyliczoneWeglowodany);

    }

    private void wierszBialka() {
        bialka = new JLabel("białka");
        bialka.setBounds(0, 100, 200, 25);
        panel.add(bialka);

        wyliczoneBialka = new JLabel("0");
        wyliczoneBialka.setBounds(200, 100, 200, 25);
        panel.add(wyliczoneBialka);

    }

    private void wierszTluszczy() {
        tluszcze = new JLabel("tłuszcze");
        tluszcze.setBounds(0, 130, 200, 25);
        panel.add(tluszcze);

        wyliczoneTluszcze = new JLabel("0");
        wyliczoneTluszcze.setBounds(200, 130, 200, 25);
        panel.add(wyliczoneTluszcze);

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
    private void WybierzPoprzedniMiesiac() {
        Calendar kalendarz = Calendar.getInstance();
        kalendarz.setTime(aktualnaData);
        kalendarz.add(Calendar.MONTH, -1);
        aktualnaData = kalendarz.getTime();
        przyciskiDni();

    }
    private void wierszZmianyMiesiaca(){
        wyswietlanyMiesiac = new JLabel("miesiac");
        wyswietlanyMiesiac.setBounds(500,50,50,25);
        panel.add(wyswietlanyMiesiac);

        poprzedniMiesiac = new JButton("<");
        poprzedniMiesiac.setBounds(450, 50, 45, 25);
        poprzedniMiesiac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WybierzPoprzedniMiesiac();
            }
        });
        panel.add(poprzedniMiesiac);

        nastepnyMiesiac = new JButton(">");
        nastepnyMiesiac.setBounds(560, 50, 45, 25);
        nastepnyMiesiac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WybierzNastepnyMiesiac();
            }
        });
        panel.add(nastepnyMiesiac);
    }

    private void przyciskiDni(){
        for (JButton button: miesiac) {
            panel.remove(button);
        }
        miesiac = new ArrayList<>();

        int wybranyMiesiacLiczba = aktualnaData.getMonth();

        Calendar kalendarz = Calendar.getInstance();
        kalendarz.setTime(new Date(aktualnaData.getYear(), wybranyMiesiacLiczba, 0));


        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (wybranyMiesiacLiczba >= 0 && wybranyMiesiacLiczba <= 11 ) {
            month = months[wybranyMiesiacLiczba];
        }

        wyswietlanyMiesiac.setText(month);
        // tutaj zmień tekst "miesiąc"
        // odśwież ten layout

        int dzienTygodnia = kalendarz.get(Calendar.DAY_OF_WEEK) - 1;
        int przesuniecie = 0;
        int prawidlowyNumerDnia = 0;
        boolean czyMogeZapisac = false;
        int obliczonyNumerDnia = 0;

        YearMonth yearMonthObject = YearMonth.of(aktualnaData.getYear(), wybranyMiesiacLiczba +1);
        int daysInMonth = yearMonthObject.lengthOfMonth();


        int iloscDni = 7;
        int tydzien = 5;
        kalendarz.add(Calendar.DAY_OF_MONTH, 2);
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
                    Date aktualnaPelnaData = kalendarz.getTime();
                    if(aktualnaPelnaData.compareTo(poczatekDekady) >= 0 && aktualnaPelnaData.compareTo(koniecDekady) < 0) {
                        button.setBackground(Color.CYAN);
                    }
                    kalendarz.add(Calendar.DAY_OF_MONTH, 1);
                    button.setBounds(numerDnia * 50 + 400, numerTygodnia * 50 + 130, 50, 50);
                    panel.add(button);
                    miesiac.add(button);
                    int finalPrawidlowyNumerDnia = prawidlowyNumerDnia;
                    button.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getButton() == MouseEvent.BUTTON1) {
                                Date dzien = new Date(aktualnaData.getYear(), wybranyMiesiacLiczba, finalPrawidlowyNumerDnia);

                                new ViewMenageDay(dzien,akcjaZamknieciaOkna()).setVisible(true);
                            }
                            if (e.getButton() == MouseEvent.BUTTON3) {
                                // aktualna dekada w konstruktorze

                                Date dzien = new Date(aktualnaData.getYear(), wybranyMiesiacLiczba, finalPrawidlowyNumerDnia);

                                UstawAktualnaDekade(dzien);
                            }


                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                }
            }
        }

        panel.updateUI();
    }

    private AncestorListener akcjaZamknieciaOkna() {
        return new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {

            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                wyliczNormeDlaDekady();
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        };
    }

    public void  UstawAktualnaDekade(Date dzien) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Calendar k = Calendar.getInstance();

        long diffInMillies = Math.abs(dzien.getTime() - poczatekProgramu.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        int aktualnaDekada = ((int)diff + 1)/14;

        k.setTime(poczatekProgramu);
        k.add(Calendar.DAY_OF_MONTH, aktualnaDekada*14);
        poczatekDekady = k.getTime();
        k.add(Calendar.DAY_OF_MONTH, 14);
        koniecDekady = k.getTime();

        wyliczNormeDlaDekady();

        przyciskiDni();
    }

    public void wyliczNormeDlaDekady() {
        int iloscDni = 14;
        int iloscSwiat = DataConnector.Instance().Day().IleSwiat(poczatekDekady, koniecDekady);
        int iloscDniDoZliczenia = iloscDni - iloscSwiat;
        float sumaKalorii = 0;
        float sumaBialek = 0;
        float sumaWeglowodanow = 0;
        float sumaTluszczy = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(poczatekDekady);
        Date aktualnyDzienZDekady;

        List<Meal> posilki;


        for (int i = 0; i < iloscDni; i++)
        {
            aktualnyDzienZDekady = c.getTime();
            posilki = DataConnector.Instance().Meal().PobierzPosilekZDnia(new java.sql.Date(aktualnyDzienZDekady.getTime()));

            for (Meal m : posilki) {
                java.util.List<Dish> dania = DataConnector.Instance().Dish().PobierzDaniaZPosilku(m.getId());

                for (Dish d : dania) {
                    List<Product> produkty = DataConnector.Instance().Produkty().PobierzProduktyZDania(d.getId());

                    for (Product p : produkty) {
                        sumaKalorii += p.getKcal() * p.wyliczIloscProduktu();
                        sumaBialek += p.getProtein() * p.wyliczIloscProduktu();
                        sumaWeglowodanow += p.getCarbohydrates() * p.wyliczIloscProduktu();
                        sumaTluszczy += p.getFat() * p.wyliczIloscProduktu();
                    }
                }
            }

            c.add(Calendar.DAY_OF_MONTH, 1);
        }

        UstawTeksty(sumaKalorii, sumaBialek, sumaWeglowodanow, sumaTluszczy, iloscDniDoZliczenia);
    }

    public void UstawTeksty(float sumaKalorii, float sumaBialek, float sumaWeglowodanow, float sumaTluszczy, int iloscDni) {
        Norma norma = new Norma();

        wyliczoneKcal.setText(String.format("%.3f", sumaKalorii));
        wyliczoneBialka.setText(String.format("%.3f", sumaBialek));
        wyliczoneWeglowodany.setText(String.format("%.3f", sumaWeglowodanow));
        wyliczoneTluszcze.setText(String.format("%.3f", sumaTluszczy));

        wyliczoneKcal.setForeground(norma.czyKcalWPrzedziale(sumaKalorii/iloscDni) ? Color.GREEN : Color.RED);
        wyliczoneBialka.setForeground(norma.czyProteinWPrzedziale(sumaBialek/iloscDni) ? Color.GREEN : Color.RED);
        wyliczoneWeglowodany.setForeground(norma.czyCarbohydratesWPrzedziale(sumaWeglowodanow/iloscDni) ? Color.GREEN : Color.RED);
        wyliczoneTluszcze.setForeground(norma.czyFatWPrzedziale(sumaTluszczy/iloscDni) ? Color.GREEN : Color.RED);
    }

}
