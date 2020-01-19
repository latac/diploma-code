package data;

public class DataConnector {
    public final static String DBURL = "jdbc:mysql://127.0.0.1:3306/dieta?useUnicode=yes&characterEncoding=UTF-8";
    public final static String DBUSER = "root";
    public final static String DBPASS = "";
    public final static String DBDRIVER = "com.mysql.jdbc.Driver";




    private static DataConnector _instance;

    public static DataConnector Instance() {
        if (_instance == null)
            _instance = new DataConnector();

        return _instance;
    }

    private DataConnector() {}

    public ProduktDatabase Produkty() {
        return new ProduktDatabase(this);
    }
    public DishDatabase Dish() {
        return new DishDatabase(this);
    }


    public MealDatabase Meal() {
        return new MealDatabase(this);
    }

    public DayDatabase Day() {
        return new DayDatabase(this);
    }


}
