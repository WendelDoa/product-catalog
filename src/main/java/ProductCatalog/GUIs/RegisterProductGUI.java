package ProductCatalog.GUIs;

import ProductCatalog.Controllers.BackController;
import ProductCatalog.Exceptions.ExceptionRegistrationError;
import ProductCatalog.System.LogicalSystem;
import ProductCatalog.System.TypeProduct;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;

public class RegisterProductGUI extends JFrame {

    private final LogicalSystem mainSystem;

    private static JTextField nameProduct = new JTextField();
    private static JTextField priceProduct = new JTextField();
    private static TypeProduct typeProduct = TypeProduct.TOOL;

    public RegisterProductGUI(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;

        setVisible(true);
        setTitle("Register Product");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        JPanel row1 = createRow1();
        JPanel row2 = createRow2();
        JPanel row3 = createRow3();
        JPanel row4 = createRow4();
        mainPanel.add(row1);
        mainPanel.add(row2);
        mainPanel.add(row3);
        mainPanel.add(row4);
        add(mainPanel);
    }

    private static JPanel createRow1() {
        JPanel row1 = new JPanel(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Enter the product name:");
        nameProduct.setPreferredSize(new Dimension(200, 25));
        row1.add(nameLabel);
        row1.add(nameProduct);
        return row1;
    }

    private static JPanel createRow2() {
        JPanel row2 = new JPanel(new GridLayout(2, 1));
        JLabel priceLabel = new JLabel("Enter the product price:");
        priceProduct.setPreferredSize(new Dimension(200, 25));
        row2.add(priceLabel);
        row2.add(priceProduct);
        return row2;
    }

    private static JPanel createRow3() {
        JPanel row3 = new JPanel(new GridLayout(5, 1));
        JLabel typeLabel = new JLabel("Select product type:");
        JRadioButton toolButton = new JRadioButton("Tool");
        toolButton.setSelected(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(toolButton);
        toolButton.addActionListener((ae) -> {
            typeProduct = TypeProduct.TOOL;
        });
        JRadioButton materialButton = new JRadioButton("Material");
        buttonGroup.add(materialButton);
        materialButton.addActionListener((ae) -> {
            typeProduct = TypeProduct.MATERIAL;
        });
        JRadioButton cleaningButton = new JRadioButton("Cleaning");
        buttonGroup.add(cleaningButton);
        cleaningButton.addActionListener((ae) -> {
            typeProduct = TypeProduct.CLEANING;
        });
        JRadioButton othersButton = new JRadioButton("Others");
        buttonGroup.add(othersButton);
        othersButton.addActionListener((ae) -> {
            typeProduct = TypeProduct.OTHERS;
        });
        row3.add(typeLabel);
        row3.add(toolButton);
        row3.add(materialButton);
        row3.add(cleaningButton);
        row3.add(othersButton);
        return row3;
    }

    private JPanel createRow4() {
        JPanel row4 = new JPanel(new GridLayout(2, 1));
        JButton registerProductButton = new JButton("Register product");
        registerProductButton.setPreferredSize(new Dimension(200, 50));
        registerProductButton.addActionListener((ae) -> {
            try {
                mainSystem.registerProduct(nameProduct.getText().toUpperCase(), typeProduct, Double.parseDouble(priceProduct.getText()));
                JOptionPane.showMessageDialog(this,"Product registered successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Something went wrong when trying " +
                        "to register the product!\nRemember the values must be written in the format 0.0");
            }
        });
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(new BackController(mainSystem, this));
        row4.add(registerProductButton);
        row4.add(backButton);
        return row4;
    }
}
