package ProductCatalog.System;

import javax.swing.table.AbstractTableModel;

public class CatalogTableModel extends AbstractTableModel {

    private final String[] columns = {"Id", "Name", "Type", "Price"};
    private final LogicalSystem mainSystem;

    public CatalogTableModel(LogicalSystem mainSystem) {
        this.mainSystem = mainSystem;
    }

    @Override
    public int getRowCount() {
        return mainSystem.searchAllProducts().size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = mainSystem.searchAllProducts().get(rowIndex + 1); // IDs começam em 1

        return switch (columnIndex) {
            case 0 -> product.getId();
            case 1 -> product.getName();
            case 2 -> product.getType();
            case 3 -> product.getPrice();
            default -> null;
        };
    }
}
