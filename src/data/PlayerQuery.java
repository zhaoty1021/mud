package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mud.Player;

public class PlayerQuery {
	public static Connection conn;
	public static Player playerquery(String id) throws Exception{
		DBConnection db=new DBConnection();
		conn=db.getconn();
		String sql="select * from user where userid = ?";
		PreparedStatement cmd=conn.prepareStatement(sql);
		cmd.setString(1,id);
		ResultSet rs = cmd.executeQuery();
		Player player=new Player();
		while(rs.next()) {
			player=new Player(rs.getString("userid"), rs.getInt("exp"), rs.getInt("atk"), rs.getInt("def"), rs.getInt("hp"), rs.getInt("maxhp"), rs.getInt("mp"),rs.getInt("maxmp"),rs.getInt("spd"),rs.getInt("cr"),rs.getInt("cash"),rs.getString("grou"), rs.getString("username"), rs.getString("place"),rs.getString("passwd"));
		}
		return player;
	}
	
}
