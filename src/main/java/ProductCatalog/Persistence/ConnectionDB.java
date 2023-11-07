package ProductCatalog.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/catalogtoolsDB";
    private static final String user = "postgres";
    private static final String password = "DoA11070";

    //Função para estabelecer a conexão com o banco de dados
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}