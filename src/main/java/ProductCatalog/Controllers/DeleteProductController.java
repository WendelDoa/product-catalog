package ProductCatalog.Controllers;

import ProductCatalog.Exceptions.ProductNotFoundException;
import ProductCatalog.GUIs.DeleteProductGUI;
import ProductCatalog.System.LogicalSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteProductController implements ActionListener {

    private final LogicalSystem mainSystem;

    public DeleteProductController(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            int idProductInput = Integer.parseInt(DeleteProductGUI.idProductInput.getText());
            String nameProduct = mainSystem.getNameProductById(idProductInput);
            mainSystem.deleteProductById(idProductInput);
            JOptionPane.showMessageDialog(null, "The product "
                    + nameProduct + " was successfully deleted");
        } catch (ProductNotFoundException | SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}
