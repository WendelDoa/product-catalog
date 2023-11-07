package ProductCatalog.System;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

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
        List<Product> productsList = new ArrayList<>(mainSystem.searchProductWithName(text).values());
        Product product = productsList.get(rowIndex);


        return switch (columnIndex) {
            case 0 -> product.getId();
            case 1 -> product.getName();
            case 2 -> product.getType();
            case 3 -> String.format("R$ %.2f", product.getPrice());
            default -> null;
        };
    }
}
