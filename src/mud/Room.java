package mud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Room {
	private HashMap<CommonContent.DIRECTION, Room> neighbor = new HashMap<CommonContent.DIRECTION, Room>();
	void setRoom(CommonContent.DIRECTION d, Room r) {
		neighbor.put(d, r);
	}
	public Room getRoom(CommonContent.DIRECTION d) {
		return neighbor.get(d);
	}
	private String roomDescription;
	private String roomLooking;
	private String roomId;
	private String roomName;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<NPC> npclist=new ArrayList<NPC>();
	
	public void addNPC(NPC npc) {
		this.npclist.add(npc);
	}
	public void link(Player player) {
		this.addPlayer(player);
		for(int i=0;i<playerList.size();i++) {
			if(!playerList.get(i).equals(player)) {
				String message=player.getName()+"连接进入了世界";
				try {
					MessageManagement.showToPlayer(playerList.get(i),message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//this.listRoomPlayers();
	}
	public void disconnect(Player player) {
		this.removePlayer(player);
		try {
			MessageManagement.showToPlayer(player,"你已退出。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void exit(Player player, CommonContent.DIRECTION direction) {
		this.removePlayer(player);
		for(int i=0;i<playerList.size();i++) {
			if(!playerList.get(i).equals(player)) {
				String message=player.getName()+"离开此地向"+Direction.getDirection(direction)+"走去。";
				try {
					MessageManagement.showToPlayer(playerList.get(i),message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//this.listRoomPlayers();
	}
	public void enter(Player player, CommonContent.DIRECTION direction) {
		this.addPlayer(player);
		for(int i=0;i<playerList.size();i++) {
			if(!playerList.get(i).equals(player)) {
				String message=player.getName()+"从"+Direction.getReverseDirection(direction)+"面走来。";
				try {
					MessageManagement.showToPlayer(playerList.get(i),message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//this.listRoomPlayers();
	}
	public void removePlayer(Player player){
		playerList.remove(player);
	}
	public void addPlayer(Player player){
		playerList.add(player);
		
	}

	public void setDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public String getDescription() {
		return roomDescription;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void SetRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	/*public String getRoomLooking() {
		return roomLooking;
	}*/

	public String getRoomLooking() {
		// 房间名
		roomLooking = roomName + "\t";
		// 房间描述
		// 应该由Client负责解析传输过来的字符（设定字体，每行字数）
		int roomDescriptionLength = roomDescription.length();
		if (roomDescriptionLength <= CommonContent.CHARS_PER_LINE)
			roomLooking += roomDescription + "\t";
		else {
			int i;
			for (i = 0; i <= roomDescriptionLength
					- CommonContent.CHARS_PER_LINE; i = i
					+ CommonContent.CHARS_PER_LINE) {
				roomLooking += roomDescription.substring(i, i
						+ CommonContent.CHARS_PER_LINE)
						+ "\t";
			}
			roomLooking += roomDescription.substring(i, roomDescriptionLength)
					+ "\t";
		}

		// 房间出口
		roomLooking += getChuKou() + "\t";
		// 房间npc

		// 房间player
		//roomLooking += listRoomPlayers();
		// 房间obj
		return roomLooking;
	}
	public String listRoomPlayers(Player player){
		//列出这个房间中的所有玩家
		String temp = "";
		for(int i=0;i<playerList.size();i++) {
			if(!playerList.get(i).equals(player)) {
				temp=temp+playerList.get(i).getName()+" ";
			}
		}
		return temp;
	}
	public String listNPC() {
		String temp = "";
		for(int i=0;i<npclist.size();i++) {
			temp=temp+npclist.get(i).getUsername()+" ";
		}
		return temp;
	}
	public String listNPCid() {
		String temp = "";
		for(int i=0;i<npclist.size();i++) {
			temp=temp+npclist.get(i).getId()+" ";
		}
		return temp;
	}
	public void messagewho(Player playersend,String name,String message) {
		int num=0;
		for(int i=0;i<playerList.size();i++) {
			if(playerList.get(i).getId().equals(name)) {
				try {
					MessageManagement.showToPlayer(playerList.get(i), playersend.getName()+"对你说："+message);
					MessageManagement.showToPlayer(playersend, "你对"+playerList.get(i).getName()+"说："+message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			num++;
		}
		if(num==playerList.size()) {
			try {
				MessageManagement.showToPlayer(playersend, "此地没有该玩家！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void chatAll(Player player,String message) {
		try {
			MessageManagement.showToPlayer(player,"你对此地所有人说："+message);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<playerList.size();i++) {
			if(!playerList.get(i).equals(player)) {
				try {
					MessageManagement.showToPlayer(playerList.get(i),player.getName()+"对此地所有人说："+message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public String getChuKou() {
		/*描述每个房间的出口
		 * 
		 * 
		 * */
		String temp = "";
		Iterator<Entry<CommonContent.DIRECTION, Room>> iterator = neighbor.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<CommonContent.DIRECTION, Room> entry = iterator.next();
			String dir = Direction.getDirection(entry.getKey());
			String room = entry.getValue().roomName;
			temp=dir+":"+room+" "+temp;
		}
		
		return temp;
	}
}
