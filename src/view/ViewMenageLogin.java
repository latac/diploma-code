package view;

import javax.swing.*;


public class ViewMenageLogin extends JFrame {

    private JPanel panel;
    private JLabel login;
    private JTextField email;
    private JLabel haslo;
    private JTextField password;
    private JButton zaloguj;
    private JButton stworzKonto;
    private JButton niePamietamHasla;



    public ViewMenageLogin(){
        super("Logowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        wierszLoginu();
        wierszHasla();
        przyciskZaloguj();
        przyciskStworzKonto();
        przyciskOdzyskiwaniaHasla();



        panel.updateUI();

    }

    private void wierszLoginu() {
        login = new JLabel("emial:");
        login.setBounds(150, 100, 200, 25);
        panel.add(login);

        email = new JTextField();
        email.setBounds(200, 100, 200, 25);
        panel.add(email);
    }

    private void wierszHasla(){
        haslo = new JLabel("hasło:");
        haslo.setBounds(150,140,200,25);
        panel.add(haslo);

        password = new JTextField();
        password.setBounds(200, 140, 200, 25);
        panel.add(password);
    }

    private void przyciskZaloguj(){
        zaloguj = new JButton("zaloguj");
        zaloguj.setBounds(100,170,200,25);
        panel.add(zaloguj);
    }

    private void przyciskStworzKonto(){
        stworzKonto = new JButton("stwórz konto");
        stworzKonto.setBounds(300,170,200,25);
        panel.add(stworzKonto);
    }

    private void przyciskOdzyskiwaniaHasla(){
        niePamietamHasla = new JButton("zapomniałem hasła");
        niePamietamHasla.setBounds(200,200,200,25);
        panel.add(niePamietamHasla);
    }
}
