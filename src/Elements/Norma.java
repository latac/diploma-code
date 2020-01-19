package Elements;

public class Norma {
    private float kcal;
    private float protein;
    private float carbohydrates;
    private float fat;
    private float marginesBledu = 0.05f;

    public Norma() {
        this.kcal = 980;
        this.protein = 36.75f;
        this.carbohydrates = 134.75f;
        this.fat = 32.67f;
    }

    public boolean czyKcalWPrzedziale(float kcal) { return this.kcal - marginesBledu*this.kcal < kcal && kcal < this.kcal + marginesBledu*this.kcal; }
    public boolean czyProteinWPrzedziale(float protein) { return this.protein - marginesBledu*this.protein < protein && protein < this.protein + marginesBledu*this.protein; }
    public boolean czyCarbohydratesWPrzedziale(float carbohydrates) { return this.carbohydrates - marginesBledu*this.carbohydrates < carbohydrates && carbohydrates < this.carbohydrates + marginesBledu*this.carbohydrates; }
    public boolean czyFatWPrzedziale(float fat) {
        return this.fat - marginesBledu*this.fat < fat && kcal < this.fat + marginesBledu*this.fat;
    }






}
