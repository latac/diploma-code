package Elements;

public class MealParser {
    public String createSaveQuery(Dish article) {
    String query = "";

    /**
     * Dodaj do tabeli "articles" wartości id, title i text.
     * id jest nullem, ponieważ pole id jest autoinkrementowane
     * przez bazę danych.
     * INSERT INTO articles VALUES (NULL, 'title', 'text');
     */
    return "insert into `product` VALUES (null, ?, ?, ?, ?, ?)";

}

    public String pobierzWszystkie() {
        return "select * from `meal`";
    }

    public String pobierzJeden() {
        return "select * from `meal` where id = ?";
    }

    public String usun() {
        return "delete from `meal` where id = ?";
    }


    public String edytuj() {
        return "update `meal` SET VALUES name = ? where id = ?";
    }
}
