import ProductCatalog.Exceptions.ProductNotFoundException;
import ProductCatalog.System.LogicalSystem;
import ProductCatalog.System.TypeProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class LogicalSystemTests {

    private LogicalSystem mainSystem;

    @Before
    public void setUp() throws SQLException {
        mainSystem = new LogicalSystem();
    }

    @Test
    public void testRegisterProduct() {
        mainSystem.registerProduct("Product1", TypeProduct.OTHERS, 10);
        Assert.assertTrue(mainSystem.searchAllProducts().size() == 1);
        mainSystem.registerProduct("Product2", TypeProduct.MATERIAL, 20);
        mainSystem.registerProduct("Product3", TypeProduct.CLEANING, 30);
        Assert.assertFalse(mainSystem.searchAllProducts().size() != 3);
    }

    @Test
    public void testSearchProductWithName() {
        mainSystem.registerProduct("Hammer", TypeProduct.TOOL, 30);
        mainSystem.registerProduct("Shovel", TypeProduct.TOOL, 50);
        Assert.assertTrue(mainSystem.searchProductWithName("Hamm").size() == 1);
        mainSystem.registerProduct("Shovel2", TypeProduct.TOOL, 60);
        Assert.assertFalse(mainSystem.searchProductWithName("Sho").size() != 2);
    }

    @Test
    public void testDeleteProduct() throws ProductNotFoundException {
        try {
            mainSystem.registerProduct("Product2", TypeProduct.TOOL, 150);
            mainSystem.deleteProductById(1);
            Assert.assertTrue(mainSystem.searchAllProducts().isEmpty());
        } catch (ProductNotFoundException | SQLException e) {
            System.out.println("There's something wrong");
        }
    }

    @Test
    public void exceptionTesteDeleteProduct() throws ProductNotFoundException, SQLException {
        try {
            mainSystem.registerProduct("Product3", TypeProduct.MATERIAL, 110);
            mainSystem.deleteProductById(2);
            System.out.println("There's something wrong");
        } catch (ProductNotFoundException e) {
            System.out.println("Approved");
        }
    }

    @Test
    public void testGetNameProductById() {
        try {
            mainSystem.registerProduct("Product1", TypeProduct.CLEANING, 45);
            Assert.assertEquals(mainSystem.getNameProductById(1), "Product1");
            System.out.println("Aprroved");
        } catch (ProductNotFoundException e) {
            System.out.println("There's something wrong");
        }
    }

    @Test
    public void exceptionTestGetNameProductById() {
        try {
            mainSystem.registerProduct("Product1", TypeProduct.TOOL, 50);
            mainSystem.getNameProductById(2);
            System.out.println("There's something wrong");
        } catch (ProductNotFoundException e) {
            System.out.println("Aprroved");
        }
    }

    @Test
    public void testSearchAllProducts() {
        mainSystem.registerProduct("Product1", TypeProduct.TOOL, 50);
        mainSystem.registerProduct("Product2", TypeProduct.MATERIAL, 100);
        mainSystem.registerProduct("Product3", TypeProduct.CLEANING, 150);
        Assert.assertTrue(mainSystem.searchAllProducts().size() == 3);
    }
}
