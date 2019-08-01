package data;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mud.Player;

public class PlayerAdd {
	public static Connection conn;
	public static void playeradd(Player player) throws Exception {
		DBConnection db=new DBConnection();
		conn=db.getconn();
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement cmd=conn.prepareStatement(sql);
		cmd.setString(1,player.getId());
		cmd.setString(2,player.getUsername());
		cmd.setInt(3,player.getExp());
		cmd.setInt(4,player.getAtk());
		cmd.setInt(5,player.getDef());
		cmd.setInt(6,player.getHp());
		cmd.setInt(7,player.getMax_hp());
		cmd.setInt(8,player.getMp());
		cmd.setInt(9,player.getMax_mp());
		cmd.setInt(10, player.getSpd());
		cmd.setInt(11, player.getCr());
		cmd.setInt(12, player.getCash());
		cmd.setString(13,player.getGrou());
		cmd.setString(14,player.getPlace());
		cmd.setString(15,player.getPasswd());
		cmd.executeUpdate();
	    conn.close();
	}
}
