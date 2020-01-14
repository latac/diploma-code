package data;

import Elements.Dish;
import Elements.DishParser;
import Elements.Product;
import Elements.ProduktParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DishDatabase { DataConnector connector;

    //obiekt tworzący połączenie z bazą danych.
    private Connection connection;
    //obiekt pozwalający tworzyć nowe wyrażenia SQL
    private PreparedStatement statement;
    //zapytanie SQL
    private String query;
    public DishDatabase(DataConnector connector) {
        this.connector = connector;
    }

    public Dish PobierzDanie(int id) {
        String query = new DishParser().pobierzJeden();
        Dish pobraneDanie = new Dish();
        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery(query);


            while (result.next()) {
                // Get the values from the current row...
                pobraneDanie.setId(result.getInt(1));
                pobraneDanie.setName(result.getString(2));

            }
            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException  | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return pobraneDanie;
    }

    public List<Dish> PobierzDania() {
        String query = new DishParser().pobierzWszystkie();
        List<Dish> lista = new ArrayList<>();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);

            ResultSet result = statement.executeQuery(query);

            Dish pobraneDanie;
            while (result.next()) {
                pobraneDanie = new Dish();
                // Get the values from the current row...
                pobraneDanie.setId(result.getInt(1));
                pobraneDanie.setName(result.getString(2));
                lista.add(pobraneDanie);
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
    public List<Dish> PobierzDaniaZPosilku(int id) {
        String query = new DishParser().PobierzDaniaZPosilku();
        List<Dish> lista = new ArrayList<>();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();


            Dish pobraneDanie;
            while (result.next()) {
                pobraneDanie = new Dish();
                // Get the values from the current row...
                pobraneDanie.setId(result.getInt(1));
                pobraneDanie.setName(result.getString(2));

                lista.add(pobraneDanie);
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

    public boolean UtworzDanie(Dish danie) {
        String query = new DishParser().createSaveQuery(danie);
        boolean wynik = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, danie.getName());
            int result = statement.executeUpdate();
            if(result == 1)
            {
                int candidateId = 0;
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    candidateId = rs.getInt(1);
                    wynik = true;
                }
                danie.setId(candidateId);
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
        String query = new DishParser().Usun();
        List<Dish> lista = new ArrayList<>();
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

    public boolean Edytuj(Dish danie) {
        String query = new DishParser().Edytuj();
        List<Dish> lista = new ArrayList<>();
        boolean wynik = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);

            statement.setString(1, danie.getName());
            statement.setInt(2, danie.getId());

            int result = statement.executeUpdate();
            if(result == 1)
            {
                int candidateId = 0;
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    candidateId = rs.getInt(1);
                    wynik = true;
                }
                danie.setId(candidateId);
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
}

