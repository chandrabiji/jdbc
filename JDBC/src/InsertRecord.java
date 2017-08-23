import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertRecord {

	public static void main(String[] args) {
		//step4:execute the query
		int n = 0;
		try {
			//step1:load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2:establish the connection 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			//step3:prepare the statement
			Statement st = con.createStatement();
			n = st.executeUpdate("insert into newtable values(101,'xyz',98)");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n!=0)
		{
			System.out.println("--One Record Successfully Inserted--");
		}else{
			System.out.println("--Record Not Successfully Inserted---");
		}
		

	}

}
