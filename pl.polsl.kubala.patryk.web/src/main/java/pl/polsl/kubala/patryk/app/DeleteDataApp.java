package pl.polsl.kubala.patryk.app;

import java.sql.*;

public class DeleteDataApp {

    public void deleteData() {
        
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
            // Usuwamy Data z tabeli
            int numberOfDeletedRows = statement.executeUpdate("DELETE FROM Data WHERE seed = 123");
            System.out.println("Data removed: " + numberOfDeletedRows + " rows");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public static void main(String[] args) {
        DeleteDataApp deleteDataApp = new DeleteDataApp();
        deleteDataApp.deleteData();
    }
}
