package data;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PlayerDelete {
	public static Connection conn;
	public static void playerdelete(String id) throws Exception {
		DBConnection db=new DBConnection();
		conn=db.getconn();
		String sql="delete from user where userid = ?";
		PreparedStatement cmd=conn.prepareStatement(sql);
		cmd.setString(1, id);
		cmd.executeUpdate();
		conn.close();
	}
}
