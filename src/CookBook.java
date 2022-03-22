import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CookBook {
    private static CookBook book;

    private Map<Integer, Recipe> cookbook;

    private CookBook() {
        this.cookbook = new HashMap<Integer, Recipe>();
        readFromFileRecipe();
    }

    public static CookBook getBook() {
        if (book == null) {
            book = new CookBook();
        }
        return book;
    }

    public Map<Integer, Recipe> getCookbook() {
        return cookbook;
    }

    public void addRecipe(String name, String description, int ID) {

        cookbook.put(ID, new Recipe(name, description, ID));
    }

    public void saveToFileNeededProducts(String products) {
        PrintWriter save;
        try {
            FileWriter fw = new FileWriter("C:\\Users\\cukro\\IdeaProjects\\lab04\\src\\productsneeded", true);
            save = new PrintWriter(fw);

            save.print(products+"\n");
            save.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void readFromFileNeededProducts(){

            File file = new File("C:\\Users\\cukro\\IdeaProjects\\lab04\\src\\productsneeded");
            Scanner scanner;
            try {
                scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    String[] temp = scanner.nextLine().split(";");
                    cookbook.get(Integer.parseInt(temp[0])).getProductList().add(new Product(temp[1],Float.parseFloat(temp[2]), temp[3],Integer.parseInt(temp[0])));
                   // book.getCookbook().get(Integer.parseInt(temp[0])).getProductList().add(new Product(temp[1],Float.parseFloat(temp[2]),Integer.parseInt(temp[3]), temp[4]));
                  //  book.getCookbook().put(Integer.parseInt(temp[0]),(new Product(temp[1],Float.parseFloat(temp[2]),Integer.parseInt(temp[3]), temp[4])));
                  //  CookBook.getBook().getCookbook().get(temp[0]).getProductList().add(new Product(temp[1],Float.parseFloat(temp[2]),Integer.parseInt(temp[3]), temp[4]));

                }
            } catch (FileNotFoundException err) {
                System.out.println(err);
            }
        }


   public void readFromFileRecipe(){
        cookbook= new HashMap<>();

        File file = new File("C:\\Users\\cukro\\IdeaProjects\\lab04\\src\\recipe");

        Scanner scanner = null;

       try{
           scanner = new Scanner(file);
           while(scanner.hasNext()){
               String[] temp= scanner.nextLine().split(";");
               cookbook.put(Integer.parseInt(temp[0]),new Recipe(temp[1],temp[2],Integer.parseInt(temp[3])));
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }

    }

    public void saveToFileRecipe()  {
        PrintWriter save;
        try{
            save = new PrintWriter("C:\\Users\\cukro\\IdeaProjects\\lab04\\src\\recipe");
            for(Map.Entry<Integer, Recipe> entry:cookbook.entrySet()){
                save.println(entry.getKey()+";"+entry.getValue().getName()+";"+entry.getValue().getDescription()+";"+entry.getValue().getID());

            }
            save.close();
        }
        catch (FileNotFoundException e ){
            System.out.println(e);
        }


    }

    }


