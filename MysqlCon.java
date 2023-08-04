import java.sql.*;

class MysqlCon {
    public static void main(String args[]) {
        String name = "abcd ";
        String gmail = "@ahfks3gmail.com";
        String mob = "12";
        String gender = "sec";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root", "ayush@8953");
            // here sonoo is the database name, root is the username and root is the
            // password
            // Statement stmt = con.createStatement();

            // ResultSet rs = stmt.executeQuery("select * from employee");
            System.out.println("tracking steps");
            PreparedStatement ps = con
                    .prepareStatement("insert into db values(?,?,?,?)");
            ps.setString(4, name);
            ps.setString(2, gmail);
            ps.setString(3, mob);
            ps.setString(1, gender);

            int i = ps.executeUpdate();

            // if (i > 0) {
            // System.out.println("update Successful");
            // } else {
            // System.out.println("update fail ");
            // }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}