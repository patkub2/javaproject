package pl.polsl.kubala.patryk.app;

import java.sql.*;

public class SelectDataApp {

    public void selectData() {

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
            ResultSet rs = statement.executeQuery("SELECT * FROM Data");
            // Przeglądamy otrzymane wyniki
            System.out.printf("|%-3s|%-20s|%-20s|%-5s|%-5s|\n", "ID", "text", "decodedtext", "operation", "seed");
            System.out.println("-----------------------------------");
            while (rs.next()) {
                System.out.printf("|%-3s", rs.getInt("id"));
                System.out.printf("|%-20s", rs.getString("text"));
                System.out.printf("|%-20s", rs.getString("decodedtext"));
                System.out.printf("| %-4s|", rs.getString("operation"));
                System.out.printf("| %-4s|\n", rs.getInt("seed"));
            }
            System.out.println("-----------------------------------");
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public static void main(String[] args) {
        SelectDataApp selectDataApp = new SelectDataApp();
        selectDataApp.selectData();
    }
}
