
//Creating a class connection to insert and retrieve the values to database
//controller

import java.sql.*;
import static java.lang.System.*;

public class empDaoController {
	static Connection con = null; // global object
	// creating a method to connect vd database

	public void connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// getting connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empManagement", "root", "Raju@123");

	}

	// creating a method to add the values in database
	public static void addEmp(empl e1) throws SQLException {
		String query = "insert into empl values(?,?,?,?)";
		// preparing statement from con object
		PreparedStatement psm = con.prepareStatement(query);
		// inserting the values
		psm.setInt(1, e1.eId);
		psm.setString(2, e1.eName);
		psm.setString(3, e1.eDomain);
		psm.setInt(4, e1.eSalary);
		// using executeupdatemethod to update or modify the values
		int count = psm.executeUpdate();
		out.println(count + "rows get affected");

	}

	// creating method to printing values via employee id
	public empl getEmp(int eid) throws Exception {
		empl e = new empl();
		e.eId = eid;
		String query = "select * from empl where eid=" + eid;
		// creating statement
		Statement sm = con.createStatement();
		// execute the statement
		ResultSet rst = sm.executeQuery(query);
		// to get cursor on next element
		rst.next();
		e.eName = rst.getString(2);
		e.eDomain = rst.getString(3);
		e.eSalary = rst.getInt(4);

		return e;
	}

}
