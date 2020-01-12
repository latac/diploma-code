package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton szukaj;
    private JButton dodaj;
    private JButton usun;
    private JButton aktualizuj;
    private JButton wroc;
    private JComboBox jednostka;
    private String[] jednostki = {"g", "ml", "szt."};

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
        przyciskSzukaj();
        przyciskUsun();
        przyciskWroc();


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
        jednostka.setBounds(400,40,100,25);
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

    private void przyciskaktualizuj() {

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

}