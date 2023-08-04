
/* AUTHOR--> @Ayush Gupta. DATE-->02/08/2023.
THIS PROGRAM DESCRIBE HOW TO USE JDBC , TO CONNECT YOUR JAVA APPLICATION TO DB. IT FOLLOW 5 STEP FOR CONNECTION ESTABLISHING
1.  LOAD DRIVER USING--> ""Class.forName("com.mysql.jdbc.Driver")""
2.  CONNECTION CREATE-->Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","root","password"); 
3.  preparedstatement-->PreparedStatement ps = con.prepareStatement("insert into db values(' ',' ',' ')");
4.  executestatement--> ps.executeUpdate();
5.  AT THE END close all the connections to the database---> con.close();  /  ps.close();*/
import java.sql.*;
import java.util.*;

public class JdbcConnection {
	public void record() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter ID: ");
		String id = sc.nextLine();

		System.out.println("Enter NAME: ");
		String name = sc.nextLine();

		System.out.println("Enter GMAIL: ");
		String gmail = sc.nextLine();

		System.out.println("Enter GENDER: ");
		String gender = sc.nextLine();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver  loaded..");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "ayush@8953");
			System.out.println("Connection Established.. ");

			PreparedStatement ps = con.prepareStatement("insert into BCA values(?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, gmail);
			ps.setString(4, gender);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Execution perfect: ");
			} else {
				System.out.println("Execution Fail: ");
			}

			ps.close();
			con.close();
		}

		catch (Exception e) {
			System.out.println("Exception aa gyi hain" + e);
		}
	}

	public static void main(String[] ar) {
		new JdbcConnection().record();
	}

}
