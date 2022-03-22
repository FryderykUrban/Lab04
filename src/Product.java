public class Product
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String name;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    private String unit;
    private int ID;
    private float weight;

    public float getWeight() {
        return weight;
    }

    public Product(String name, float weight, String unit, int ID){
        this.name = name;
        this.weight = weight;
        this.ID = ID;
        this.unit=unit;
    }



    @Override

    public String toString(){
        return this.name+", "+this.weight+", "+this.unit;
    }
}