package Elements;

public class Norma {
    private float kcal;
    private float protein;
    private float carbohydrates;
    private float fat;

    public Norma() {
        this.kcal = 980;
        this.protein = 36.75f;
        this.carbohydrates = 134.75f;
        this.fat = 32.67f;
    }

    public float getKcal() {
        return kcal;
    }

    public float getProtein() {
        return protein;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public float getFat() {
        return fat;
    }

}
