import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PreparedStatementDemo {

	public static void main(String[] args) {
		int n=0;
		try {
			//step1:load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2:establish the connection 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			//step3:Prepared statement
			PreparedStatement ps = con.prepareStatement("insert into newtable values(?,?,?)");
			ps.setInt(1, 400);
			ps.setString(2, "shiva");
			ps.setInt(3, 98);
			n = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n!=0)
		{
			System.out.println("Record Successfully Inserted");
		}else{
			System.out.println("Record Not Successfully Inserted");
		}

	}

}
