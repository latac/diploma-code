package view;

import Elements.Dish;
import Elements.Meal;
import Elements.Product;
import data.DataConnector;
import data.DishDatabase;
import data.MealDatabase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewMenageMeal extends JFrame {
    private JPanel panel;
    private JLabel nazwaPosilku;
    private JLabel kcal;
    private JLabel wyliczoneKcal;
    private JLabel weglowodany;
    private JLabel wyliczoneWeglowodany;
    private JLabel bialka;
    private JLabel wyliczoneBialka;
    private JLabel tluszcze;
    private JLabel wyliczoneTluszcze;
    private JLabel podajNazweDania;
    private JTextField podanaNazwaPosilku;
    private JTextField znajdzDanie;
    private JButton szukaj;
    private JButton dodaj;
    private JButton usun;
    private JButton aktualizuj;
    private JButton wroc;
    private JButton dodajDanie;
    private JButton usunDanie;
    private JList listaPosilkow;
    private JList listaDan;
    private List<Meal> arrayOfMeal;
    private Meal wybranyPosilekZListy;
    private List<Dish> dania;
    private JComboBox listaWyboruDania;
    private DefaultListModel<String> model;
    private List<Dish> listaDanWPosilku;;
    private Dish danieDoUsuniecia;


    public ViewMenageMeal() {
        super("Posiłek");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1100, 600);

        dania = DataConnector.Instance().Dish().PobierzDania();
        dania.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        wierszNazwyPosilku();
        wierszKcal();
        wierszBialka();
        wierszWeglowodanow();
        wierszTluszczy();
        przyciskAktualizuj();
        przyciskDodaj();
        przyciskSzukaj();
        przyciskUsun();
        przyciskWroc();
        wierszSzukaniaDania();
        wierszListyPosilkow();
        wierszZListaDan();

        panel.updateUI();
    }
    private void wierszNazwyPosilku() {
        nazwaPosilku = new JLabel("nazwa posiłku");
        nazwaPosilku.setBounds(0, 10, 200, 25);
        panel.add(nazwaPosilku);

        podanaNazwaPosilku = new JTextField();
        podanaNazwaPosilku.setBounds(200, 10, 200, 25);
        panel.add(podanaNazwaPosilku);
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
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Meal d = new Meal();
                d.setName(podanaNazwaPosilku.getText());

                DataConnector.Instance().Meal().UtworzPosilek(d);

                arrayOfMeal.add(d);

                arrayOfMeal.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                listaPosilkow.setListData(arrayOfMeal.toArray());
            }
        });
        panel.add(dodaj);
    }

    private void przyciskUsun() {
        usun = new JButton("usuń");
        usun.setBounds(200, 200, 100, 25);

        usun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wybranyPosilekZListy != null) {
                    DataConnector.Instance().Meal().Usun(wybranyPosilekZListy.getId());
                    arrayOfMeal.remove(wybranyPosilekZListy);
                    listaPosilkow.setListData(arrayOfMeal.toArray());
                }
            }
        });
        panel.add(usun);
    }

    private void przyciskAktualizuj() {

        aktualizuj = new JButton("aktualizuj");
        aktualizuj.setBounds(300, 200, 100, 25);
        aktualizuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wybranyPosilekZListy != null) {
                    int pozycjaWLIscie = arrayOfMeal.indexOf(wybranyPosilekZListy);

                    wybranyPosilekZListy.setName(podanaNazwaPosilku.getText());

                    DataConnector.Instance().Meal().Edytuj(wybranyPosilekZListy);
                    listaPosilkow.setListData(arrayOfMeal.toArray());
                }
            }
        });
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

    private void wierszSzukaniaDania() {
        podajNazweDania = new JLabel("Wpisz nazwę dania:");
        podajNazweDania.setBounds(600,0,200,25);
        panel.add(podajNazweDania);


        listaWyboruDania = new JComboBox<>(dania.toArray());
        listaWyboruDania.setBounds(600, 30, 100, 25);

        panel.add(listaWyboruDania);

        dodajDanie = new JButton("+");
        dodajDanie.setBounds(900,30,50,25);
        dodajDanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idPosilku = wybranyPosilekZListy.getId();
                Dish wybraneDanie = dania.get(listaWyboruDania.getSelectedIndex());
                int idDania = wybraneDanie.getId();
                DataConnector.Instance().Meal().DodajDanieDoPosilku(idPosilku, idDania);
                listaDanWPosilku.add(wybraneDanie);

                List<Product> produkty = DataConnector.Instance().Produkty().PobierzProduktyZDania(idDania);

                float sumaKalorii = Float.valueOf(wyliczoneKcal.getText());
                float sumaBialek = Float.valueOf(wyliczoneBialka.getText());
                float sumaWeglowodanow = Float.valueOf(wyliczoneWeglowodany.getText());
                float sumaTluszczy = Float.valueOf(wyliczoneTluszcze.getText());

                for (Product p : produkty) {
                    sumaKalorii += p.getKcal() * p.wyliczIloscProduktu();
                    sumaBialek += p.getProtein() * p.wyliczIloscProduktu();
                    sumaWeglowodanow += p.getCarbohydrates() * p.wyliczIloscProduktu();
                    sumaTluszczy += p.getFat() * p.wyliczIloscProduktu();
                }

                wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                wyliczoneBialka.setText(String.valueOf(sumaBialek));
                wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));


                listaDan.setListData(listaDanWPosilku.toArray());
            }
        });
        panel.add(dodajDanie);

        usunDanie = new JButton("-");
        usunDanie.setBounds(950,30,50,25);
        usunDanie.addActionListener(new ActionListener() {
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
        panel.add(usunDanie);
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
                    int idMeal = arrayOfMeal.get(id).getId();
                    listaDanWPosilku = DataConnector.Instance().Dish().PobierzDaniaZPosilku(idMeal);

                    wybranyPosilekZListy = arrayOfMeal.get(id);
                    float sumaKalorii = 0f;
                    float sumaBialek = 0f;
                    float sumaWeglowodanow = 0f;
                    float sumaTluszczy = 0f;

                    for (Dish d : listaDanWPosilku) {
                        List<Product> produktyWDaniu = DataConnector.Instance().Produkty().PobierzProduktyZDania(d.getId());
                        for (Product p : produktyWDaniu) {
                            sumaKalorii += p.getKcal() * p.wyliczIloscProduktu();
                            sumaBialek += p.getProtein() * p.wyliczIloscProduktu();
                            sumaWeglowodanow += p.getCarbohydrates() * p.wyliczIloscProduktu();
                            sumaTluszczy += p.getFat() * p.wyliczIloscProduktu();
                        }
                    }
                    podanaNazwaPosilku.setText(wybranyPosilekZListy.getName());
                    wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                    wyliczoneBialka.setText(String.valueOf(sumaBialek));
                    wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                    wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));

                    listaDan.setListData(listaDanWPosilku.toArray());
                }
            }
        });

        panel.add(listScroller);
        panel.updateUI();
    }

    private void wierszListyPosilkow(){

        DataConnector connector = DataConnector.Instance();
        MealDatabase posilekDatabase = new MealDatabase(connector);
        arrayOfMeal = posilekDatabase.PobierzPosilki();
        UstawListe();


    }

    private void wierszZListaDan() {
        DefaultListModel<Dish> model = new DefaultListModel<>();

        if (listaDanWPosilku != null) {
            for (int i = 0; i < listaDanWPosilku.size(); i++) {
                model.add(i, listaDanWPosilku.get(i));
            }
        }
        listaDan = new JList(model);
        listaDan.setBounds(600, 100, 300, 300);

        listaDan.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaDan.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane();


        listScroller.setViewportView(listaDan);
        listScroller.setVisible(true);

        listScroller.setBounds(600, 100, 300, 300);

        listScroller.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listScroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        listScroller.setPreferredSize(new Dimension(400, 400));

        listaDan.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = listaDan.getSelectedIndex();
                if (id != -1) {
                    danieDoUsuniecia = listaDanWPosilku.get(id);
                } else {
                    danieDoUsuniecia = null;
                }
            }
        });
        panel.add(listScroller);
        listScroller.updateUI();
        panel.updateUI();
    }
}