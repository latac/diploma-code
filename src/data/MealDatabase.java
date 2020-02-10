package data;


import Elements.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealDatabase {
    DataConnector connector;

    //obiekt tworzący połączenie z bazą danych.
    private Connection connection;
    //obiekt pozwalający tworzyć nowe wyrażenia SQL
    private PreparedStatement statement;
    //zapytanie SQL
    private String query;
    public MealDatabase(DataConnector connector) {
        this.connector = connector;
    }

/*    public Meal PobierzPosilek(int id) {
        String query = new MealParser().pobierzJeden();
        Meal pobranyPosilek = new Meal();
        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery(query);


            while (result.next()) {
                // Get the values from the current row...
                pobranyPosilek.setId(result.getInt(1));
                pobranyPosilek.setName(result.getString(2));

            }
            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException  | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return pobranyPosilek;
    }*/

    public List<Meal> PobierzPosilki() {
        String query = new MealParser().pobierzWszystkie();
        List<Meal> lista = new ArrayList<>();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);

            ResultSet result = statement.executeQuery(query);

            Meal pobranyPosilek;
            while (result.next()) {
                pobranyPosilek = new Meal();
                // Get the values from the current row...
                pobranyPosilek.setId(result.getInt(1));
                pobranyPosilek.setName(result.getString(2));
                lista.add(pobranyPosilek);
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

    public boolean UtworzPosilek(Meal posilek) {
        String query = new MealParser().createSaveQuery(posilek);
        boolean wynik = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, posilek.getName());
            int result = statement.executeUpdate();
            if(result == 1)
            {
                int candidateId = 0;
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    candidateId = rs.getInt(1);
                    wynik = true;
                }
                posilek.setId(candidateId);
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
        String queryPowiazane = new MealParser().UsunPowiazane();

        String query = new MealParser().usun();
        boolean result = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);

            statement = connection.prepareStatement(queryPowiazane);
            statement.setInt(1, id);
            statement.executeUpdate();

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

    public boolean Edytuj(Meal posilek) {
        String query = new MealParser().edytuj();
        boolean wynik = false;

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);

            statement.setString(1, posilek.getName());
            statement.setInt(2, posilek.getId());

            int result = statement.executeUpdate();


            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return wynik;
    }


    public void DodajDanieDoPosilku(int idPosilku, int idDanie) {
        String query = new MealParser().dodajDanieDoPosilku();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idPosilku);
            statement.setInt(2, idDanie);

            statement.executeUpdate();

            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void UsunDanieZPosilku(int idDanie, int idPosilku) {
        String query = new MealParser().usunDanieZPosilku();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idDanie);
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

    public List<Meal> PobierzPosilekZDnia(Date dzien) {
        String query = new DayParser().pobierzJeden();
        List<Meal> pobraneDania = new ArrayList<>();
        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);
            statement = connection.prepareStatement(query);
            statement.setDate(1, dzien);
            ResultSet result = statement.executeQuery();

            Meal pobranyPosilek;
            while (result.next()) {
                pobranyPosilek = new Meal();
                // Get the values from the current row...
                pobranyPosilek.setId(result.getInt(1));
                pobranyPosilek.setName(result.getString(2));
                pobraneDania.add(pobranyPosilek);
            }
            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException  | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return pobraneDania;
    }

    public void UsunPosilekZDnia(int idMeal, Date date) {
        String query = new DayParser().usunPosilekZDnia();

        try {
            Class.forName(connector.DBDRIVER).newInstance();
            connection = DriverManager.getConnection(connector.DBURL, connector.DBUSER, connector.DBPASS);

            statement = connection.prepareStatement(query);
            statement.setInt(1, idMeal);
            statement.setDate(2, date);
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
