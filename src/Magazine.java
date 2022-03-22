import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Magazine {
    private static Magazine object;

    private Map<Integer, Product> magazine;

    private Magazine(){
        this.magazine = new HashMap<Integer, Product>();
        readFromFileProducts();
    }

    public static Magazine getObject(){
        if(object == null){
            object = new Magazine();
        }
        return object;
    }
    public Map<Integer, Product> getMagazine(){
        return magazine;
    }

    public void addProduct(String name,float weight, int ID, String unit){
        if(magazine.get(ID)==null) {
            magazine.put(ID, new Product(name, weight, unit, ID));
        }else{
            throw new Error("Taki produkt juz został dodany");
        }
    }
    public void editProduct (String name,float weight, int ID, String unit) {
        magazine.get(ID).setName(name);
        magazine.get(ID).setWeight(weight);
        magazine.get(ID).setUnit(unit);
    }



    public void readFromFileProducts(){
        magazine= new HashMap<>();

        File file = new File("C:\\Users\\cukro\\IdeaProjects\\lab04\\src\\magazine");

        Scanner scanner = null;

        try{
            scanner = new Scanner(file);
            while(scanner.hasNext()){
                String[] temp= scanner.nextLine().split(";");

                magazine.put(Integer.parseInt(temp[0]),new Product(temp[1],Float.parseFloat(temp[2]),temp[3],Integer.parseInt(temp[0])));
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }

    }

    public void saveToFileProducts()  {
        PrintWriter save;
        try{
            save = new PrintWriter("C:\\Users\\cukro\\IdeaProjects\\lab04\\src\\magazine");
            for(Map.Entry<Integer, Product> entry:magazine.entrySet()){
                save.println(entry.getKey()+";"+entry.getValue().getName()+";"+entry.getValue().getWeight()+";"+entry.getValue().getUnit());

            }
            save.close();
        }
        catch (FileNotFoundException e ){
            System.out.println(e);
        }


    }

}