package ProductCatalog.System;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

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
        List<Product> productsList = new ArrayList<>(mainSystem.searchAllProducts().values());
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
