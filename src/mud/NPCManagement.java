package mud;

import java.util.HashMap;
import java.util.Map;

public class NPCManagement {
	static Map<String, NPC> npcid = new HashMap<String, NPC>();
	public static void creatNPC() {
		NPC xiaoyaosheng=new NPC("xiaoyaosheng","逍遥生", "shenzhou_xiaoyaogong");
		xiaoyaosheng.setMessage(xiaoyaosheng.getUsername()+":我将告诉你有关天界逍遥派的一切。");
		NPC qiongyinshi=new NPC("qiongyinshi","琼音师", "shenzhou_qiongyinge");
		qiongyinshi.setMessage(qiongyinshi.getUsername()+":我将告诉你有关人界琼音派的一切。");
		NPC wanduwang=new NPC("wanduwang", "万毒王", "shenzhou_dugong");
		wanduwang.setMessage(wanduwang.getUsername()+":我将告诉你有关人界东曦毒派的一切。");
		NPC anyegui=new NPC("anyegui", "暗夜鬼", "shenzhou_guimen");
		anyegui.setMessage(anyegui.getUsername()+":我将告诉你有关鬼域暗夜鬼门的一切。");
		NPC xiuluo=new NPC("xiuluo", "修罗", "shenzhou_xiuluodian");
		xiuluo.setMessage(xiuluo.getUsername()+":我将告诉你有关神界修罗派的一切。");
		RoomManagement.cityMap.get(xiaoyaosheng.getPlace()).addNPC(xiaoyaosheng);
		RoomManagement.cityMap.get(qiongyinshi.getPlace()).addNPC(qiongyinshi);
		RoomManagement.cityMap.get(wanduwang.getPlace()).addNPC(wanduwang);
		RoomManagement.cityMap.get(anyegui.getPlace()).addNPC(anyegui);
		RoomManagement.cityMap.get(xiuluo.getPlace()).addNPC(xiuluo);
		npcid.put(xiaoyaosheng.getId(), xiaoyaosheng);
		npcid.put(qiongyinshi.getId(), qiongyinshi);
		npcid.put(wanduwang.getId(), wanduwang);
		npcid.put(anyegui.getId(), anyegui);
		npcid.put(xiuluo.getId(), xiuluo);
	}
}
