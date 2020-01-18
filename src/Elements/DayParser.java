package Elements;

public class DayParser {
    public String createSaveQuery(Day article) {
        String query = "";

        /**
         * Dodaj do tabeli "articles" wartości id, title i text.
         * id jest nullem, ponieważ pole id jest autoinkrementowane
         * przez bazę danych.
         * INSERT INTO articles VALUES (NULL, 'title', 'text');
         */
        return "insert into `day` VALUES (null, ?)";

    }

    public String pobierzWszystkie() {
        return "select * from `day`";
    }

    public String pobierzJeden() {
        return "select * from `day` where id = ?";
    }

    public String Usun() {
        return "delete from `day` where id = ?";
    }


    public String Edytuj() {
        return "update `day` SET VALUES name = ? where id = ?";
    }



    public String dodajPosilekDoDnia() {
        return "insert into `dayingredients` VALUES (?, ?)";
    }
    public String usunPosilekZDnia() {
        return "delete from `dayingredients` where idMeal = ? and idDay = ?";
    }
}
