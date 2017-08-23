import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BatchUpdate {

	public static void main(String[] args) {
		int[] rows = null;
		try {
			//step1:load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2:establish the connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			//step3:prepare the statement
			Statement st = con.createStatement();
			st.addBatch("insert into newtable values(200,'chandra',35)");
			st.addBatch("update newtable set sname='Himanshu' where sno=100");
			rows = st.executeBatch();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int noOfRowsEffected = 0;
		for(int n:rows)
		{
			noOfRowsEffected+=n;
		}
		System.out.println("No of Rows Effected "+noOfRowsEffected);

	}

}
