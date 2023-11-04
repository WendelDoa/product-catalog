package ProductCatalog;

import ProductCatalog.GUIs.MainSystemGUI;
import ProductCatalog.System.LogicalSystem;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LogicalSystem mainSystem = new LogicalSystem();
        JFrame windowMainSystem = new MainSystemGUI(mainSystem);
    }
}
