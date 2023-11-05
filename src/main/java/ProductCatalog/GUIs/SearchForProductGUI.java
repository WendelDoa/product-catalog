package ProductCatalog.GUIs;

import ProductCatalog.Controllers.BackController;
import ProductCatalog.System.CatalogTableModel;
import ProductCatalog.System.LogicalSystem;
import ProductCatalog.System.ProductsSearchTableModel;

import javax.swing.*;
import java.awt.*;

public class SearchForProductGUI extends JFrame {

    public static JTextField nameProductInput = new JTextField();
    private final LogicalSystem mainSystem;

    public SearchForProductGUI(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;

        setVisible(true);
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
            new ProductsFoundCatalogGUI(mainSystem);
        });
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(new BackController(mainSystem,this));
        row2.add(searchButton);
        row2.add(backButton);
        mainPanel.add(row2);

        add(mainPanel);
    }
}
