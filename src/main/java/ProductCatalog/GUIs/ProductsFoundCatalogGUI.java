package ProductCatalog.GUIs;

import ProductCatalog.Controllers.ExitController;
import ProductCatalog.System.LogicalSystem;
import ProductCatalog.System.ProductsSearchTableModel;

import javax.swing.*;
import java.awt.*;

public class ProductsFoundCatalogGUI extends JFrame {

    private LogicalSystem mainSystem;

    public ProductsFoundCatalogGUI(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
        setTitle("Product table");
        setSize(500, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();

        JPanel row1 = new JPanel();
        JTable catalogTable = new JTable(new ProductsSearchTableModel(mainSystem,
                SearchForProductGUI.nameProductInput.getText().toUpperCase()));
        catalogTable.setPreferredScrollableViewportSize(new Dimension(450, 400));
        JScrollPane scrollPane = new JScrollPane(catalogTable);
        row1.add(scrollPane);
        mainPanel.add(row1);

        JPanel row2 = new JPanel();
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener((ae) -> {
            dispose();
        });
        exitButton.setPreferredSize(new Dimension(200, 50));
        row2.add(exitButton);
        mainPanel.add(row2);

        add(mainPanel);
    }
}

