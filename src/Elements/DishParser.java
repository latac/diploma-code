package Elements;

public class DishParser {
    public String createSaveQuery(Dish article) {
        String query = "";

        /**
         * Dodaj do tabeli "articles" wartości id, title i text.
         * id jest nullem, ponieważ pole id jest autoinkrementowane
         * przez bazę danych.
         * INSERT INTO articles VALUES (NULL, 'title', 'text');
         */
        return "insert into `dish` VALUES (null, ?)";

    }

    public String pobierzWszystkie() {
        return "select * from `dish`";
    }

    public String pobierzJeden() {
        return "select * from `dish` where id = ?";
    }

    public String Usun() {
        return "delete from `dish` where id = ?";
    }


    public String Edytuj() {
        return "update `dish` SET VALUES name = ?, kcal = ?, carbohydrate = ?, protein = ?, fat = ? where id = ?";
    }
}
