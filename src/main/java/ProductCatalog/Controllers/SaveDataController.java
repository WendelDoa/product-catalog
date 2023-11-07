package ProductCatalog.Controllers;

import ProductCatalog.System.LogicalSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SaveDataController implements ActionListener {

    private LogicalSystem mainSystem;

    public SaveDataController(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String operation = mainSystem.saveData();
            JOptionPane.showMessageDialog(null, operation);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Unable to save files!");
        }
    }
}
