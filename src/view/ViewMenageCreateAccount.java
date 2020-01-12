package view;

import javax.swing.*;


public class ViewMenageCreateAccount extends JFrame {

    private JPanel panel;
    private JLabel imie;
    private JTextField name;
    private JLabel login;
    private JTextField email;
    private JLabel haslo;
    private JTextField password;
    private JButton ok;
    private JButton wroc;
    private JLabel powtorzHaslo;
    private JTextField powtorzPassword;



    public ViewMenageCreateAccount(){
        super("Tworzenie konta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        wierszImienia();
        wierszLoginu();
        wierszHasla();
        przyciskOK();
        przyciskWroc();


        panel.updateUI();

    }

    private void wierszImienia(){

        imie = new JLabel("imię:");
        imie.setBounds(100, 70, 200, 25);
        panel.add(imie);

        name = new JTextField();
        name.setBounds(200, 70, 200, 25);
        panel.add(name);
    }

    private void wierszLoginu() {
        login = new JLabel("email:");
        login.setBounds(100, 100, 200, 25);
        panel.add(login);

        email = new JTextField();
        email.setBounds(200, 100, 200, 25);
        panel.add(email);
    }

    private void wierszHasla(){
        haslo = new JLabel("hasło:");
        haslo.setBounds(100,140,200,25);
        panel.add(haslo);

        password = new JTextField();
        password.setBounds(200, 140, 200, 25);
        panel.add(password);

        powtorzHaslo = new JLabel("powtórz hasło:");
        powtorzHaslo.setBounds(100,170,200,25);
        panel.add(powtorzHaslo);

        powtorzPassword = new JTextField();
        powtorzPassword.setBounds(200, 170, 200, 25);
        panel.add(powtorzPassword);
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
