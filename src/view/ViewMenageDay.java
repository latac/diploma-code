package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenageDay extends JFrame{
    private JPanel panel;
    private JLabel nazwaDania;
    private JLabel kcal;
    private JLabel weglowodany;
    private JLabel bialka;
    private JLabel tluszcze;
    private JLabel podajPosilek;
    private JTextField znajdzPosilek;
    private JButton szukaj;
    private JButton dodaj;
    private JButton usun;
    private JButton aktualizuj;
    private JButton wroc;
    private JButton dodajPosilek;

    public ViewMenageDay() {
        super("Danie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        setVisible(true);

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
        nazwaDania = new JLabel("Dzień:");
        nazwaDania.setBounds(0, 10, 200, 25);
        panel.add(nazwaDania);
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

    private void wierszSzukaniaPosilku() {
        podajPosilek = new JLabel("Wpisz nazwę posiłku:");
        podajPosilek.setBounds(600,0,200,25);
        panel.add(podajPosilek);


        znajdzPosilek = new JTextField();
        znajdzPosilek.setBounds(600, 30, 200, 25);
        panel.add(znajdzPosilek);


        dodajPosilek = new JButton("+");
        dodajPosilek.setBounds(900,30,50,25);
        panel.add(dodajPosilek);
    }

}
