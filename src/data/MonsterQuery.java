package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mud.*;

public class MonsterQuery {
	public static Connection conn;
	public static Monster monsterquery(String id,String place) throws Exception{
		DBConnection db=new DBConnection();
		conn=db.getconn();
		String sql="select * from monster where id = ? and place = ?";
		PreparedStatement cmd=conn.prepareStatement(sql);
		cmd.setString(1,id);
		cmd.setString(2, place);
		ResultSet rs = cmd.executeQuery();
		Monster monster=new Monster();
		while(rs.next()) {
			monster=new Monster(rs.getString("id"), rs.getInt("exp"),rs.getInt("atk"), rs.getInt("def"), rs.getInt("mp"),rs.getInt("maxmp"),rs.getInt("spd"),rs.getInt("cr"),rs.getString("ele"), rs.getString("name"), rs.getString("place"));
		}
		return monster;
	}
}
