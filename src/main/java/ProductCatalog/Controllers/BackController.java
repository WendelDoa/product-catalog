package ProductCatalog.Controllers;

import ProductCatalog.GUIs.MainSystemGUI;
import ProductCatalog.System.LogicalSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackController implements ActionListener {

    private LogicalSystem mainSystem;
    private JFrame currentWindow;

    public BackController(LogicalSystem mainSystem, JFrame currentWindow) {
        this.mainSystem = mainSystem;
        this.currentWindow = currentWindow;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        MainSystemGUI mainSystemGUI = new MainSystemGUI(mainSystem);
        mainSystemGUI.setVisible(true);
        currentWindow.dispose();
    }
}
