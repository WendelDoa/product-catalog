package ProductCatalog.GUIs;

import ProductCatalog.Controllers.ExitController;
import ProductCatalog.System.CatalogTableModel;
import ProductCatalog.System.LogicalSystem;

import javax.swing.*;
import java.awt.*;

public class ProductCatalogGUI extends JFrame {

    private LogicalSystem mainSystem;

    public ProductCatalogGUI(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
        setTitle("Product table");
        setSize(500,550);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();

        JPanel row1 = new JPanel();
        JTable catalogTable = new JTable(new CatalogTableModel(mainSystem));
        catalogTable.setPreferredScrollableViewportSize(new Dimension(450, 400));
        JScrollPane scrollPane = new JScrollPane(catalogTable);
        row1.add(scrollPane);

        JPanel row2 = new JPanel();
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitController(mainSystem, this));
        exitButton.setPreferredSize(new Dimension(200, 50));
        row2.add(exitButton);

        mainPanel.add(row1);
        mainPanel.add(row2);
        add(mainPanel);
    }
}
