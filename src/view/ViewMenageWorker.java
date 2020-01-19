package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenageWorker extends JFrame  {

    private JPanel panel;
    private JButton ok;
    private JButton wroc;
    private JComboBox jednostkaOrganizacyjna;
    private String[] jednostkiOrganizacyjne = {"Przedszkole"};
    private JLabel kcal;
    private JLabel carbohydrates;
    private JLabel protein;
    private JLabel fat;

    public ViewMenageWorker() {
        super("Wybór normy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        przyciskOK();
        przyciskWroc();
        wyborJednostkiOrganizacyjnej();
        wierszKcal();
        wierszBialek();
        wierszWeglowodanow();
        wierszTluszczy();
        wierszInformacji();

        panel.updateUI();
    }

    private void wyborJednostkiOrganizacyjnej(){
        jednostkaOrganizacyjna = new JComboBox(jednostkiOrganizacyjne);
        jednostkaOrganizacyjna.setBounds(200,50,100,25);
        panel.add(jednostkaOrganizacyjna);
    }

    private void przyciskOK(){
        ok = new JButton("ok");
        ok.setBounds(150,400,100,25);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(ok);
    }

    private void przyciskWroc(){
        wroc = new JButton("wróć");
        wroc.setBounds(250,400,100,25);
        wroc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(wroc);
    }
    private void wierszInformacji() {
        kcal = new JLabel("Dla dzieci w wieku przedszkolnym przewidziana jest norma:");
        kcal.setBounds(200, 100, 500, 25);
        panel.add(kcal);
    }
    private void wierszKcal(){
        kcal = new JLabel("kcal: 980");
        kcal.setBounds(200,150,100,25);
        panel.add(kcal);
    }
    private void wierszBialek(){
        protein = new JLabel("biało: 36,75g");
        protein.setBounds(200,180,100,25);
        panel.add(protein);
    }
    private void wierszWeglowodanow(){
        carbohydrates = new JLabel("węglowodany: 134,75g");
        carbohydrates.setBounds(200,210,200,25);
        panel.add(carbohydrates);
    }
    private void wierszTluszczy(){
        fat = new JLabel("tłuszcze: 32,67");
        fat.setBounds(200,240,100,25);
        panel.add(fat);
    }
}
