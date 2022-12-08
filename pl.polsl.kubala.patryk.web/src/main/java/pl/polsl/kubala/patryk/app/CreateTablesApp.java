package pl.polsl.kubala.patryk.app;

import java.sql.*;

public class CreateTablesApp {

    public void createTables() {

        try {
            // loading the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
            return;
        }

        // make a connection to DB
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/cypher", "app", "app")) {
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE Data "
                    + "(id INTEGER, text VARCHAR(50),decodedtext VARCHAR(50), "
                    + "operation VARCHAR(50), seed INTEGER )");
            System.out.println("Table created");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public static void main(String[] args) {
        CreateTablesApp createTablesApp = new CreateTablesApp();
        createTablesApp.createTables();
    }
}
