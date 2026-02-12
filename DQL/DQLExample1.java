package DQL;

import java.sql.*;

public class DQLExample1 {

    public static void main(String[] args) {

    	
        Connection con = null;
        PreparedStatement prs = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "ashudb",
                    "pass2"
            );

            String sql = "SELECT * FROM students";
            prs = con.prepareStatement(sql);

            rs = prs.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getInt("sid") + "\t");
                System.out.print(rs.getString("sname") + "\t");
                System.out.print(rs.getString("gender") + "\t");
                System.out.print(rs.getDouble("fee"));
                System.out.println();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (prs != null) prs.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
