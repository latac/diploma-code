package Elements;

import data.DataConnector;

import java.sql.PreparedStatement;

public class ProduktParser {
    public String createSaveQuery(Product article) {
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
        return "update `product` SET name = ?, unitOfMeasurement = ?, referenceValue = ?, kcal = ?, carbohydrates = ?, protein = ?, fat = ? where id = ?";
    }
    public String PobierzProduktyZDania(){
        return "select p.*, di.amountOfProduct from dishingredients as di left join product as p on di.idProduct = p.id left join dish d on di.idDish = d.id where d.id = ?";
    }

    public String UsunPowiazane() {
        return "delete from `dishingredients` where idProduct = ?";
    }
}
