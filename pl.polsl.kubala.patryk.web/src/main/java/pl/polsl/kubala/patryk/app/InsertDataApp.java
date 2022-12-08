package pl.polsl.kubala.patryk.app;

import java.sql.*;

public class InsertDataApp {

    public void insertData() {
        
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
            statement.executeUpdate("INSERT INTO Data VALUES (1, 'Nowak', '000 456 678 876 567','decode', 123)");
            statement.executeUpdate("INSERT INTO Data VALUES (1, 'Patryk', '054 433 634 823 567','decode', 133)");
            statement.executeUpdate("INSERT INTO Data VALUES (1, 'test', '456 678 876 567','decode', 123)");
            statement.executeUpdate("INSERT INTO Data VALUES (1, '000 456 678 876 567', 'patr','encode', 123)");
            System.out.println("Data inserted");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public static void main(String[] args) {
        InsertDataApp insertDataApp = new InsertDataApp();
        insertDataApp.insertData();
    }
}
