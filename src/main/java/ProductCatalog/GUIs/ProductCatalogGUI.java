package ProductCatalog.GUIs;

import ProductCatalog.System.CatalogTableModel;
import ProductCatalog.System.LogicalSystem;

import javax.swing.*;
import java.awt.*;

public class ProductCatalogGUI extends JFrame {

    private LogicalSystem mainSystem;

    public ProductCatalogGUI(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
        setTitle("Product table");
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        JTable catalogTable = new JTable(new CatalogTableModel(mainSystem));
        JScrollPane scrollPane = new JScrollPane(catalogTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}
