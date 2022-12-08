package pl.polsl.kubala.patryk.app;

import java.sql.*;

public class UpdateDataApp {

    public void updateData() {

        try {
            // loading the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
            return;
        }

        // make a connection to DB
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/cypher", "app", "app")) {
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // Wysyłamy zapytanie do bazy danych
            ResultSet rs = statement.executeQuery("SELECT * FROM Data");

            //adding a new row
            rs.moveToInsertRow();
            rs.updateInt("ID", 100);
            rs.updateString("text", "Sobieski");
            rs.updateString("decodedtext", "054 433 634 823 567");
            rs.updateString("operation", "decode");
            rs.updateInt("seed", 124);
            rs.insertRow();
            rs.moveToCurrentRow();
            

            rs.close();
            System.out.println("Data updated");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public static void main(String[] args) {
        UpdateDataApp updateDataApp = new UpdateDataApp();
        updateDataApp.updateData();
    }
}
