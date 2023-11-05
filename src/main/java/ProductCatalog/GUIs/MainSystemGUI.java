package ProductCatalog.GUIs;

import ProductCatalog.System.LogicalSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainSystemGUI extends JFrame {

    private final LogicalSystem mainSystem;
    private static boolean messageInitial = false;

    public MainSystemGUI(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
        setVisible(true);
        setTitle("Product catalog");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        GridLayout gridLayout = new GridLayout(7, 1);
        setLayout(gridLayout);
        SwingUtilities.invokeLater(() -> {
            if(!messageInitial) {
                JOptionPane.showMessageDialog(this,
                        "Hello, Welcome To The Product Catalog!\nCreate by: Wendel Soares\n Rio tinto - UFPB");
                messageInitial = true;
            }
        });
        addButtonFn("Product catalog", e -> new ProductCatalogGUI(mainSystem));
        addButtonFn("Search for product", e -> new SearchForProductGUI(mainSystem));
        addButtonFn("Register product", e -> registerProduct());
        addButtonFn("Update product", e -> updateProduct());
        addButtonFn("Delete product", e -> deleteProduct());
        addButtonFn("Save catalog", e -> saveCatalog());
        addButtonFn("Exit", e -> exit());



    }

    private void addButtonFn(String label, ActionListener event) {
        JButton button = new JButton(label);
        button.addActionListener(event);
        add(button);
    }

    private void registerProduct() {
        RegisterProductGUI registerProductGUI = new RegisterProductGUI(mainSystem);
        registerProductGUI.setVisible(true);
        dispose();
    }

    private void updateProduct() {
        UpdateProductGUI updateProductGUI = new UpdateProductGUI(mainSystem);
        updateProductGUI.setVisible(true);
        dispose();
    }

    private void deleteProduct() {
        DeleteProductGUI deleteProductGUI = new DeleteProductGUI(mainSystem);
        deleteProductGUI.setVisible(true);
        dispose();
    }

    private void saveCatalog() {
        SaveCatalogGUI saveCatalogGUI = new SaveCatalogGUI(mainSystem);
        saveCatalogGUI.setVisible(true);
        dispose();
    }

    private void exit() {
        System.exit(0);
    }

}
