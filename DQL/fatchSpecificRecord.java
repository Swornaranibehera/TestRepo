package DQL;
import java.io.FileReader;
import java.io.IOException;
import java . sql.*;
import java.util.Properties;
public class fatchSpecificRecord {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement prs=null;
		ResultSet rs=null;
		FileReader fr=null;
		Properties pro=new Properties();
		
		try {
			fr=new FileReader("D:\\sinujdbc\\DQLPreparedStatement\\src\\DQL\\removehdcodr.properties");
			pro.load(fr);
		} catch (IOException  e) {
			e.printStackTrace();
		}
		try {
		
			Class.forName(pro.getProperty("db.DriverClass"));
		
			con=DriverManager.getConnection(pro.getProperty("db.url"),pro.getProperty("username"),pro.getProperty("password"));
			prs=con.prepareStatement("select * from Students where gender=? and sid< ?");
			prs.setString(1, "m");  
			prs.setInt(2, 105);
			rs=prs.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getInt("sid")+"\t");
				System.out.print(rs.getString("sname")+"\t");
				System.out.print(rs.getString("gender")+"\t");
				System.out.print(rs.getDouble("fee"));
			}
		}
		catch(SQLException  |  ClassNotFoundException  e)
		{
			e.printStackTrace();
		}
    finally {
    	try {
    		if(prs!=null) prs.close();
    	
    	if(rs!=null) rs.close();
    	if(con!=null) con.close();	
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	}

}
