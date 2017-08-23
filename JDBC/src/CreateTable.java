import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {

	public static void main(String[] args) {
		try {
			//step1:load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2:establish the connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			//step3:prepare the statement
			Statement st = con.createStatement();
			//step4:execute the query
			st.execute("create table newtable(sno number(3),sname varchar2(30),marks number(3))");
			System.out.println("--Table Created---");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
