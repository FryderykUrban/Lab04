import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    private List<Product> productList = new ArrayList<>();

    public Recipe(String name,String description, int ID){
        this.name = name;
        this.description= description;
        this.ID= ID;


    }

}
