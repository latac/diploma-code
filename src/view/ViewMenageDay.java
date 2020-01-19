package view;

import Elements.Dish;
import Elements.Meal;
import Elements.Norma;
import Elements.Product;
import data.DataConnector;
import data.MealDatabase;

import javax.swing.*;
import javax.swing.event.AncestorListener;
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
    private List<Meal> posilkiDoCombo;
    private List<Meal> posilkiDoListy;
    private DefaultListModel<String> model;
    private Meal wybranyPosilekZListy;
    private JCheckBox czyToSwieto;

    public ViewMenageDay(Date dzien, AncestorListener listenerZamkniecia) {
        super("Dzien");

        wybranyDzien = dzien;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        setVisible(true);

        posilkiDoCombo = DataConnector.Instance().Meal().PobierzPosilki();
        posilkiDoCombo.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        panel = new JPanel();
        panel.addAncestorListener(listenerZamkniecia);
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
        wierszZListyPosilkow();
        checkboxCzyToSwieto();


        panel.updateUI();
    }

    private void checkboxCzyToSwieto() {
        czyToSwieto = new JCheckBox("Święto");
        boolean toJestSwieto = DataConnector.Instance().Day().CzyJestemSwietem(new java.sql.Date(wybranyDzien.getTime()));

        czyToSwieto.setSelected(toJestSwieto);

        czyToSwieto.setBounds(250, 10, 200, 25);
        czyToSwieto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = czyToSwieto.isSelected();
                if (zaznaczone) {
                    DataConnector.Instance().Day().DodajSwieto(new java.sql.Date(wybranyDzien.getTime()));
                } else {
                    DataConnector.Instance().Day().UsunSwieto(new java.sql.Date(wybranyDzien.getTime()));
                }
            }
        });

        panel.add(czyToSwieto);
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

        listaWyboruPosilku = new JComboBox<>(posilkiDoCombo.toArray());
        listaWyboruPosilku.setBounds(600, 30, 100, 25);

        panel.add(listaWyboruPosilku);

        dodajPosilek = new JButton("+");
        dodajPosilek.setBounds(900,30,50,25);
        dodajPosilek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Meal posilek = posilkiDoCombo.get(listaWyboruPosilku.getSelectedIndex());
                int idMeal = posilek.getId();

                DataConnector.Instance().Day().DodajPosilekDoDnia(idMeal, new java.sql.Date(wybranyDzien.getTime()));
                posilkiDoListy.add(posilek);

                List<Dish> dania = DataConnector.Instance().Dish().PobierzDaniaZPosilku(posilek.getId());

                float sumaKalorii = Float.valueOf(wyliczoneKcal.getText().replace(",", "."));
                float sumaBialek = Float.valueOf(wyliczoneBialka.getText().replace(",", "."));
                float sumaWeglowodanow = Float.valueOf(wyliczoneWeglowodany.getText().replace(",", "."));
                float sumaTluszczy = Float.valueOf(wyliczoneTluszcze.getText().replace(",", "."));

                for (Dish d : dania) {
                    List<Product> produkty = DataConnector.Instance().Produkty().PobierzProduktyZDania(d.getId());

                    for (Product p : produkty) {
                        sumaKalorii += p.getKcal() * p.wyliczIloscProduktu();
                        sumaBialek += p.getProtein() * p.wyliczIloscProduktu();
                        sumaWeglowodanow += p.getCarbohydrates() * p.wyliczIloscProduktu();
                        sumaTluszczy += p.getFat() * p.wyliczIloscProduktu();
                    }
                }
                UstawTeksty(sumaKalorii, sumaBialek, sumaWeglowodanow, sumaTluszczy);


                listaPosilkow.setListData(posilkiDoListy.toArray());
            }
        });
        panel.add(dodajPosilek);

        usunPosilek = new JButton("-");
        usunPosilek.setBounds(950,30,50,25);
        usunPosilek.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                if (wybranyPosilekZListy != null) {
                    DataConnector.Instance().Meal().UsunPosilekZDnia(wybranyPosilekZListy.getId(), new java.sql.Date(wybranyDzien.getTime()));

                    List<Dish> dania = DataConnector.Instance().Dish().PobierzDaniaZPosilku(wybranyPosilekZListy.getId());

                    float sumaKalorii = Float.valueOf(wyliczoneKcal.getText().replace(",", "."));
                    float sumaBialek = Float.valueOf(wyliczoneBialka.getText().replace(",", "."));
                    float sumaWeglowodanow = Float.valueOf(wyliczoneWeglowodany.getText().replace(",", "."));
                    float sumaTluszczy = Float.valueOf(wyliczoneTluszcze.getText().replace(",", "."));

                    for (Dish d : dania) {
                        List<Product> produkty = DataConnector.Instance().Produkty().PobierzProduktyZDania(d.getId());

                        for (Product p : produkty) {
                            sumaKalorii -= p.getKcal() * p.wyliczIloscProduktu();
                            sumaBialek -= p.getProtein() * p.wyliczIloscProduktu();
                            sumaWeglowodanow -= p.getCarbohydrates() * p.wyliczIloscProduktu();
                            sumaTluszczy -= p.getFat() * p.wyliczIloscProduktu();
                        }
                    }
                    UstawTeksty(sumaKalorii, sumaBialek, sumaWeglowodanow, sumaTluszczy);



                    posilkiDoListy.remove(wybranyPosilekZListy);

                    listaPosilkow.setListData(posilkiDoListy.toArray());
                    wybranyPosilekZListy = null;
                }
            }
        });
        panel.add(usunPosilek);
    }


    public void UstawTeksty(float sumaKalorii, float sumaBialek, float sumaWeglowodanow, float sumaTluszczy) {
        Norma norma = new Norma();

        wyliczoneKcal.setText(String.format("%.3f", sumaKalorii));
        wyliczoneBialka.setText(String.format("%.3f", sumaBialek));
        wyliczoneWeglowodany.setText(String.format("%.3f", sumaWeglowodanow));
        wyliczoneTluszcze.setText(String.format("%.3f", sumaTluszczy));

        wyliczoneKcal.setForeground(norma.czyKcalWPrzedziale(sumaKalorii) ? Color.GREEN : Color.RED);
        wyliczoneBialka.setForeground(norma.czyProteinWPrzedziale(sumaBialek) ? Color.GREEN : Color.RED);
        wyliczoneWeglowodany.setForeground(norma.czyCarbohydratesWPrzedziale(sumaWeglowodanow) ? Color.GREEN : Color.RED);
        wyliczoneTluszcze.setForeground(norma.czyFatWPrzedziale(sumaTluszczy) ? Color.GREEN : Color.RED);
    }

    public void UstawListe() {
        model = new DefaultListModel<>();

        posilkiDoListy.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (int i = 0; i < posilkiDoListy.size(); i++) {
            model.add(i, posilkiDoListy.get(i).getName());
        }



        float sumaKalorii = Float.valueOf(wyliczoneKcal.getText());
        float sumaBialek = Float.valueOf(wyliczoneBialka.getText());
        float sumaWeglowodanow = Float.valueOf(wyliczoneWeglowodany.getText());
        float sumaTluszczy = Float.valueOf(wyliczoneTluszcze.getText());

        for (Meal m : posilkiDoListy) {
            List<Dish> dania = DataConnector.Instance().Dish().PobierzDaniaZPosilku(m.getId());

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

        UstawTeksty(sumaKalorii, sumaBialek, sumaWeglowodanow, sumaTluszczy);


        listaPosilkow = new JList(model);
        listaPosilkow.setBounds(600, 100, 300, 300);
        listaPosilkow.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaPosilkow.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane();


        listScroller.setViewportView(listaPosilkow);
        listScroller.setVisible(true);
        listScroller.setBounds(600, 100, 300, 300);

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
                    wybranyPosilekZListy = posilkiDoListy.get(id);
                } else
                    wybranyPosilekZListy = null;
            }
        });

        panel.add(listScroller);
        panel.updateUI();
    }

    private void wierszZListyPosilkow() {
        DataConnector connector = DataConnector.Instance();
        MealDatabase posilekDatabase = new MealDatabase(connector);
        posilkiDoListy = posilekDatabase.PobierzPosilekZDnia(new java.sql.Date(wybranyDzien.getTime()));
        UstawListe();

    }
}
