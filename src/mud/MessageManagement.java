package mud;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import mud.Server.PlayerThread;

public class MessageManagement {
	static HashMap<String,BufferedWriter> playerChannels = new HashMap<String,BufferedWriter>();
	
	public static void showToPlayer(Player player, String message) throws IOException{
		playerChannels.get(player.getId()).write(message+"\n");
		playerChannels.get(player.getId()).flush();
	}
	public static void showToOtherPlayer(Player player, String message) throws IOException{
		Iterator<Entry<String, PlayerThread>> entries = Server.playerThread.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, PlayerThread> entry = (Map.Entry<String, PlayerThread>) entries.next();
			String id=(String)entry.getKey();
			if(id!=player.getId()) {
				Player others=new Player();
				others.setId(id);
				MessageManagement.showToPlayer(others, message);
			}
		}
	}
	public static void addPlayerChannels(String playerId,BufferedWriter pw){
		playerChannels.put(playerId, pw);
	}
	public static void removePlayerChannels(String playerId){
		playerChannels.remove(playerId);
	}
}
