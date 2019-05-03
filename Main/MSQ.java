
import java.sql.*;

public class MSQ {
	Connection myCon;
	Statement myStmt;
	ResultSet rs;

	MSQ() {
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "root");
			//myStmt = myCon.PreparedStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addI(String cname,int i,String path,String res) throws SQLException {
		try {
			String query="insert into carts (iname,path,entry,result) values ('"+cname+"_"+i+".png"+"','"+path+"',now(),'"+res+"');";
			myStmt = myCon.createStatement();
			myStmt.executeUpdate(query);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[] getI(String img) {
		String arr[]= new String[4];
		arr[0]=img;
		try {
			String query="select * from carts where iname='"+img+"';";
			myStmt = myCon.createStatement();
			ResultSet rs = myStmt.executeQuery(query);
			if(rs.next()) {
				arr[0]=rs.getString("id");
				arr[1]=rs.getString("path");
				arr[2]=rs.getString("entry");
				arr[3]=rs.getString("result");
			}
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;
	}
}
