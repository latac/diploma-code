package view;

import javax.swing.*;

public class ViewMenageWorker extends JFrame  {

    private JPanel panel;
    private JButton ok;
    private JButton wroc;
    private JComboBox jednostkaOrganizacyjna;
    private String[] jednostkiOrganizacyjne = {"Przedszkole"};

    public ViewMenageWorker() {
        super("Przypisanie jednostki organizacyjnej");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        przyciskOK();
        przyciskWroc();
        wyborJednostkiOrganizacyjnej();

        panel.updateUI();
    }

    private void wyborJednostkiOrganizacyjnej(){
        jednostkaOrganizacyjna = new JComboBox(jednostkiOrganizacyjne);
        jednostkaOrganizacyjna.setBounds(200,100,100,25);
        panel.add(jednostkaOrganizacyjna);
    }

    private void przyciskOK(){
        ok = new JButton("ok");
        ok.setBounds(150,200,100,25);
        panel.add(ok);
    }

    private void przyciskWroc(){
        wroc = new JButton("wróć");
        wroc.setBounds(250,200,100,25);
        panel.add(wroc);
    }
}
