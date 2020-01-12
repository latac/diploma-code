package Elements;

public class DecadeParser {
    public String createSaveQuery(Decade article) {
        String query = "";

        /**
         * Dodaj do tabeli "articles" wartości id, title i text.
         * id jest nullem, ponieważ pole id jest autoinkrementowane
         * przez bazę danych.
         * INSERT INTO articles VALUES (NULL, 'title', 'text');
         */
        return "insert into `decade` VALUES (null, ?)";

    }

    public String pobierzWszystkie() {
        return "select * from `decade`";
    }

    public String pobierzJeden() {
        return "select * from `decade` where id = ?";
    }

    public String Usun() {
        return "delete from `decade` where id = ?";
    }


    public String Edytuj() {
        return "update `decade` SET VALUES name = ? where id = ?";
    }
}
