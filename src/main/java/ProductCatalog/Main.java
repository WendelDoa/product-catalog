package ProductCatalog;

import ProductCatalog.GUIs.MainSystemGUI;
import ProductCatalog.System.LogicalSystem;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        LogicalSystem mainSystem = new LogicalSystem();
        JFrame windowMainSystem = new MainSystemGUI(mainSystem);
    }
}
