package data;


import Elements.Day;
import Elements.DayParser;
import Elements.MealParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DayDatabase {DataConnector connector;

    //obiekt tworzący połączenie z bazą danych.
    private Connection connection;
    //obiekt pozwalający tworzyć nowe wyrażenia SQL
    private PreparedStatement statement;
    //zapytanie SQL
    private String query;
    public DayDatabase(DataConnector connector) {
        this.connector = connector;
    }

    public Day PobierzDzien(int id) {
        String query = new DayParser().pobierzJeden();
        Day pobranyDzien = new Day();
        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery(query);


            while (result.next()) {
                // Get the values from the current row...
                pobranyDzien.setId(result.getInt(1));
                pobranyDzien.setName(result.getString(2));

            }
            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException  | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return pobranyDzien;
    }

    public List<Day> PobierzDni() {
        String query = new DayParser().pobierzWszystkie();
        List<Day> lista = new ArrayList<>();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);

            ResultSet result = statement.executeQuery(query);

            Day pobranyDzien;
            while (result.next()) {
                pobranyDzien = new Day();
                // Get the values from the current row...
                pobranyDzien.setId(result.getInt(1));
                pobranyDzien.setName(result.getString(2));
                lista.add(pobranyDzien);
            }
            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lista;
    }

    public boolean UtworzDzien(Day dzien) {
        String query = new DayParser().createSaveQuery(dzien);
        boolean wynik = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dzien.getName());
            int result = statement.executeUpdate();
            if(result == 1)
            {
                int candidateId = 0;
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    candidateId = rs.getInt(1);
                    wynik = true;
                }
                dzien.setId(candidateId);
            }

            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return wynik;
    }

    public boolean Usun(int id) {
        String query = new DayParser().Usun();
        List<Day> lista = new ArrayList<>();
        boolean result = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            int resultStatement = statement.executeUpdate();
            if(resultStatement == 1)
            {
                result = true;
            }

            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    public boolean Edytuj(Day dzien) {
        String query = new DayParser().Edytuj();
        List<Day> lista = new ArrayList<>();
        boolean wynik = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);

            statement.setString(1, dzien.getName());
            statement.setInt(2, dzien.getId());

            int result = statement.executeUpdate();
            if(result == 1)
            {
                int candidateId = 0;
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    candidateId = rs.getInt(1);
                    wynik = true;
                }
                dzien.setId(candidateId);
            }

            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return wynik;
    }



    public void DodajPosilekDoDnia(int idPosilku, Date dzien) {
        String query = new DayParser().dodajPosilekDoDnia();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, dzien);
            statement.setInt(2, idPosilku);

            statement.executeUpdate();

            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void UsunPosilekZDnia(int idPosilku, Date dzien) {
        String query = new DayParser().usunPosilekZDnia();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idPosilku);
            statement.setDate(2, dzien);

            statement.executeUpdate();

            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
