package view;

import Elements.Day;
import Elements.Dish;
import Elements.Meal;
import Elements.Product;
import data.DataConnector;
import data.DayDatabase;
import data.MealDatabase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class ViewMenageDay extends JFrame{
    private JPanel panel;
    private JLabel nazwaDania;
    private JLabel kcal;
    private JLabel wyliczoneKcal;
    private JLabel weglowodany;
    private JLabel wyliczoneWeglowodany;
    private JLabel bialka;
    private JLabel wyliczoneBialka;
    private JLabel tluszcze;
    private JLabel wyliczoneTluszcze;
    private JLabel podajPosilek;
    private JTextField znajdzPosilek;
    private JButton szukaj;
    private JButton dodaj;
    private JButton usun;
    private JButton aktualizuj;
    private JButton wroc;
    private JButton dodajPosilek;
    private JButton usunPosilek;
    private JList listaDni;
    private JList listaPosilkow;
    private Date wybranyDzien;
    private JComboBox listaWyboruPosilku;
    private List<Meal> posilki;
    private List<Meal> arrayOfMeal;
    private DefaultListModel<String> model;
    private Meal wybranyPosilekZListy;

  /*  public ViewMenageDay(Date dzien) {
        super("Dzien");

        wybranyDzien = dzien;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        setVisible(true);

        posilki = DataConnector.Instance().Meal().PobierzPosilki();

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        wierszNumeruDnia();
        wierszKcal();
        wierszBialka();
        wierszWeglowodanow();
        wierszTluszczy();
        przyciskAktualizuj();
        przyciskDodaj();
        przyciskSzukaj();
        przyciskUsun();
        przyciskWroc();
        wierszSzukaniaPosilku();



        panel.updateUI();
    }
    private void wierszNumeruDnia() {
        nazwaDania = new JLabel(wybranyDzien.toString());
        nazwaDania.setBounds(0, 10, 200, 25);
        panel.add(nazwaDania);
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

    private void przyciskSzukaj() {

        szukaj = new JButton("szukaj");
        szukaj.setBounds(0, 200, 100, 25);
        panel.add(szukaj);
    }

    private void przyciskDodaj() {
        dodaj = new JButton("dodaj");
        dodaj.setBounds(100, 200, 100, 25);
        panel.add(dodaj);
    }

    private void przyciskUsun() {
        usun = new JButton("usuń");
        usun.setBounds(200, 200, 100, 25);
        panel.add(usun);
    }

    private void przyciskAktualizuj() {

        aktualizuj = new JButton("aktualizuj");
        aktualizuj.setBounds(300, 200, 100, 25);
        panel.add(aktualizuj);
    }

    private void przyciskWroc() {
        wroc = new JButton("wróć");
        wroc.setBounds(400, 200, 100, 25);
        wroc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(wroc);
    }

    private void wierszSzukaniaPosilku() {
        podajPosilek = new JLabel("Wpisz nazwę posiłku:");
        podajPosilek.setBounds(600,0,200,25);
        panel.add(podajPosilek);

        listaWyboruPosilku = new JComboBox<>(posilki.toArray());
        listaWyboruPosilku.setBounds(600, 30, 100, 25);

        panel.add(listaWyboruPosilku);

        dodajPosilek = new JButton("+");
        dodajPosilek.setBounds(900,30,50,25);
        dodajPosilek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idMeal = wybranyPosilekZListy.getId();

                DataConnector.Instance().Day().DodajPosilekDoDnia(idMeal, java.sql.Date.valueOf(wybranyDzien.toString()));
                posilki.add(wybranyPosilekZListy);

                List<Dish> dania = DataConnector.Instance().Dish().PobierzDaniaZPosilku(wybranyPosilekZListy.getId());

                float sumaKalorii = Float.valueOf(wyliczoneKcal.getText());
                float sumaBialek = Float.valueOf(wyliczoneBialka.getText());
                float sumaWeglowodanow = Float.valueOf(wyliczoneWeglowodany.getText());
                float sumaTluszczy = Float.valueOf(wyliczoneTluszcze.getText());

                for (Dish d : dania) {
                    List<Product> produkty = DataConnector.Instance().Produkty().PobierzProduktyZDania(d.getId());

                    for (Product p : produkty) {
                        sumaKalorii += p.getKcal() * p.wyliczIloscProduktu();
                        sumaBialek += p.getProtein() * p.wyliczIloscProduktu();
                        sumaWeglowodanow += p.getCarbohydrates() * p.wyliczIloscProduktu();
                        sumaTluszczy += p.getFat() * p.wyliczIloscProduktu();
                    }
                }
                wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                wyliczoneBialka.setText(String.valueOf(sumaBialek));
                wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));


                listaPosilkow.setListData(posilki.toArray());
            }
        });
        panel.add(dodajPosilek);

        usunPosilek = new JButton("-");
        usunPosilek.setBounds(950,30,50,25);
        usunPosilek.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                if (danieDoUsuniecia != null) {
                    DataConnector.Instance().Meal().UsunDanieZPosilku(danieDoUsuniecia.getId(), wybranyPosilekZListy.getId());

                    List<Product> produkty = DataConnector.Instance().Produkty().PobierzProduktyZDania(danieDoUsuniecia.getId());

                    float sumaKalorii = Float.valueOf(wyliczoneKcal.getText());
                    float sumaBialek = Float.valueOf(wyliczoneBialka.getText());
                    float sumaWeglowodanow = Float.valueOf(wyliczoneWeglowodany.getText());
                    float sumaTluszczy = Float.valueOf(wyliczoneTluszcze.getText());

                    for (Product p : produkty) {
                        sumaKalorii -= p.getKcal() * p.wyliczIloscProduktu();
                        sumaBialek -= p.getProtein() * p.wyliczIloscProduktu();
                        sumaWeglowodanow -= p.getCarbohydrates() * p.wyliczIloscProduktu();
                        sumaTluszczy -= p.getFat() * p.wyliczIloscProduktu();
                    }

                    wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                    wyliczoneBialka.setText(String.valueOf(sumaBialek));
                    wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                    wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));


                    listaDanWPosilku.remove(danieDoUsuniecia);

                    listaDan.setListData(listaDanWPosilku.toArray());
                    danieDoUsuniecia = null;
                }
            }
        });
        panel.add(usunPosilek);
    }


    public void UstawListe() {
        model = new DefaultListModel<>();

        arrayOfMeal.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (int i = 0; i < arrayOfMeal.size(); i++) {
            model.add(i, arrayOfMeal.get(i).getName());
        }


        listaPosilkow = new JList(model);
        listaPosilkow.setBounds(100, 300, 200, 200);
        listaPosilkow.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaPosilkow.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane();


        listScroller.setViewportView(listaPosilkow);
        listScroller.setVisible(true);
        listScroller.setBounds(100, 300, 200, 200);

        listScroller.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listScroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        listScroller.setPreferredSize(new Dimension(400, 400));

        listaPosilkow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = listaPosilkow.getSelectedIndex();
                if (id != -1) {
                    wybranyPosilekZListy = arrayOfMeal.get(id);
                } else
                    wybranyPosilekZListy = null;
            }
        });

        panel.add(listScroller);
        panel.updateUI();
    }

    private void wierszZListyPosilkow(List<Meal> posilki) {
        DataConnector connector = DataConnector.Instance();
        MealDatabase posilekDatabase = new MealDatabase(connector);
        arrayOfMeal = posilekDatabase.PobierzPosilki();
        UstawListe();

    }*/
}
