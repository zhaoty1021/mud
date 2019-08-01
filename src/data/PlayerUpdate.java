package data;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mud.Player;

public class PlayerUpdate {
	public static Connection conn;
	public static void playerupdate(Player player) throws Exception{
		DBConnection db=new DBConnection();
		conn=db.getconn();
		String sql="update user set username=?,exp=?,atk=?,def=?,hp=?,maxhp=?,mp=?,maxmp=?,spd=?,cr=?,cash=?,grou=?,place=?,passwd=? where userid=?";
		PreparedStatement cmd=conn.prepareStatement(sql);
		cmd.setString(1,player.getUsername());
		cmd.setInt(2,player.getExp());
		cmd.setInt(3,player.getAtk());
		cmd.setInt(4,player.getDef());
		cmd.setInt(5,player.getHp());
		cmd.setInt(6,player.getMax_hp());
		cmd.setInt(7,player.getMp());
		cmd.setInt(8,player.getMax_mp());
		cmd.setInt(9, player.getSpd());
		cmd.setInt(10, player.getCr());
		cmd.setInt(11, player.getCash());
		cmd.setString(12,player.getGrou());
		cmd.setString(13,player.getPlace());
		cmd.setString(14,player.getPasswd());
		cmd.setString(15,player.getId());
		cmd.executeUpdate();
	    conn.close();//关闭通道
	}
}
