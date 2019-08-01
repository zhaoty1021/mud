package mud;

public class Monster {
	private int exp;
	private int atk; //攻击力
	private int def; //防御力
	private int mp,max_mp;
	private int spd;
	private int cr;
	private String id;
	private String name;
	private String place;
	private String ele;
	public Monster(String id,int exp,int atk,int def,int mp,int max_mp,int spd,int cr,String ele,String name,String place) {
		this.id=id;
		this.exp=exp;
		this.atk=atk;
		this.def=def;
		this.mp=mp;
		this.max_mp=max_mp;
		this.spd=spd;
		this.cr=cr;
		this.ele=ele;
		this.name=name;
		this.place=place;
	}
	public Monster() {
		
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getEle() {
		return ele;
	}
	public void setEle(String ele) {
		this.ele = ele;
	}
	public void injure(int hurt) {
		this.mp=this.mp-hurt;
	}
}
