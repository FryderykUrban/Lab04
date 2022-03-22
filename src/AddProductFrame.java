import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddProductFrame extends JFrame implements ActionListener {
    JTextField tName, tWeight, tID;
    JLabel lName,lWeight, lID;
    ButtonGroup bgWeight;
    JRadioButton rbWeight, rbVolume, rbPieces;
    JButton bAdd, bEdit;


    public AddProductFrame(){
        setSize(350,200);
        setTitle("Dodaj/edytuj nowy produkt");
        setLayout(null);

        tName = new JTextField();
        tName.setBounds(170,20,150,20);
        tName.setVisible(true);

        tWeight = new JTextField();
        tWeight.setBounds(170,40,150,20);
        tWeight.setVisible(true);

        tID = new JTextField();
        tID.setBounds(170,80,150,20);
        tID.setVisible(true);


        lName = new JLabel("Nazwa produktu");
        lName.setBounds(20,20,150,20);
        lName.setVisible(true);

        lWeight = new JLabel("Ilość produktu");
        lWeight.setBounds(20,40,150,20);
        lWeight.setVisible(true);

        lID = new JLabel("Identyfikator produktu");
        lID.setBounds(20,80,150,20);
        lID.setVisible(true);

        bgWeight = new ButtonGroup();
        rbWeight = new JRadioButton("Waga[kg]", true);
        rbWeight.setBounds(20,60,100,20);
        bgWeight.add(rbWeight);
        add(rbWeight);
        rbWeight.addActionListener(this);

        rbVolume = new JRadioButton("Objętość[l]", false);
        rbVolume.setBounds(120,60,100,20);
        bgWeight.add(rbVolume);
        add(rbVolume);
        rbVolume.addActionListener(this);

        rbPieces = new JRadioButton("Sztuki", false);
        rbPieces.setBounds(220,60,100,20);
        bgWeight.add(rbPieces);
        add(rbPieces);
        rbPieces.addActionListener(this);

        bAdd = new JButton("Dodaj");
        bAdd.setBounds(140,110,80,20);
        bAdd.addActionListener(this);
        bAdd.setVisible(true);

        bEdit = new JButton("Edytuj");
        bEdit.setBounds(240, 110, 80, 20);
        add(bEdit);
        bEdit.addActionListener(this);


        add(tName);
        add(tWeight);
        add(tID);

        add(lName);
        add(lWeight);
        add(lID);

        add(bAdd);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

            if ((source == bAdd) & (rbWeight.isSelected())) {
            String productName = tName.getText(), unit="[kg]";
            float weight = Float.parseFloat(tWeight.getText());
            int id = Integer.parseInt(tID.getText());
            Magazine.getObject().addProduct(productName, weight, id, unit);
            Magazine.getObject().saveToFileProducts();
            dispose();}
            else if ((source == bAdd) & (rbVolume.isSelected())){
            String productName = tName.getText(), unit="[l]";
                float weight = Float.parseFloat(tWeight.getText());
            int id = Integer.parseInt(tID.getText());
            Magazine.getObject().addProduct(productName, weight, id,unit);
            Magazine.getObject().saveToFileProducts();
            dispose();}
            else if ((source == bAdd) & (rbPieces.isSelected())){
            String productName = tName.getText(), unit="[szt]";
                float weight = Float.parseFloat(tWeight.getText());
            int id = Integer.parseInt(tID.getText());
            Magazine.getObject().addProduct(productName, weight, id, unit);
            Magazine.getObject().saveToFileProducts();
            dispose();}




        if ((source == bEdit) & (rbWeight.isSelected())) {

            String productName = tName.getText(), unit="[kg]";
            float weight = Float.parseFloat(tWeight.getText());
            int id = Integer.parseInt(tID.getText());
            Magazine.getObject().editProduct(productName, weight, id, unit);
            Magazine.getObject().saveToFileProducts();
            dispose();}
        else if ((source == bEdit) & (rbVolume.isSelected())){
            String productName = tName.getText(), unit="[l]";
            float weight = Float.parseFloat(tWeight.getText());
            int id = Integer.parseInt(tID.getText());
            Magazine.getObject().editProduct(productName, weight, id,unit);
            Magazine.getObject().saveToFileProducts();
            dispose();}
        else if ((source == bEdit) & (rbPieces.isSelected())){
            String productName = tName.getText(), unit="[szt]";
            float weight = Float.parseFloat(tWeight.getText());

            int id = Integer.parseInt(tID.getText());
            Magazine.getObject().editProduct(productName, weight, id,unit);
            Magazine.getObject().saveToFileProducts();
            dispose();}

            }



        }



