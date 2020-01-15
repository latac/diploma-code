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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JList listaDni;
    private JList listaPosilkow;

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



        listaPosilkow = new JList();
        listaPosilkow.setBounds(600, 100, 300, 300);

        panel.add(listaPosilkow);


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


        znajdzPosilek = new JTextField();
        znajdzPosilek.setBounds(600, 30, 200, 25);
        panel.add(znajdzPosilek);


        dodajPosilek = new JButton("+");
        dodajPosilek.setBounds(900,30,50,25);
        panel.add(dodajPosilek);
    }



    private void wierszZListyPosilkow(List<Meal> posilki) {
        panel.remove(listaPosilkow);
        DefaultListModel<Meal> model = new DefaultListModel<>();

        for (int i = 0; i < posilki.size(); i++) {
            model.add(i, posilki.get(i));
        }
        listaPosilkow = new JList(model);
        listaPosilkow.setBounds(600, 100, 300, 300);
        panel.add(listaPosilkow);

        listaDni.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = listaDni.getSelectedIndex();
                if (id != -1) {
                    wierszZListyPosilkow(posilki);

                    float sumaKalorii = 0f;
                    float sumaBialek = 0f;
                    float sumaWeglowodanow = 0f;
                    float sumaTluszczy = 0f;

                    for (Meal m: posilki) {
                        int idPosilku = m.getId();
                        List<Dish> dania = DataConnector.Instance().Dish().PobierzDaniaZPosilku(idPosilku);

                        for (Dish d : dania) {
                            int idDania = d.getId();
                            List<Product> produkty = DataConnector.Instance().Produkty().PobierzProduktyZDania(idDania);
                            for (Product p : produkty) {
                                sumaKalorii += p.getKcal();
                                sumaBialek += p.getProtein();
                                sumaWeglowodanow += p.getCarbohydrates();
                                sumaTluszczy += p.getFat();
                            }

                        }
                    }


                    wyliczoneKcal.setText(String.valueOf(sumaKalorii));
                    wyliczoneBialka.setText(String.valueOf(sumaBialek));
                    wyliczoneWeglowodany.setText(String.valueOf(sumaWeglowodanow));
                    wyliczoneTluszcze.setText(String.valueOf(sumaTluszczy));
                }
            }
        });

        listaPosilkow.updateUI();
        panel.updateUI();
    }
}
