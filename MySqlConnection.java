import java.sql.*;
import java.util.*;

public class MySqlConnection {
    public static void main(String[] args) {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/ayush";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Deriver loaded....");
            con = DriverManager.getConnection(url, "root", "ayush@8953");
            System.out.println("Connection Establish...");
        }

        catch (ClassNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }

        try {
            con.close();
        } catch (SQLException e) {
        }

    }

}