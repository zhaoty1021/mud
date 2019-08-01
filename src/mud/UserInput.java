package mud;

import java.io.IOException;

import mud.CommonContent.DIRECTION;

public class UserInput {
	/*
	 * 可以处理的命令 e,east,w,west,n,north,s,south,ne,northeast,sw,southwest,
	 * se,southeast,nw,northwest,u,up,d,down,who,exit,npc,monster,ask,
	 * attack,tell,chat,passwd,quit
	 */
	public static void dealInput(Player player, String inputMessage) {
	String[] inputs = inputMessage.split(" ");
	if (inputs[0].equals("quit")) {
		player.quit();
		return;
	}
	if (inputs[0].equals("e") || inputs[0].equals("east")) {
		player.move(DIRECTION.EAST);
		return;
	}
	if (inputs[0].equals("w") || inputs[0].equals("west")) {
		player.move(DIRECTION.WEST);
		return;
	}
	if (inputs[0].equals("s") || inputs[0].equals("south")) {
		player.move(DIRECTION.SOUTH);
		return;
	}
	if (inputs[0].equals("n") || inputs[0].equals("north")) {
		player.move(DIRECTION.NORTH);
		return;
	}
	if (inputs[0].equals("ne") || inputs[0].equals("northeast")) {
		player.move(DIRECTION.NORTHEAST);
		return;
	}
	if (inputs[0].equals("nw") || inputs[0].equals("northwest")) {
		player.move(DIRECTION.NORTHWEST);
		return;
	}
	if (inputs[0].equals("se") || inputs[0].equals("southeast")) {
		player.move(DIRECTION.SOUTHEAST);
		return;
	}
	if (inputs[0].equals("sw") || inputs[0].equals("southwest")) {
		player.move(DIRECTION.SOUTHWEST);
		return;
	}
	if (inputs[0].equals("u") || inputs[0].equals("up")) {
		player.move(DIRECTION.UP);
		return;
	}
	if (inputs[0].equals("d") || inputs[0].equals("down")) {
		player.move(DIRECTION.DOWN);
		return;
	} 
	if (inputs[0].equals("who")) {
		player.listothers();
		return;
	} 
	if (inputs[0].equals("exit")) {    //出口
		player.listexit();
		return;
	}
	if (inputs[0].equals("npc")) {
		player.listnpc();
		return;
	}
	if (inputs[0].equals("monster")) {
		player.listmonster();
		return;
	}
	if (inputs[0].equals("ask")) {
		player.asknpc(inputs[1]);
		return;
	}
	if (inputs[0].equals("attack")) {
		player.attack(inputs[1]);
		return;
	}
	if (inputs[0].equals("passwd")) {
		player.changepasswd(inputs[1]);
		return;
	}
	if (inputs[0].equals("tell")) {
		player.messagewho(inputs[1], inputs[2]);
		return;
	}
	if (inputs[0].equals("chat")) {
		player.chatAll(inputs[1]);
		return;
	}else
		try {
			MessageManagement.showToPlayer(player, "什么？");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}