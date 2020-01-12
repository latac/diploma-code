package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenageMeal extends JFrame {
    private JPanel panel;
    private JLabel nazwaPosilku;
    private JLabel kcal;
    private JLabel weglowodany;
    private JLabel bialka;
    private JLabel tluszcze;
    private JLabel podajNazweDania;
    private JTextField podanaNazwaPosilku;
    private JTextField znajdzDanie;
    private JButton szukaj;
    private JButton dodaj;
    private JButton usun;
    private JButton aktualizuj;
    private JButton wroc;
    private JButton dodajDanie;


    public ViewMenageMeal() {
        super("Posiłek");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
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

    private void wierszSzukaniaDania() {
        podajNazweDania = new JLabel("Wpisz nazwę dania:");
        podajNazweDania.setBounds(600,0,200,25);
        panel.add(podajNazweDania);


        znajdzDanie = new JTextField();
        znajdzDanie.setBounds(600, 30, 200, 25);
        panel.add(znajdzDanie);

        dodajDanie = new JButton("+");
        dodajDanie.setBounds(900,30,50,25);
        panel.add(dodajDanie);
    }

}