package Elements;

import data.DataConnector;

import java.sql.PreparedStatement;

public class ProduktParser {
    public String createSaveQuery(Product article) {
        String query = "";

        /**
         * Dodaj do tabeli "articles" wartości id, title i text.
         * id jest nullem, ponieważ pole id jest autoinkrementowane
         * przez bazę danych.
         * INSERT INTO articles VALUES (NULL, 'title', 'text');
         */
        return "insert into `product` VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

    }

    public String pobierzWszystkie() {
        return "select * from `product`";
    }

    public String pobierzJeden() {
        return "select * from `product` where id = ?";
    }

    public String Usun() {
        return "delete from `product` where id = ?";
    }

    public String Edytuj() {
        return "update `product` SET VALUES name = ?, unitOfMeasuremen = ?, referenceValu = ?, kcal = ?, carbohydrate = ?, protein = ?, fat = ? where id = ?";
    }
    public String PobierzProduktyZDania(){
        return "select p.*, di.amountOfProduct from dishingredients di left join product p on di.idProduct = p.id left join dish d on di.idDish = d.id where d.id = 1;";
    }
}
