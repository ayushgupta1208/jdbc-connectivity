import java.sql.*;
import java.util.Scanner;

public class test {

    Connection con;
    Statement stmt;
    ResultSet rs;

    public test(String s) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded...\n");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "ayush@8953");
            System.out.println("Connection Stablished..\n");

            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from db where name='" + s + "'");
            System.out.println("name\tgmail\t\tmob no.\t\tgender");

            /*
             * next()<-- its used for moving the cursor to each row .
             * at the end it return false(zero) after the last row
             */
            while (rs.next()) {
                // System.out.println(rs.next());

                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.println();
            }

            // con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void updateMob(String i, String mob) {
        try {

            stmt = con.createStatement();
            stmt.executeUpdate("update db set mob='" + mob + "' where name='" + i + "'");
            System.out.println("Mobile no. updated....");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name for show details");
        String s = sc.nextLine();
        test obj = new test(s);
        System.out.println("enter new mobile number");
        String mob = sc.nextLine();

        obj.updateMob(s, mob);
    }
}
