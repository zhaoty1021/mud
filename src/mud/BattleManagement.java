package mud;

import java.io.IOException;
import java.util.Random;

import data.PlayerUpdate;

public class BattleManagement {
	public static void battle(Player player,Monster monster) {
		String message="";
		Random random = new Random();
		int n=1;
		while(player.getMp()>0&&monster.getMp()>0) {
			int hitplayer=random.nextInt(199)+1;
			int hitmonster=random.nextInt(199)+1;
			int critplayer=random.nextInt(399)+1;
			int critmonster=random.nextInt(399)+1;
			if(player.getSpd()>=hitmonster) {
				message=message+"第"+n+"回合："+monster.getName()+"闪避了！ ";
			}
			else {
				int hurt=(int)(0.8*player.getAtk()-0.5*monster.getDef());
				if(hurt<0) hurt=0;
				hurt=15+hurt;
				int maxhurt=hurt+10;
				int minhurt=hurt-10;
				int hurtplayer=random.nextInt(maxhurt-minhurt+1)+minhurt;
				if(player.getCr()<=critplayer) {
					monster.injure(hurtplayer);
					message=message+"第"+n+"回合："+monster.getName()+"受到了"+hurtplayer+"点伤害。 ";
				}
				else {
					hurtplayer=(int)(hurtplayer*1.2);
					monster.injure(hurtplayer);
					message=message+"第"+n+"回合："+"你打出了暴击！"+monster.getName()+"受到了"+hurtplayer+"点伤害。 ";
				}
			}
			//if(monster.getMp()<=0) break;
			//else {
				if(monster.getSpd()>=hitplayer) {
					message=message+"第"+n+"回合：你闪避了！ ";
				}
				else {
					int hurt=(int)(0.8*monster.getAtk()-0.5*player.getDef());
					if(hurt<0) hurt=0;
					hurt=15+hurt;
					int maxhurt=hurt+10;
					int minhurt=hurt-10;
					int hurtmonster=random.nextInt(maxhurt-minhurt+1)+minhurt;
					if(monster.getCr()<=critmonster) {
						player.injure(hurtmonster);
						message=message+"第"+n+"回合：你受到了"+hurtmonster+"点伤害。 ";
					}
					else {
						hurtmonster=(int)(hurtmonster*1.2);
						player.injure(hurtmonster);
						message=message+"第"+n+"回合："+monster.getName()+"打出了暴击!"+"你受到了"+hurtmonster+"点伤害。 ";
					}
				}
			//}
			n++;
			}
		if(player.getMp()<=0&&monster.getMp()<=0) {
			message=message+"你击败了"+monster.getName()+"，但是你死去了。 ";
			player.setMp(0);
			try {
				PlayerUpdate.playerupdate(player);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				MessageManagement.showToPlayer(player, message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			if(player.getMp()<=0) {
				message=message+"你输了，你死去了。 ";
				player.setMp(0);
				try {
					PlayerUpdate.playerupdate(player);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					MessageManagement.showToPlayer(player, message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(monster.getMp()<=0) {
				message=message+"你赢了，获得了"+monster.getExp()+"点经验.";
				player.addexp(monster.getExp());
				try {
					PlayerUpdate.playerupdate(player);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					MessageManagement.showToPlayer(player, message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
