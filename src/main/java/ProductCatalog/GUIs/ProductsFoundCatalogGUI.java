package ProductCatalog.GUIs;

import ProductCatalog.System.LogicalSystem;
import ProductCatalog.System.ProductsSearchTableModel;

import javax.swing.*;
import java.awt.*;

public class ProductsFoundCatalogGUI extends JFrame {

    private LogicalSystem mainSystem;

    public ProductsFoundCatalogGUI(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
        setVisible(true);
        setTitle("Product table");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        JTable catalogTable = new JTable(new ProductsSearchTableModel(mainSystem,
                SearchForProductGUI.nameProductInput.getText().toUpperCase()));
        JScrollPane scrollPane = new JScrollPane(catalogTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}
