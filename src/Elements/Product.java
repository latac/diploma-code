package Elements;

public class Product {

    private String name;
    private String unitOfMeasurement;
    private int referenceValue;
    private float kcal;
    private float carbohydrates;
    private float protein;
    private float fat;
    private int id;

    public Product() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public void setReferenceValue(int referenceValue) {
        this.referenceValue = referenceValue;
    }

    public void setKcal(float kcal) {
        this.kcal = kcal;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmountOfProduct(float amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

    private float amountOfProduct;

    public String getName() {
        return name;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public int getReferenceValue() {
        return referenceValue;
    }

    public float getKcal() {
        return kcal;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public float getProtein() {
        return protein;
    }

    public float getFat() {
        return fat;
    }

    public int getId() {
        return id;
    }

    public float getAmountOfProduct() {
        return amountOfProduct;
    }

    public float wyliczIloscProduktu(){return amountOfProduct/referenceValue;}

    public Product(String name, String unitOfMeasurement, int referenceValue, float kcal, float carbohydrates, float protein, float fat) {

    }

    @Override
    public String toString() {
        return name;
    }
}
