package mud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import data.PlayerAdd;	 
import data.PlayerQuery;

public class Server implements Runnable{
	private Socket s=null;
	private ServerSocket ss=null;
	public static Vector<PlayerThread> clients=new Vector<PlayerThread>();
    public static Map<String,PlayerThread> playerThread = new HashMap<String,PlayerThread>();
	public Server() throws Exception{
		ss=new ServerSocket(6066);
		new Thread(this).start();
	}
	public void run() {
		try {
			while(true) {
				s=ss.accept();
				PlayerThread ct=new PlayerThread(s);
				clients.add(ct);
				ct.start();
			}
		}catch(Exception ex) {
		}
	}
	
	class PlayerThread extends Thread{
		@SuppressWarnings("unused")
		private Socket s=null;
		private BufferedReader br=null;
		private BufferedWriter out=null;
		private Player player;
		public PlayerThread(Socket s) throws Exception{
			this.s=s;
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		}
		public void run() {
			try {
				RoomManagement.creatRooms();
				NPCManagement.creatNPC();
				this.out.write("Welcome！\n");
				this.out.flush();
				String userId=this.br.readLine();
				playerThread.put(userId,clients.get(clients.size()-1));
				player=new Player();
				player=PlayerQuery.playerquery(userId);
				if(player.getId()!=null) {
					MessageManagement.addPlayerChannels(userId, this.out);
					//playerThread.put(userId,clients.get(clients.size()-1));
					this.out.write("请输入密码：\n");
					this.out.flush();
					String passwd=this.br.readLine();
					this.out.write("********\n");
					this.out.flush();
					while(!passwd.equals(player.getPasswd())) {
						this.out.write("密码错误，请重新输入：\n");
						this.out.flush();
						passwd=this.br.readLine();
						this.out.write("********\n");
						this.out.flush();
					}
					player.connect();
				}else {
					MessageManagement.addPlayerChannels(userId, this.out);
					//playerThread.put(userId,clients.get(clients.size()-1));
					this.out.write(userId+"\n");
					this.out.flush();
					String userName=this.br.readLine();
					this.out.write(userName+"\n");
					this.out.flush();
					this.out.write("请输入密码：\n");
					this.out.flush();
					String passwd=this.br.readLine();
					this.out.write("********\n");
					this.out.flush();
					player=new Player(userId,0,50,50,50,50,50,50,0,0,0,"non",userName,"shenzhou_center",passwd);
					PlayerAdd.playeradd(player);
					player.connect();
				}
				while(true) {
					String str=br.readLine();
					MessageManagement.showToPlayer(player, str);
					UserInput.dealInput(player, str);
				}
			}catch(Exception ex) {
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new Server();
	}

}
