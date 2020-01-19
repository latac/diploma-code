package view;

import Elements.Product;
import data.DataConnector;
import data.ProduktDatabase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewMenageProduct extends JFrame {

    private JPanel panel;
    private JLabel nazwaProduktu;
    private JTextField podanaNazwaProduktu;
    private JLabel wartoscReferencyjna;
    private JTextField podanaWartoscReferencyjna;
    private JLabel kcal;
    private JTextField podanekcal;
    private JLabel weglowodany;
    private JTextField podaneWeglowodany;
    private JLabel bialka;
    private JTextField podaneBialka;
    private JLabel tluszcze;
    private JTextField podaneTluszcze;
    private JButton dodaj;
    private JButton usun;
    private JButton aktualizuj;
    private JButton wroc;
    private JComboBox jednostka;
    private JList listaProduktow;
    private String[] jednostki = {"g", "ml", "szt."};
    private List<Product> arrayOfProducts;
    private Product wybranyProduktZListy;
    DefaultListModel<String> model;

    public ViewMenageProduct() {
        super("Produkt");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        wierszNazwyProduktu();
        wierszWartosciReferencyjnej();
        wierszKcal();
        wierszBialka();
        wierszWeglowodanow();
        wierszTluszczy();
        przyciskaktualizuj();
        przyciskDodaj();
        przyciskUsun();
        przyciskWroc();
        wierszListyProduktow();


        panel.updateUI();
    }

    private void wierszNazwyProduktu() {
        nazwaProduktu = new JLabel("nazwa produktu");
        nazwaProduktu.setBounds(0, 10, 200, 25);
        panel.add(nazwaProduktu);

        podanaNazwaProduktu = new JTextField();
        podanaNazwaProduktu.setBounds(200, 10, 200, 25);
        panel.add(podanaNazwaProduktu);
    }

    private void wierszWartosciReferencyjnej() {
        wartoscReferencyjna = new JLabel("wartość referencyjna");
        wartoscReferencyjna.setBounds(0, 40, 200, 25);
        panel.add(wartoscReferencyjna);

        podanaWartoscReferencyjna = new JTextField();
        podanaWartoscReferencyjna.setBounds(200, 40, 200, 25);
        panel.add(podanaWartoscReferencyjna);

        jednostka = new JComboBox(jednostki);
        jednostka.setBounds(400, 40, 100, 25);
        panel.add(jednostka);

    }

    private void wierszKcal() {
        kcal = new JLabel("kcal");
        kcal.setBounds(0, 70, 200, 25);
        panel.add(kcal);

        podanekcal = new JTextField();
        podanekcal.setBounds(200, 70, 200, 25);
        panel.add(podanekcal);
    }

    private void wierszWeglowodanow() {
        weglowodany = new JLabel("węglowodany");
        weglowodany.setBounds(0, 100, 200, 25);
        panel.add(weglowodany);

        podaneWeglowodany = new JTextField();
        podaneWeglowodany.setBounds(200, 100, 200, 25);
        panel.add(podaneWeglowodany);
    }

    private void wierszBialka() {
        bialka = new JLabel("białka");
        bialka.setBounds(0, 130, 200, 25);
        panel.add(bialka);

        podaneBialka = new JTextField();
        podaneBialka.setBounds(200, 130, 200, 25);
        panel.add(podaneBialka);
    }

    private void wierszTluszczy() {
        tluszcze = new JLabel("tłuszcze");
        tluszcze.setBounds(0, 160, 200, 25);
        panel.add(tluszcze);

        podaneTluszcze = new JTextField();
        podaneTluszcze.setBounds(200, 160, 200, 25);
        panel.add(podaneTluszcze);
    }

    private void przyciskDodaj() {
        dodaj = new JButton("dodaj");
        dodaj.setBounds(100, 200, 100, 25);
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product p = new Product();
                p.setName(podanaNazwaProduktu.getText());
                p.setReferenceValue(Integer.valueOf(podanaWartoscReferencyjna.getText()));
                p.setUnitOfMeasurement(jednostka.getSelectedItem().toString());
                p.setKcal(Float.valueOf(podanekcal.getText()));
                p.setCarbohydrates(Float.valueOf(podaneWeglowodany.getText()));
                p.setProtein(Float.valueOf(podaneBialka.getText()));
                p.setFat(Float.valueOf(podaneTluszcze.getText()));

                DataConnector.Instance().Produkty().UtworzProdukt(p);

                arrayOfProducts.add(p);

                arrayOfProducts.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                listaProduktow.setListData(arrayOfProducts.toArray());
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
                if (wybranyProduktZListy != null) {
                    DataConnector.Instance().Produkty().Usun(wybranyProduktZListy.getId());
                    arrayOfProducts.remove(wybranyProduktZListy);
                    listaProduktow.setListData(arrayOfProducts.toArray());
                }
            }
        });
        panel.add(usun);
    }

    private void przyciskaktualizuj() {

        aktualizuj = new JButton("aktualizuj");
        aktualizuj.setBounds(300, 200, 100, 25);

        aktualizuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wybranyProduktZListy != null) {
                    int pozycjaWLIscie = arrayOfProducts.indexOf(wybranyProduktZListy);

                    wybranyProduktZListy.setName(podanaNazwaProduktu.getText());
                    wybranyProduktZListy.setReferenceValue(Integer.valueOf(podanaWartoscReferencyjna.getText()));
                    wybranyProduktZListy.setUnitOfMeasurement(jednostka.getSelectedItem().toString());
                    wybranyProduktZListy.setKcal(Float.valueOf(podanekcal.getText()));
                    wybranyProduktZListy.setCarbohydrates(Float.valueOf(podaneWeglowodany.getText()));
                    wybranyProduktZListy.setProtein(Float.valueOf(podaneBialka.getText()));
                    wybranyProduktZListy.setFat(Float.valueOf(podaneTluszcze.getText()));

                    DataConnector.Instance().Produkty().Edytuj(wybranyProduktZListy);
                    //arrayOfProducts.remove(wybranyProduktZListy);
                    listaProduktow.setListData(arrayOfProducts.toArray());
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

    public void UstawListe() {
        model = new DefaultListModel<>();

         arrayOfProducts.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (int i = 0; i < arrayOfProducts.size(); i++) {
            model.add(i, arrayOfProducts.get(i).getName());
        }


        listaProduktow = new JList(model);
        listaProduktow.setBounds(100, 300, 200, 200);
        listaProduktow.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //listaProduktow.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaProduktow.setVisibleRowCount(-1);
//        panel.add(listaProduktow);

        JScrollPane listScroller = new JScrollPane();


        listScroller.setViewportView(listaProduktow);
        listScroller.setVisible(true);
        listScroller.setBounds(100, 300, 200, 200);

        listScroller.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listScroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        listScroller.setPreferredSize(new Dimension(400, 400));

        //list.ensureIndexIsVisible(index);/

        listaProduktow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = listaProduktow.getSelectedIndex();
                if (id != -1) {
                    wybranyProduktZListy = arrayOfProducts.get(id);
                    podanaNazwaProduktu.setText(wybranyProduktZListy.getName());
                    podanaWartoscReferencyjna.setText(String.valueOf(wybranyProduktZListy.getReferenceValue()));
                    podanekcal.setText(String.valueOf(wybranyProduktZListy.getKcal()));
                    podaneBialka.setText(String.valueOf(wybranyProduktZListy.getProtein()));
                    podaneWeglowodany.setText(String.valueOf(wybranyProduktZListy.getCarbohydrates()));
                    podaneTluszcze.setText(String.valueOf(wybranyProduktZListy.getFat()));
                } else {
                    wybranyProduktZListy = null;
                }
            }
        });
        //listScroller.add(listaProduktow);
        panel.add(listScroller);
        panel.updateUI();
        //panel.updateUI();

    }

    private void wierszListyProduktow() {

        DataConnector connector = DataConnector.Instance();
        ProduktDatabase produktDatabase = new ProduktDatabase(connector);
        arrayOfProducts = produktDatabase.PobierzProdukty();
        UstawListe();


    }

}