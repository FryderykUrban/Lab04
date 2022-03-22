import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class MainFrame extends JFrame implements ActionListener {

    JButton bAddProduct, bRefresh, bAddRecipe;
    JTextArea taProduct, taRecipe,taRecipe2;
    JLabel lTProduct,lTRecipe, lTRecipe2;
    JComboBox cChooseRecipe;


    public MainFrame() {
        setSize(500, 300);
        setTitle("Program");
        setLayout(null);
        bAddProduct = new JButton("Dodaj/edytuj produkt");
        bAddProduct.setBounds(10, 20, 160, 20);
        add(bAddProduct);
        bAddProduct.addActionListener(this);

        bAddRecipe= new JButton("Dodaj przepis");
        bAddRecipe.setBounds(180, 20, 150, 20);
        add(bAddRecipe);
        bAddRecipe.addActionListener(this);

        lTRecipe = new JLabel("Składniki przepis");
        lTRecipe.setBounds(180,45,120,20);
        lTRecipe.setVisible(true);
        add(lTRecipe);

        lTRecipe2 = new JLabel("Przepisy które możesz zrealizować");
        lTRecipe2.setBounds(180,115,250,20);
        lTRecipe2.setVisible(true);
        add(lTRecipe2);

        taRecipe2 = new JTextArea();
        JScrollPane spRecipe2 = new JScrollPane(taRecipe2);
        spRecipe2.setBounds(180, 135, 300, 55);
        add(spRecipe2);

        lTProduct = new JLabel("ID  NAZWA  ILOŚĆ");
        lTProduct.setBounds(40,45,120,20);
        lTProduct.setVisible(true);
        add(lTProduct);


        bRefresh = new JButton("Odśwież");
        bRefresh.setBounds(350, 20, 100, 20);
        add(bRefresh);
        bRefresh.addActionListener(this);

        taProduct = new JTextArea();
        JScrollPane spProduct = new JScrollPane(taProduct);
        spProduct.setBounds(20, 65, 150, 150);
        add(spProduct);

        cChooseRecipe= new JComboBox();
        cChooseRecipe.setBounds(280,48,50,17);
        for(int ok : CookBook.getBook().getCookbook().keySet()) {
            cChooseRecipe.addItem(ok);
        }
        add(cChooseRecipe);
        cChooseRecipe.addActionListener(this);

        taRecipe = new JTextArea();
        JScrollPane spRecipe = new JScrollPane(taRecipe);
        spRecipe.setBounds(180, 65, 300, 50);
        add(spRecipe);

    }

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == bAddProduct) {
            AddProductFrame frame = new AddProductFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);}
        if(source ==bAddRecipe)
        {
            AddRecipeFrame frame = new AddRecipeFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);}

        if (source == bRefresh){
            taProduct = new JTextArea();
            JScrollPane spProduct = new JScrollPane(taProduct);
            spProduct.setBounds(20, 65, 150, 150);
            add(spProduct);

            File file = new File("C:\\Users\\cukro\\IdeaProjects\\lab04\\src\\magazine");

        Scanner scanner = null;


        try{
            scanner = new Scanner(file);
            while(scanner.hasNext())
                taProduct.append(scanner.nextLine()+"\n");
        }catch(FileNotFoundException a){
            System.out.println(a);
        }

            CookBook.getBook().readFromFileRecipe();
            CookBook.getBook().readFromFileNeededProducts();
            String id = cChooseRecipe.getSelectedItem().toString();
            taRecipe.setText(null);
            taRecipe.append(String.valueOf(CookBook.getBook().getCookbook().get(Integer.parseInt(id)).getProductList()));
            JScrollPane spRecipe = new JScrollPane(taRecipe);
            spRecipe.setBounds(180, 65, 300, 50);
            add(spRecipe);

    }
        if(source==cChooseRecipe)
        {
            CookBook.getBook().readFromFileRecipe();
            CookBook.getBook().readFromFileNeededProducts();
            String id = cChooseRecipe.getSelectedItem().toString();
            taRecipe.setText(null);
            taRecipe.append(String.valueOf(CookBook.getBook().getCookbook().get(Integer.parseInt(id)).getProductList()));
            JScrollPane spRecipe = new JScrollPane(taRecipe);
            spRecipe.setBounds(180, 65, 300, 50);
            add(spRecipe);
        }
    }

   /* public int compare(int id){
        CookBook.getBook().readFromFileRecipe();
        CookBook.getBook().readFromFileNeededProducts();
        Magazine.getObject().readFromFileProducts();

        int amount = CookBook.getBook().getCookbook().get(id).getProductList().size();

        for(int j=0;j<amount;j++){

            for(int k=0;k<Magazine.getObject().getMagazine().size();k++){
                if(CookBook.getBook().getCookbook().get(id).getProductList().get(j).getID()==Magazine.getObject().getMagazine().get(k).getID() & CookBook.getBook().getCookbook().get(id).getProductList().get(j).getWeight()<=Magazine.getObject().getMagazine().get(k).getWeight(){
                    amount--;
                     }
                         }
        }
        if(amount==0){
            int idd = CookBook.getBook().getCookbook().get(id).getID();
            String name = CookBook.getBook().getCookbook().get(id).getName();
            String description = CookBook.getBook().getCookbook().get(id).getDescription();

        }
        return 0;
    }*/
}