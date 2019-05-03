package full1;

import java.sql.*;

public class Msqj {
	 Connection myCon;
	 Statement myStmt;
	 ResultSet rs;
	public Msqj(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "root");
				//myStmt = myCon.PreparedStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public boolean chkUser(String user,String password) {
		String query = "select (pass) from security where uname = '"+user+"';";
		try {
			myStmt = 
					myCon.createStatement();
			rs = myStmt.executeQuery(query);
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					return true;
				}
			}
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public String shCars() {
		String s ="<table id=\"t01\">" + 
				" <tr>" + 
				"  <th>id</th>" +
				"  <th>iName</th>" +
				"  <th>Path</th>" +
				"  <th>Entry</th>" + 
				/*"  <th>Result</th>" + */
				" </tr>";
		String query = "select * from carts ;";
		try {
			myStmt = 
					myCon.createStatement();
			rs = myStmt.executeQuery(query);
			while(rs.next()) {
				s+="<tr>";int i=1;
				for(;i<5;i++) {
					s+="<td>"+rs.getString(i)+"</td>";
				}
				String temp = rs.getString(5);
				s+="</tr>";
			}
			s+="</table>";
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	/*public static void main(String [] args) {
		Msqj m1 = new Msqj();
		System.out.println(m1.shCars());
	}*/
}
