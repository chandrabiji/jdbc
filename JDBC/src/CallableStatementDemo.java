import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;


public class CallableStatementDemo {

	public static void main(String[] args) {
		int result;
		try {
			//step1:load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2:establish the connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			//step3:prepare the statement
			CallableStatement cs = con.prepareCall("{call pone(?,?)}");
			//register output parameter
			cs.registerOutParameter(2, Types.INTEGER);
			cs.setInt(1, 25);
			cs.execute();
			result = cs.getInt(2);
			System.out.println("Result : "+result);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
