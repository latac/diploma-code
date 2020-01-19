package view;

import Elements.Dish;
import Elements.Product;
import data.DataConnector;
import data.DishDatabase;
import data.ProduktDatabase;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ViewMenageDish extends JFrame {
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
    private JLabel podajProdukt;
    private JLabel podajIloscProdukty;
    private JTextField podanaNazwaDania;
    private JTextField znajdzProdukt;
    private JTextField iloscProduktu;
    private JButton szukaj;
    private JButton dodaj;
    private JButton usun;
    private JButton aktualizuj;
    private JButton wroc;
    private JButton dodajProdukt;
    private JButton usunProdukt;
    private JList listaDan;
    private List<Dish> arrayOfDish;
    private JList listaProduktow;
    private JComboBox listaWyboruProduktow;
    private List<Product> produkty;
    private DefaultListModel<String> model;
    private Dish wybraneDanieZListy;
    private Product produktDoUsuniecia;
    private List<Product> listaProduktowWDaniu;

    ViewMenageDish() {
        super("Danie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1100, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        produkty = DataConnector.Instance().Produkty().PobierzProdukty();
        produkty.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        add(panel);
        wierszNazwyDania();
        wierszKcal();
        wierszBialka();
        wierszWeglowodanow();
        wierszTluszczy();
        przyciskAktualizuj();
        przyciskDodaj();
        przyciskSzukaj();
        przyciskUsun();
        przyciskWroc();
        wierszSzukaniaProduktu();
        wierszListyDan();
       wierszZListaProduktow();

        panel.updateUI();
    }

    private void wierszNazwyDania() {
        nazwaDania = new JLabel("nazwa dania");
        nazwaDania.setBounds(0, 10, 200, 25);
        panel.add(nazwaDania);

        podanaNazwaDania = new JTextField();
        podanaNazwaDania.setBounds(200, 10, 200, 25);
        panel.add(podanaNazwaDania);
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
        weglowodany = new JLabel("weglowodany");
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
                Dish d = new Dish();
                d.setName(podanaNazwaDania.getText());

                DataConnector.Instance().Dish().UtworzDanie(d);

                arrayOfDish.add(d);

                arrayOfDish.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                listaDan.setListData(arrayOfDish.toArray());
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
                if (wybraneDanieZListy != null) {
                    DataConnector.Instance().Dish().Usun(wybraneDanieZListy.getId());
                    arrayOfDish.remove(wybraneDanieZListy);
                    listaDan.setListData(arrayOfDish.toArray());
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
                if (wybraneDanieZListy != null) {
                    int pozycjaWLIscie = arrayOfDish.indexOf(wybraneDanieZListy);

                    wybraneDanieZListy.setName(podanaNazwaDania.getText());

                    DataConnector.Instance().Dish().Edytuj(wybraneDanieZListy);
                    //arrayOfProducts.remove(wybranyProduktZListy);
                    listaDan.setListData(arrayOfDish.toArray());
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

    private void wierszSzukaniaProduktu() {
        podajProdukt = new JLabel("Wpisz nazwę produktu:");
        podajProdukt.setBounds(600, 0, 200, 25);
        panel.add(podajProdukt);

        podajIloscProdukty = new JLabel("Podaj ilość:");
        podajIloscProdukty.setBounds(800, 0, 200, 25);
        panel.add(podajIloscProdukty);

        iloscProduktu = new JTextField();
        iloscProduktu.setBounds(800, 30, 50,25);
        panel.add(iloscProduktu);

/*        znajdzProdukt = new JTextField();
        znajdzProdukt.setBounds(600, 30, 200, 25);
        panel.add(znajdzProdukt);*/


        listaWyboruProduktow = new JComboBox<>(produkty.toArray());
        listaWyboruProduktow.setBounds(600, 30, 100, 25);

        panel.add(listaWyboruProduktow);

        dodajProdukt = new JButton("+");
        dodajProdukt.setBounds(900, 30, 50, 25);
        dodajProdukt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idDania = wybraneDanieZListy.getId();
                Product wybranyProdukt =produkty.get(listaWyboruProduktow.getSelectedIndex());
                int idProduktu = wybranyProdukt.getId();
                int ilosc = Integer.valueOf(iloscProduktu.getText());
                wybranyProdukt.setAmountOfProduct(ilosc);
                DataConnector.Instance().Dish().DodajProduktDoDania(idProduktu, idDania, ilosc);
                listaProduktowWDaniu.add(wybranyProdukt);
                float sumaKalorii = Float.valueOf(wyliczoneKcal.getText());
                float sumaBialek = Float.valueOf(wyliczoneBialka.getText());
                float sumaWeglowodanow = Float.valueOf(wyliczoneWeglowodany.getText());
                float sumaTluszczy = Float.valueOf(wyliczoneTluszcze.getText());
                sumaKalorii += wybranyProdukt.getKcal() * wybranyProdukt.wyliczIloscProduktu();
                sumaBialek += wybranyProdukt.getProtein() * wybranyProdukt.wyliczIloscProduktu();
                sumaWeglowodanow += wybranyProdukt.getCarbohydrates() * wybranyProdukt.wyliczIloscProduktu();
                sumaTluszczy += wybranyProdukt.getFat() * wybranyProdukt.wyliczIloscProduktu();
                wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                wyliczoneBialka.setText(String.valueOf(sumaBialek));
                wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));

                listaProduktow.setListData(listaProduktowWDaniu.toArray());
            }
        });
        panel.add(dodajProdukt);

        usunProdukt = new JButton("-");
        usunProdukt.setBounds(950, 30, 50, 25);
        usunProdukt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (produktDoUsuniecia != null) {
                    float sumaKalorii = Float.valueOf(wyliczoneKcal.getText());
                    float sumaBialek = Float.valueOf(wyliczoneBialka.getText());
                    float sumaWeglowodanow = Float.valueOf(wyliczoneWeglowodany.getText());
                    float sumaTluszczy = Float.valueOf(wyliczoneTluszcze.getText());
                    sumaKalorii -= produktDoUsuniecia.getKcal() * produktDoUsuniecia.wyliczIloscProduktu();
                    sumaBialek -= produktDoUsuniecia.getProtein() * produktDoUsuniecia.wyliczIloscProduktu();
                    sumaWeglowodanow -= produktDoUsuniecia.getCarbohydrates() * produktDoUsuniecia.wyliczIloscProduktu();
                    sumaTluszczy -= produktDoUsuniecia.getFat() * produktDoUsuniecia.wyliczIloscProduktu();
                    wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                    wyliczoneBialka.setText(String.valueOf(sumaBialek));
                    wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                    wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));
                    DataConnector.Instance().Dish().UsunProduktZDania(produktDoUsuniecia.getId(), wybraneDanieZListy.getId());
                    listaProduktowWDaniu.remove(produktDoUsuniecia);

                    listaProduktow.setListData(listaProduktowWDaniu.toArray());
                    produktDoUsuniecia = null;
                }
            }
        });
        panel.add(usunProdukt);

    }
    
    public void UstawListe() {
        model = new DefaultListModel<>();

        arrayOfDish.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (int i = 0; i < arrayOfDish.size(); i++) {
            model.add(i, arrayOfDish.get(i).getName());
        }


        listaDan = new JList(model);
        listaDan.setBounds(100, 300, 200, 200);
        listaDan.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaDan.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane();


        listScroller.setViewportView(listaDan);
        listScroller.setVisible(true);
        listScroller.setBounds(100, 300, 200, 200);

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
                    int idDish = arrayOfDish.get(id).getId();
                    listaProduktowWDaniu = DataConnector.Instance().Produkty().PobierzProduktyZDania(idDish);

                    wybraneDanieZListy = arrayOfDish.get(id);
                    float sumaKalorii = 0f;
                    float sumaBialek = 0f;
                    float sumaWeglowodanow = 0f;
                    float sumaTluszczy = 0f;

                    for (Product p : listaProduktowWDaniu) {
                        sumaKalorii += p.getKcal() * p.wyliczIloscProduktu();
                        sumaBialek += p.getProtein() * p.wyliczIloscProduktu();
                        sumaWeglowodanow += p.getCarbohydrates() * p.wyliczIloscProduktu();
                        sumaTluszczy += p.getFat() * p.wyliczIloscProduktu();
                    }
                    podanaNazwaDania.setText(wybraneDanieZListy.getName());
                    wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                    wyliczoneBialka.setText(String.valueOf(sumaBialek));
                    wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                    wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));

                    listaProduktow.setListData(listaProduktowWDaniu.toArray());
                }
            }
        });

        panel.add(listScroller);
        panel.updateUI();
    }

    private void wierszListyDan() {

        DataConnector connector = DataConnector.Instance();
        DishDatabase danieDatabase = new DishDatabase(connector);
        arrayOfDish = danieDatabase.PobierzDania();
        
        UstawListe();
    }

    private void wierszZListaProduktow() {
        DefaultListModel<Product> model = new DefaultListModel<>();

        if (listaProduktowWDaniu != null) {
            for (int i = 0; i < listaProduktowWDaniu.size(); i++) {
                model.add(i, listaProduktowWDaniu.get(i));
            }
        }
        listaProduktow = new JList(model);
        listaProduktow.setBounds(600, 100, 300, 300);

        listaProduktow.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaProduktow.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane();


        listScroller.setViewportView(listaProduktow);
        listScroller.setVisible(true);

        listScroller.setBounds(600, 100, 300, 300);

        listScroller.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listScroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        listScroller.setPreferredSize(new Dimension(400, 400));

        listaProduktow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = listaProduktow.getSelectedIndex();
                if (id != -1) {
                    produktDoUsuniecia = listaProduktowWDaniu.get(id);
                } else {
                    produktDoUsuniecia = null;
                }
            }
        });
        panel.add(listScroller);
        listScroller.updateUI();
        panel.updateUI();
    }

}
