package data;

import Elements.DishParser;
import Elements.Product;
import Elements.ProduktParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DishDatabase {
    DataConnector connector;

    //obiekt tworzący połączenie z bazą danych.
    private Connection connection;
    //obiekt pozwalający tworzyć nowe wyrażenia SQL
    private PreparedStatement statement;
    //zapytanie SQL
    private String query;
    public DishDatabase(DataConnector connector) {
        this.connector = connector;
    }

    public Product PobierzDanie(int id) {
        String query = new DishParser().pobierzJeden();
        Product pobraneDanie =new Product();
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
                pobraneDanie.setKcal(result.getInt(5));
                pobraneDanie.setCarbohydrates(result.getInt(6));
                pobraneDanie.setProtein(result.getInt(7));
                pobraneDanie.setFat(result.getInt(8));

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

    public List<Product> PobierzProdukty() {
        String query = new ProduktParser().pobierzWszystkie();
        List<Product> lista = new ArrayList<>();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);

            ResultSet result = statement.executeQuery(query);

            Product pobranyProdukt;
            while (result.next()) {
                pobranyProdukt = new Product();
                // Get the values from the current row...
                pobranyProdukt.setId(result.getInt(1));
                pobranyProdukt.setName(result.getString(2));
                pobranyProdukt.setUnitOfMeasurement(result.getString(3));
                pobranyProdukt.setReferenceValue(result.getInt(4));
                pobranyProdukt.setKcal(result.getInt(5));
                pobranyProdukt.setCarbohydrates(result.getInt(6));
                pobranyProdukt.setProtein(result.getInt(7));
                pobranyProdukt.setFat(result.getInt(8));
                lista.add(pobranyProdukt);
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

    public boolean UtworzProdukt(Product produkt) {
        String query = new ProduktParser().createSaveQuery(produkt);
        boolean wynik = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, produkt.getName());
            statement.setString(2, produkt.getUnitOfMeasurement());
            statement.setInt(3, produkt.getReferenceValue());
            statement.setFloat(4, produkt.getKcal());
            statement.setFloat(5, produkt.getCarbohydrates());
            statement.setFloat(6, produkt.getProtein());
            statement.setFloat(7, produkt.getFat());

            int result = statement.executeUpdate();
            if(result == 1)
            {
                int candidateId = 0;
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    candidateId = rs.getInt(1);
                    wynik = true;
                }
                produkt.setId(candidateId);
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
        String query = new ProduktParser().Usun();
        List<Product> lista = new ArrayList<>();
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

    public boolean Edytuj(Product produkt) {
        String query = new ProduktParser().Edytuj();
        List<Product> lista = new ArrayList<>();
        boolean wynik = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);

            statement.setString(1, produkt.getName());
            statement.setString(2, produkt.getUnitOfMeasurement());
            statement.setInt(3, produkt.getReferenceValue());
            statement.setFloat(4, produkt.getKcal());
            statement.setFloat(5, produkt.getCarbohydrates());
            statement.setFloat(6, produkt.getProtein());
            statement.setFloat(7, produkt.getFat());
            statement.setInt(8, produkt.getId());

            int result = statement.executeUpdate();
            if(result == 1)
            {
                int candidateId = 0;
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    candidateId = rs.getInt(1);
                    wynik = true;
                }
                produkt.setId(candidateId);
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

