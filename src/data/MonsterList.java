package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MonsterList {
	public static Connection conn;
	public static String monsterlist(String place) throws Exception{
		String message="";
		DBConnection db=new DBConnection();
		conn=db.getconn();
		String sql="select * from monster where place = ?";
		PreparedStatement cmd=conn.prepareStatement(sql);
		cmd.setString(1, place);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			message=message+rs.getString("name")+" ";
		}
		return message;
	}
}
