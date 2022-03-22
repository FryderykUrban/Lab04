import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class AddRecipeFrame extends JFrame implements ActionListener {
    JTextField tName, tDescription,tID;
    JTextArea taProductRecipe;
    JLabel lName, lProducts, lDescription,lID;
    JButton bAdd;


    public AddRecipeFrame(){
        setSize(320,240);
        setTitle("Dodaj/edytuj nowy przepis");
        setLayout(null);

        tName = new JTextField();
        tName.setBounds(135,10,150,20);
        tName.setVisible(true);

        lName = new JLabel("Nazwa przepisu");
        lName.setBounds(20,10,150,20);
        lName.setVisible(true);

        lDescription = new JLabel("Opis przygotowania");
        lDescription.setBounds(20,35,150,20);
        lDescription.setVisible(true);

        tDescription = new JTextField();
        tDescription.setBounds(135,35,150,20);
        tDescription.setVisible(true);

        lProducts = new JLabel("Produkty: ");
        lProducts.setBounds(20,60,80,15);
        lProducts.setVisible(true);


        bAdd = new JButton("Dodaj");
        bAdd.setBounds(200,165,80,20);
        bAdd.addActionListener(this);
        bAdd.setVisible(true);

        lID = new JLabel("NR:");
        lID.setBounds(75,165,25,15);
        lID.setVisible(true);

        tID = new JTextField();
        tID.setBounds(100,165,40,20);
        tID.setVisible(true);

        taProductRecipe = new JTextArea();
        JScrollPane spProduct = new JScrollPane(taProductRecipe);
        spProduct.setBounds(80, 60, 205, 100);
        taProductRecipe.setToolTipText("ID;NAZWA PRODUKTU;ILOŚĆ PRODUKTU;[JEDNOSTKA]");
        add(spProduct);

        add(lDescription);
        add(tDescription);
        add(tName);
        add(lName);
        add(lProducts);
        add(bAdd);
        add(lID);
        add(tID);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == bAdd) {
            String recipeName = tName.getText(), description = tDescription.getText();
            int ID=Integer.parseInt(tID.getText());
            String products = taProductRecipe.getText();
            CookBook.getBook().saveToFileNeededProducts(products);
            CookBook.getBook().addRecipe(recipeName,description,ID);
            CookBook.getBook().saveToFileRecipe();
           // CookBook.getBook().saveToFileNeededProducts(products);
            CookBook.getBook().readFromFileRecipe();
            CookBook.getBook().readFromFileNeededProducts();

               /* String productName = tName.getText(), unit="[kg]";
                float weight = Float.parseFloat(tWeight.getText());
                int id = Integer.parseInt(tID.getText());
                Magazine.getObject().addProduct(productName, weight, id, unit);
                Magazine.getObject().saveToFileProducts();
                dispose();*/

        }
        }
    }
