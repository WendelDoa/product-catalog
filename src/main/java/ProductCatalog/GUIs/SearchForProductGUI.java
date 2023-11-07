package ProductCatalog.GUIs;

import ProductCatalog.Controllers.ExitController;
import ProductCatalog.System.LogicalSystem;

import javax.swing.*;
import java.awt.*;

public class SearchForProductGUI extends JFrame {

    public static JTextField nameProductInput = new JTextField();
    private final LogicalSystem mainSystem;

    public SearchForProductGUI(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
        setTitle("Search Product");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();

        JPanel row1 = new JPanel(new GridLayout(2,1));
        JLabel searchLabel = new JLabel("Enter the product name:");
        nameProductInput.setPreferredSize(new Dimension(200, 30));
        row1.add(searchLabel);
        row1.add(nameProductInput);
        mainPanel.add(row1);

        JPanel row2 = new JPanel(new GridLayout(2,1));
        JButton searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(200, 50));
        searchButton.addActionListener((ae) -> {
            ProductsFoundCatalogGUI productsFoundCatalogGUI = new ProductsFoundCatalogGUI(mainSystem);
            productsFoundCatalogGUI.setVisible(true);
        });
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(200, 50));
        exitButton.addActionListener(new ExitController(mainSystem,this));
        row2.add(searchButton);
        row2.add(exitButton);
        mainPanel.add(row2);

        add(mainPanel);
    }
}
