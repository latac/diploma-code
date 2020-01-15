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
    private JList listaDan;
    private List<Dish> arrayOfDish;
    private JList listaProduktow;
    private List<Product> arrayOfProducts;
    private JComboBox listaWyboruProduktow;
    private String[] wybranyProdukt={"Produkt 1", "Produkt 2"};

    ViewMenageDish() {
        super("Danie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
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
       //wierszZListaProduktow();

        listaProduktow = new JList();
        listaProduktow.setBounds(600, 100, 300, 300);

        panel.add(listaProduktow);

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

    private void wierszSzukaniaProduktu() {
        podajProdukt = new JLabel("Wpisz nazwę produktu:");
        podajProdukt.setBounds(600, 0, 200, 25);
        panel.add(podajProdukt);

        podajIloscProdukty = new JLabel("Podaj ilość:");
        podajIloscProdukty.setBounds(800, 0, 200, 25);
        panel.add(podajIloscProdukty);

/*        znajdzProdukt = new JTextField();
        znajdzProdukt.setBounds(600, 30, 200, 25);
        panel.add(znajdzProdukt);*/


        listaWyboruProduktow = new JComboBox<>();
        listaWyboruProduktow.setBounds(600, 30, 100, 25);
        listaWyboruProduktow.addItem(wybranyProdukt);
        panel.add(listaWyboruProduktow);

        dodajProdukt = new JButton("+");
        dodajProdukt.setBounds(900, 30, 50, 25);
        panel.add(dodajProdukt);
    }

    private void wierszListyDan() {

        DataConnector connector = DataConnector.Instance();
        DishDatabase danieDatabase = new DishDatabase(connector);
        arrayOfDish = danieDatabase.PobierzDania();
        DefaultListModel<Dish> model = new DefaultListModel<>();

        for (int i = 0; i < arrayOfDish.size(); i++) {
            model.add(i, arrayOfDish.get(i));
        }
        listaDan = new JList(model);
        listaDan.setBounds(100, 300, 300, 300);

        listaDan.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = listaDan.getSelectedIndex();
                if (id != -1) {
                    int idDish = arrayOfDish.get(id).getId();
                    List<Product> produkty = DataConnector.Instance().Produkty().PobierzProduktyZDania(idDish);
                    wierszZListaProduktow(produkty);

                    //Dish danie = arrayOfDish.get(id);
                    float sumaKalorii = 0f;
                    float sumaBialek = 0f;
                    float sumaWeglowodanow = 0f;
                    float sumaTluszczy = 0f;

                    for (Product p : produkty) {
                            sumaKalorii += p.getKcal();
                            sumaBialek += p.getProtein();
                            sumaWeglowodanow += p.getCarbohydrates();
                            sumaTluszczy += p.getFat();
                    }

                    wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                    wyliczoneBialka.setText(String.valueOf(sumaBialek));
                    wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                    wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));
                }
            }
        });

        panel.add(listaDan);

    }

    private void wierszZListaProduktow(List<Product> produkty) {
        panel.remove(listaProduktow);
        DefaultListModel<Product> model = new DefaultListModel<>();

        for (int i = 0; i < produkty.size(); i++) {
            model.add(i, produkty.get(i));
        }
        listaProduktow = new JList(model);
        listaProduktow.setBounds(600, 100, 300, 300);
        panel.add(listaProduktow);

        listaProduktow.updateUI();
        panel.updateUI();
    }

}
