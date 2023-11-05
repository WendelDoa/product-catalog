package ProductCatalog.System;

import javax.swing.table.AbstractTableModel;

public class ProductsSearchTableModel extends AbstractTableModel {

    private final String[] columns = {"Id", "Name", "Type", "Price"};
    private final LogicalSystem mainSystem;
    private final String text;

    public ProductsSearchTableModel(LogicalSystem mainSystem, String text) {
        this.mainSystem = mainSystem;
        this.text = text;
    }

    @Override
    public int getRowCount() {
        return mainSystem.searchProductWithName(text).size();
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
        Product product = mainSystem.searchProductWithName(text).get(rowIndex + 1); // IDs começam em 1

        return switch (columnIndex) {
            case 0 -> product.getId();
            case 1 -> product.getName();
            case 2 -> product.getType();
            case 3 -> String.format("R$ %.2f", product.getPrice());
            default -> null;
        };
    }
}
