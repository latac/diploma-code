package view;

import Elements.Dish;
import Elements.Product;
import data.DataConnector;
import data.DishDatabase;
import data.ProduktDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ViewMenageDish extends JFrame implements MouseListener {
    private JPanel panel;
    private JLabel nazwaDania;
    private JLabel kcal;
    private JLabel weglowodany;
    private JLabel bialka;
    private JLabel tluszcze;
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

        znajdzProdukt = new JTextField();
        znajdzProdukt.setBounds(600, 30, 200, 25);
        panel.add(znajdzProdukt);

        iloscProduktu = new JTextField();
        iloscProduktu.setBounds(800, 30, 100, 25);
        panel.add(iloscProduktu);

        dodajProdukt = new JButton("+");
        dodajProdukt.setBounds(900, 30, 50, 25);
        panel.add(dodajProdukt);
    }

    private void wierszListyDan() {

        DataConnector connector = DataConnector.Instance();
        DishDatabase danieDatabase = new DishDatabase(connector);
        arrayOfDish = danieDatabase.PobierzDania();
        DefaultListModel<String> model = new DefaultListModel<>();

        for (int i = 0; i < arrayOfDish.size(); i++) {
            model.add(i, arrayOfDish.get(i).getName());
        }
        listaDan = new JList(model);
        listaDan.setBounds(100, 300, 300, 300);
        panel.add(listaDan);

    }

    private void wierszZListaProduktow() {
        listaProduktow = new JList();
        listaProduktow.setBounds(600, 100, 300, 300);
        panel.add(listaProduktow);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
//        DataConnector connector = DataConnector.Instance();
//        ProduktDatabase produktDatabase = new ProduktDatabase(connector);
//        arrayOfProducts = produktDatabase.PobierzProdukty();
//        model = new DefaultListModel<>();
//
//        for(int i = 0; i < arrayOfProducts.size(); i++){
//            model.add(i , arrayOfProducts.get(i).getName());
//        }
//        listaProduktow = new JList(model);
//        listaProduktow.setBounds(100,300,300,300);
//        panel.add(listaProduktow);
//    }
        DataConnector connector = DataConnector.Instance();
        ProduktDatabase produktDatabase = new ProduktDatabase(connector);
        arrayOfProducts = produktDatabase.PobierzProdukty();
        DefaultListModel<String> model = new DefaultListModel<>();

        for (int i = 0; i < arrayOfProducts.size(); i++) {
            model.add(i, arrayOfProducts.get(i).getName());
        }
        listaProduktow = new JList(model);
        listaProduktow.setBounds(100,300,300,300);
        panel.add(listaProduktow);

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
}
