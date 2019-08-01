package mud;

import java.io.IOException;

import data.MonsterList;
import data.MonsterQuery;
import data.PlayerUpdate;

public class Player {
	private int exp;  //经验
	private int atk; //攻击力
	private int def; //防御力
	private int hp,max_hp;
	private int mp,max_mp;
	private int spd;
	private int cr;
	private int cash;
	private String id;
	private String username;
	private String place;
	private String grou;
	private String passwd;
	public Player(String id,int exp,int atk,int def,int hp,int max_hp,int mp,int max_mp,int spd,int cr,int cash,String grou,String username,String place,String passwd) {
		this.id=id;
		this.exp=exp;
		this.atk=atk;
		this.def=def;
		this.hp=hp;
		this.max_hp=max_hp;
		this.mp=mp;
		this.max_mp=max_mp;
		this.spd=spd;
		this.cr=cr;
		this.cash=cash;
		this.grou=grou;
		this.username=username;
		this.place=place;
		this.passwd=passwd;
	}
	public Player() {
		
	}
	public void move(CommonContent.DIRECTION direction) {   //移动
		Room playerRoom=RoomManagement.cityMap.get(this.place);
		Room playerNextRoom=playerRoom.getRoom(direction);
		playerRoom.exit(this, direction);
		playerNextRoom.enter(this, direction);
		this.place=playerNextRoom.getRoomId();
		try {
			PlayerUpdate.playerupdate(this);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			MessageManagement.showToPlayer(this,playerNextRoom.getDescription());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void connect() {  //连接
		Room room=RoomManagement.cityMap.get(this.getPlace());
		room.link(this);
		try {
			MessageManagement.showToPlayer(this, "进入世界成功！                       "+room.getDescription());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listothers() {  //显示房间内在线人员
		Room room=RoomManagement.cityMap.get(this.getPlace());
		String str=room.listRoomPlayers(this);
		try {
			MessageManagement.showToPlayer(this, str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listexit() {  //显示房间出口
		Room room=RoomManagement.cityMap.get(this.getPlace());
		String str=room.getChuKou();
		try {
			MessageManagement.showToPlayer(this, str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listnpc() {  //显示npc
		Room room=RoomManagement.cityMap.get(this.getPlace());
		String str=room.listNPC();
		try {
			MessageManagement.showToPlayer(this, str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void asknpc(String npc) { //与npc对话
		Room room=RoomManagement.cityMap.get(this.getPlace());
		String str=room.listNPCid();
		String[] sp=str.split(" ");
		int number=0;
		while(number<sp.length) {
			if(sp[number].equals(npc)) {
				try {
					NPC n=NPCManagement.npcid.get(npc);
					MessageManagement.showToPlayer(this, n.getMessage());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			else number++;
		}
		if(number==sp.length) {
			try {
				MessageManagement.showToPlayer(this, "什么");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void attack(String monsterid) { //攻击
		Monster monster=new Monster();
		try {
			monster=MonsterQuery.monsterquery(monsterid,this.place);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(monster.getId()==null) {
			try {
				MessageManagement.showToPlayer(this, "没有该怪物！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			BattleManagement.battle(this, monster);
		}
	}
	public void listmonster() {  //显示此地所有monster名
		String str="";
		try {
			str=MonsterList.monsterlist(this.getPlace());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(str.equals("")) {
			try {
				MessageManagement.showToPlayer(this, "此地没有怪物！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				MessageManagement.showToPlayer(this, str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void changepasswd(String newpasswd) {   //修改密码
		this.setPasswd(newpasswd);
		try {
			PlayerUpdate.playerupdate(this);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			MessageManagement.showToPlayer(this, "修改密码成功现在密码为："+newpasswd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void messagewho(String name,String message) {   //私信
		Room room=RoomManagement.cityMap.get(this.place);
		room.messagewho(this, name, message);
	}
	public void chatAll(String message) {
		Room room=RoomManagement.cityMap.get(this.place);
		room.chatAll(this, message);
	}
	public void quit(){
		//告诉房间退出了
		Room room=RoomManagement.cityMap.get(this.place);
		room.disconnect(this);
	}
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return this.place;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getName(){
		return this.username;
	}
	public void setName(String username){
		this.username=username;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMax_hp() {
		return max_hp;
	}
	public void setMax_hp(int max_hp) {
		this.max_hp = max_hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getMax_mp() {
		return max_mp;
	}
	public void setMax_mp(int max_mp) {
		this.max_mp = max_mp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public int getCr() {
		return cr;
	}
	public void setCr(int cr) {
		this.cr = cr;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public String getGrou() {
		return grou;
	}
	public void setGrou(String grou) {
		this.grou = grou;
	}
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void injure(int hurt) {
		this.mp=this.mp-hurt;
	}
	public void addexp(int exp) {
		this.exp=this.exp+exp;
	}
}
