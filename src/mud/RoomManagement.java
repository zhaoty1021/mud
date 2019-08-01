package mud;

import java.util.HashMap;
import java.util.Map;

public class RoomManagement {
	static Map<String, Room> cityMap = new HashMap<String, Room>();
	public static void creatRooms() {
		
		Room shenzhou_center = new Room();	
		shenzhou_center.setRoomId("shenzhou_center");
		shenzhou_center.SetRoomName("神州中心");
		shenzhou_center.setDescription("这里是世界的正中心，路上人来人往，十分热闹，这是世界的枢纽，在这里你可以找到通往各界的路，祝你好运！");
		
		//北大街
		Room shenzhou_beidajie1 = new Room();
		shenzhou_beidajie1.setRoomId("shenzhou_beidajie1");
		shenzhou_beidajie1.SetRoomName("北大街");
		shenzhou_beidajie1.setDescription("你走在一条阴森诡异的道路上，西边貌似有个高大的建筑，金碧辉煌。前面的路很黑，看不到尽头。东边有个店铺，似乎在卖什么。南边边人来人往，那是世界的中心。");
		
		Room shenzhou_beidajie2 = new Room();
		shenzhou_beidajie2.setRoomId("shenzhou_beidajie2");
		shenzhou_beidajie2.SetRoomName("北大街");
		shenzhou_beidajie2.setDescription("气氛愈发诡异，空气中好像混着一丝魔障之气，让人呼吸困难，再向北走就是神州大陆的北门了。有很多车马向南走去，那边看着很热闹。东边是一片恐怖的树林，还是不要过去的好。");
		

		Room shenzhou_beimen = new Room();
		shenzhou_beimen.setRoomId("shenzhou_beimen");
		shenzhou_beimen.SetRoomName("北门");
		shenzhou_beimen.setDescription("这是就是神州大陆的北城门了，城门很阴森，那边的世界和这边完全不同，你若没有什么本事最好不要再向北走，越过这城门，那边就是魔界了。");
		
		Room shenzhou_tiejiangpu=new Room();
		shenzhou_tiejiangpu.setRoomId("shenzhou_tiejiangpu");
		shenzhou_tiejiangpu.SetRoomName("铁匠铺");
		shenzhou_tiejiangpu.setDescription("这里是铁匠铺，在这里你可以买或打造装备，这里的装备是在世界通用的，但是也很普通。对低级的你应该足够了。西边是北大街，那里很热闹。向西走是北大街。");
		
		Room shenzhou_shigulin=new Room();
		shenzhou_shigulin.setRoomId("shenzhou_shigulin");
		shenzhou_shigulin.SetRoomName("蚀骨林");
		shenzhou_shigulin.setDescription("你进入了蚀骨林，这是神州大地最高级的副本地图，适合10-15级玩家。低级玩家请自行退出。该地区位于大陆与魔界交界，因此产生了很多恐怖的生物。向西走是北大街。");
		
		Room shenzhou_xiaoyaogong=new Room();
		shenzhou_xiaoyaogong.setRoomId("shenzhou_xiaoyaogong");
		shenzhou_xiaoyaogong.SetRoomName("逍遥宫");
		shenzhou_xiaoyaogong.setDescription("这里是天界逍遥派在神州大陆设置的宫殿，在这里你可以了解有关逍遥派的一切。向东走是北大街。");
		
		//南大街
		Room shenzhou_nandajie1 = new Room();
		shenzhou_nandajie1.setRoomId("shenzhou_nandajie1");
		shenzhou_nandajie1.SetRoomName("南大街");
		shenzhou_nandajie1.setDescription("南大街乃是神州大地上的繁华地段，一到晚上，一派灯红酒绿，尤为热闹。笑声、歌声、琴声、箫声，汇成一片送入了你的耳朵，你不禁心猿意马，很想就此停步享受一番。北边是一个热闹的广场。西边是一片喧嚣，夹杂着“一五一十”的数钱声，原来那里是方圆千里之内最大的一家赌场");
		
		Room shenzhou_nandajie2 = new Room();
		shenzhou_nandajie2.setRoomId("shenzhou_nandajie2");
		shenzhou_nandajie2.SetRoomName("南大街");
		shenzhou_nandajie2.setDescription("你走在一条繁华的街道上，向南北两头延伸。南边就是大陆的南门，北边通往市中心，东边是一座阴森的建筑，但是看起来很高大。西边是一片仙雾缭绕的地方，那里看起来很美妙。");
			
		Room shenzhou_nanmen = new Room();
		shenzhou_nanmen.setRoomId("yangzhou_nanmen");
		shenzhou_nanmen.SetRoomName("南门");
		shenzhou_nanmen.setDescription("这是神州大陆的南城门，城门的那边就是看起来遥不可及的天界。");
		
		Room shenzhou_duchang = new Room();
		shenzhou_duchang.setRoomId("shenzhou_duchang");
		shenzhou_duchang.SetRoomName("赌场");
		shenzhou_duchang.setDescription("这里是赌场的大堂，四周的房间里传出来吆五喝六的赌博声，楼上灯火通明。东边就是南大街。");
		
		Room shenzhou_duchang2 = new Room();
		shenzhou_duchang2.setRoomId("shenzhou_duchang2");
		shenzhou_duchang2.SetRoomName("赌场二楼");
		shenzhou_duchang2.setDescription("这里是赌场二楼。");
		
		Room shenzhou_guimen = new Room();
		shenzhou_guimen.setRoomId("shenzhou_guimen");
		shenzhou_guimen.SetRoomName("鬼门");
		shenzhou_guimen.setDescription("据说这里是鬼域暗夜鬼门的招募地，这座建筑阴森的可怕，西边是南大街，在这里你可以了解有关暗夜鬼门的一切。在这座建筑的东边，似乎还有一座宫殿，那里充满着神秘色彩。");
		
		Room shenzhou_xiuluodian = new Room();
		shenzhou_xiuluodian.setRoomId("shenzhou_xiuluodian");
		shenzhou_xiuluodian.SetRoomName("修罗殿");
		shenzhou_xiuluodian.setDescription("据说这里名为修罗殿，是神界修罗派在此设立的宫殿。据说这是一个很神秘的组织，在此你可以了解它的一切。西边是一座阴森的建筑。");
			
		Room shenzhou_juxianling = new Room();
		shenzhou_juxianling.setRoomId("shenzhou_juxianling");
		shenzhou_juxianling.SetRoomName("聚仙凌");
		shenzhou_juxianling.setDescription("这里是聚仙凌，仙雾缭绕，但是这里也有很多奇奇怪怪的生物，你可以攻击它们，此地适合5-10级玩家。东边是南大街。");
		
		
		//西大街
		Room shenzhou_xidajie1 = new Room();
		shenzhou_xidajie1.setRoomId("shenzhou_xidajie1");
		shenzhou_xidajie1.SetRoomName("西大街");
		shenzhou_xidajie1.setDescription("这是一条宽阔的青石板街道，向东西两头延伸。西北边是一个二层酒馆，门口有很多人。南边是一个武道场，大家在那里学习武功。这里往东面走是一个热闹的地方。");
		
		Room shenzhou_jiugun=new Room();
		shenzhou_jiugun.setRoomId("shenzhou_jiugun");
		shenzhou_jiugun.SetRoomName("鸿福酒馆");
		shenzhou_jiugun.setDescription("这里这个地方最大的酒馆，这儿的人很多，上面还有二楼。向东南边走是东大街。");
		
		Room shenzhou_jiugun2=new Room();
		shenzhou_jiugun2.setRoomId("shenzhou_jiugun2");
		shenzhou_jiugun2.SetRoomName("酒馆二楼");
		shenzhou_jiugun2.setDescription("这里是酒馆二楼，人还是很多。");
		
		Room shenzhou_wudaochang=new Room();
		shenzhou_wudaochang.setRoomId("shenzhou_wudaochang");
		shenzhou_wudaochang.SetRoomName("武道场");
		shenzhou_wudaochang.setDescription("这里是武道场，在这里你可以学习到基础的武功，如果你想达到更高的境界，你要加入各个门派来学习更加全面的术法。向北走是东大街。");
		
		Room shenzhou_xidajie2 = new Room();
		shenzhou_xidajie2.setRoomId("shenzhou_xidajie2");
		shenzhou_xidajie2.SetRoomName("西大街");
		shenzhou_xidajie2.setDescription("这是一条宽阔的青石板街道，向东西两头延伸。这里来来往往的游人你推我挤，热闹非常。有来来往往的人像东边走去，南边有一片沼泽，没人知道那里有什么。");
		
		Room shenzhou_elingzhaoze=new Room();
		shenzhou_elingzhaoze.setRoomId("shenzhou_zhaoze");
		shenzhou_elingzhaoze.SetRoomName("恶灵沼泽");
		shenzhou_elingzhaoze.setDescription("你来到了恶灵沼泽，向北走是西大街。这里有很多可怕的恶灵，适合5-10级玩家。");
		
		Room shenzhou_ximen = new Room();
		shenzhou_ximen.setRoomId("shenzhou_ximen");
		shenzhou_ximen.SetRoomName("西门");
		shenzhou_ximen.setDescription("这是西城门，城墙上贴着几张通缉告示(gaoshi)。西门是往西域的必经之地，官兵们戒备森严。一条笔直的青石板大道向东西两边延伸。西边是郊外，骑马的、坐轿的、走路的，行人匆匆。东边是城里的西大街。");
		//东大街
		Room shenzhou_dongdajie1 = new Room();
		shenzhou_dongdajie1.setRoomId("shenzhou_dongdajie1");
		shenzhou_dongdajie1.SetRoomName("东大街");
		shenzhou_dongdajie1.setDescription("这是一条祥和的街道，在此地的人都从东边的人间而来，西边热热闹闹，东北方有一座宫殿，东边还有一条繁华的街道。");
		
		Room shenzhou_dongdajie2 = new Room();
		shenzhou_dongdajie2.setRoomId("shenzhou_dongdajie2");
		shenzhou_dongdajie2.SetRoomName("东大街");
		shenzhou_dongdajie2.setDescription("这条街道很繁华，北边有一座建筑，里面传来阵阵琴声。西边是一条祥和的街道，南边是人们梦想炼出丹药的丹药房，再向东走就是神州大陆的东门了。");
				
		Room shenzhou_dongmen = new Room();
		shenzhou_dongmen.setRoomId("shenzhou_dongmen");
		shenzhou_dongmen.SetRoomName("东门");
		shenzhou_dongmen.setDescription("这里是神州大陆东城门，城门正上方刻着“东门”两个楷书大字，南边的土地上好像有着好多神奇的生物。东边是通向人间的康庄大道，那里和平祥和。");
		
		Room shenzhou_dugong=new Room();
		shenzhou_dugong.setRoomId("shenzhou_dugong");
		shenzhou_dugong.SetRoomName("毒宫");
		shenzhou_dugong.setDescription("这里是人间东曦毒派在神州大陆设置的宫殿，在此地你可以了解有关东曦毒派的一切。");
		
		Room shenzhou_qiongyinge=new Room();
		shenzhou_qiongyinge.setRoomId("shenzhou_qiongyinge");
		shenzhou_qiongyinge.SetRoomName("琼音阁");
		shenzhou_qiongyinge.setDescription("这里是人间琼音派在此地设置的楼阁，在此地你可以了解有关琼音派的一切。");
		
		Room shenzhou_danyaofang=new Room();
		shenzhou_danyaofang.setRoomId("shenzhou_danyaofang");
		shenzhou_danyaofang.SetRoomName("丹药房");
		shenzhou_danyaofang.setDescription("这里是丹药房，你可以购买你需要的丹药，记住最好不要花光你的钱。");
		
		Room shenzhou_yaojinggu=new Room();
		shenzhou_yaojinggu.setRoomId("shenzhou_yaojinggu");
		shenzhou_yaojinggu.SetRoomName("妖精谷");
		shenzhou_yaojinggu.setDescription("这里是妖精谷，这里适合0-5级的新手，这里的妖精都很友好，但是也有敌对的势力，祝你好运！");
		
		//建立房间间的链接
		//广场
		shenzhou_center.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_beidajie1);
		shenzhou_center.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_nandajie1);
		shenzhou_center.setRoom(CommonContent.DIRECTION.EAST, shenzhou_dongdajie1);
		shenzhou_center.setRoom(CommonContent.DIRECTION.WEST, shenzhou_xidajie1);
		//北大街
		shenzhou_beidajie1.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_beidajie2);
		shenzhou_beidajie1.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_center);
		shenzhou_beidajie1.setRoom(CommonContent.DIRECTION.EAST, shenzhou_tiejiangpu);
		shenzhou_beidajie1.setRoom(CommonContent.DIRECTION.WEST, shenzhou_xiaoyaogong);
		
		shenzhou_beidajie2.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_beimen);
		shenzhou_beidajie2.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_beidajie1);
		shenzhou_beidajie2.setRoom(CommonContent.DIRECTION.EAST, shenzhou_shigulin);
		
		
		shenzhou_beimen.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_beidajie2);
		shenzhou_shigulin.setRoom(CommonContent.DIRECTION.WEST, shenzhou_beidajie2);
		shenzhou_xiaoyaogong.setRoom(CommonContent.DIRECTION.EAST, shenzhou_beidajie1);
		shenzhou_tiejiangpu.setRoom(CommonContent.DIRECTION.WEST, shenzhou_beidajie1);
		
		//南大街
		shenzhou_nandajie1.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_center);
		shenzhou_nandajie1.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_nandajie2);
		shenzhou_nandajie1.setRoom(CommonContent.DIRECTION.WEST, shenzhou_duchang);
		//shenzhou_nandajie1.setRoom(CommonContent.DIRECTION.EAST, room_bingying);
		
		shenzhou_nandajie2.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_nandajie1);
		shenzhou_nandajie2.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_nanmen);
		shenzhou_nandajie2.setRoom(CommonContent.DIRECTION.WEST, shenzhou_juxianling);
		shenzhou_nandajie2.setRoom(CommonContent.DIRECTION.EAST, shenzhou_guimen);
				
		shenzhou_nanmen.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_nandajie2);
		shenzhou_duchang.setRoom(CommonContent.DIRECTION.EAST, shenzhou_nandajie1);
		shenzhou_duchang.setRoom(CommonContent.DIRECTION.UP, shenzhou_duchang2);
		shenzhou_duchang2.setRoom(CommonContent.DIRECTION.DOWN, shenzhou_duchang);
		
		shenzhou_guimen.setRoom(CommonContent.DIRECTION.WEST, shenzhou_nandajie2);
		shenzhou_guimen.setRoom(CommonContent.DIRECTION.EAST, shenzhou_xiuluodian);
		shenzhou_juxianling.setRoom(CommonContent.DIRECTION.EAST, shenzhou_nandajie2);
		shenzhou_xiuluodian.setRoom(CommonContent.DIRECTION.WEST, shenzhou_guimen);
		
		//西大街
		shenzhou_xidajie1.setRoom(CommonContent.DIRECTION.EAST, shenzhou_center);
		shenzhou_xidajie1.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_wudaochang);
		shenzhou_xidajie1.setRoom(CommonContent.DIRECTION.WEST, shenzhou_xidajie2);
		shenzhou_xidajie1.setRoom(CommonContent.DIRECTION.NORTHWEST, shenzhou_jiugun);
		
		shenzhou_xidajie2.setRoom(CommonContent.DIRECTION.EAST, shenzhou_xidajie1);
		shenzhou_xidajie2.setRoom(CommonContent.DIRECTION.WEST, shenzhou_ximen);
		shenzhou_xidajie2.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_elingzhaoze);
		
		shenzhou_ximen.setRoom(CommonContent.DIRECTION.EAST, shenzhou_xidajie2);
		shenzhou_elingzhaoze.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_xidajie2);
		shenzhou_wudaochang.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_xidajie1);
		shenzhou_jiugun.setRoom(CommonContent.DIRECTION.SOUTHEAST, shenzhou_xidajie1);
		shenzhou_jiugun.setRoom(CommonContent.DIRECTION.UP, shenzhou_jiugun2);
		shenzhou_jiugun2.setRoom(CommonContent.DIRECTION.DOWN, shenzhou_jiugun);
		
		
		//东大街
		shenzhou_dongdajie1.setRoom(CommonContent.DIRECTION.NORTHEAST, shenzhou_dugong);
		shenzhou_dongdajie1.setRoom(CommonContent.DIRECTION.EAST,shenzhou_dongdajie2);
		shenzhou_dongdajie1.setRoom(CommonContent.DIRECTION.WEST,shenzhou_center);

		shenzhou_dongdajie2.setRoom(CommonContent.DIRECTION.WEST,shenzhou_dongdajie1);
		shenzhou_dongdajie2.setRoom(CommonContent.DIRECTION.NORTH,shenzhou_qiongyinge);
		shenzhou_dongdajie2.setRoom(CommonContent.DIRECTION.SOUTH,shenzhou_danyaofang);
		shenzhou_dongdajie2.setRoom(CommonContent.DIRECTION.EAST,shenzhou_dongmen);
		
		shenzhou_dugong.setRoom(CommonContent.DIRECTION.SOUTHWEST, shenzhou_dongdajie1);
		shenzhou_qiongyinge.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_dongdajie2);
		shenzhou_danyaofang.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_dongdajie2);
		
		shenzhou_dongmen.setRoom(CommonContent.DIRECTION.WEST, shenzhou_dongdajie2);
		shenzhou_dongmen.setRoom(CommonContent.DIRECTION.SOUTH, shenzhou_yaojinggu);
		shenzhou_yaojinggu.setRoom(CommonContent.DIRECTION.NORTH, shenzhou_dongmen);
		
		cityMap.put(shenzhou_center.getRoomId(), shenzhou_center);
		cityMap.put(shenzhou_beidajie1.getRoomId(), shenzhou_beidajie1);
		cityMap.put(shenzhou_beidajie2.getRoomId(), shenzhou_beidajie2);
		cityMap.put(shenzhou_beimen.getRoomId(), shenzhou_beimen);
		cityMap.put(shenzhou_shigulin.getRoomId(), shenzhou_shigulin);
		cityMap.put(shenzhou_tiejiangpu.getRoomId(), shenzhou_tiejiangpu);
		cityMap.put(shenzhou_xiaoyaogong.getRoomId(), shenzhou_xiaoyaogong);
		
		cityMap.put(shenzhou_nandajie1.getRoomId(), shenzhou_nandajie1);
		cityMap.put(shenzhou_nandajie2.getRoomId(), shenzhou_nandajie2);
		cityMap.put(shenzhou_nanmen.getRoomId(), shenzhou_nanmen);
		cityMap.put(shenzhou_duchang.getRoomId(), shenzhou_duchang);
		cityMap.put(shenzhou_duchang2.getRoomId(), shenzhou_duchang2);
		cityMap.put(shenzhou_xiuluodian.getRoomId(), shenzhou_xiuluodian);
		cityMap.put(shenzhou_guimen.getRoomId(), shenzhou_guimen);
		cityMap.put(shenzhou_juxianling.getRoomId(), shenzhou_juxianling);
		
		cityMap.put(shenzhou_xidajie1.getRoomId(), shenzhou_xidajie1);
		cityMap.put(shenzhou_xidajie2.getRoomId(), shenzhou_xidajie2);
		cityMap.put(shenzhou_ximen.getRoomId(), shenzhou_ximen);
		cityMap.put(shenzhou_elingzhaoze.getRoomId(), shenzhou_elingzhaoze);
		cityMap.put(shenzhou_wudaochang.getRoomId(), shenzhou_wudaochang);
		cityMap.put(shenzhou_jiugun.getRoomId(), shenzhou_jiugun);
		cityMap.put(shenzhou_jiugun2.getRoomId(), shenzhou_jiugun2);
		
		cityMap.put(shenzhou_dongdajie1.getRoomId(), shenzhou_dongdajie1);
		cityMap.put(shenzhou_dongdajie2.getRoomId(), shenzhou_dongdajie2);
		cityMap.put(shenzhou_dugong.getRoomId(), shenzhou_dugong);
		cityMap.put(shenzhou_qiongyinge.getRoomId(), shenzhou_qiongyinge);
		cityMap.put(shenzhou_danyaofang.getRoomId(), shenzhou_danyaofang);
		cityMap.put(shenzhou_dongmen.getRoomId(), shenzhou_dongmen);
		cityMap.put(shenzhou_yaojinggu.getRoomId(), shenzhou_yaojinggu);
	}
}
