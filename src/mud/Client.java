package mud;

import java.net.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import data.PlayerQuery;

public class Client extends JFrame{
	private JTextArea area;
	private JTextField input;
	private JTextField port;
	private JTextField IP;
	private JTextField userName;
	private JTextArea playerstate;
	private JScrollPane leftPanel;
	private JScrollPane rightPanel;
	private JSplitPane  centerPanel;
	private Player player;
	private ClientThread ct;
	public int usersLength=0;
	
	Socket client;
	private boolean isConnect = false;
	public Client() {
		super("客户端");
		initUI();
	}
	private void initUI() {
		JPanel pNorth=initNorth();
		this.add(pNorth,BorderLayout.NORTH);
		JScrollPane pEast=initEast();
		this.add(pEast,BorderLayout.EAST);
		JScrollPane pCWest=initWest();
		centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pEast, pCWest);  
		centerPanel.setDividerLocation(100);
		this.add(centerPanel,BorderLayout.CENTER);
		JPanel pSouth=initSouth();
		this.add(pSouth,BorderLayout.SOUTH);
		this.setSize(640, 480);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private JPanel initNorth() {
		JPanel p=new JPanel();
		p.setBorder(new TitledBorder("connet information"));
		port = new JTextField(8);
		port.setText("6066");
		IP = new JTextField(8);
		IP.setText("127.0.0.1");
		userName = new JTextField(8);
		p.add(new JLabel("端口号"));
		p.add(port);
		p.add(new JLabel("服务器IP"));
		p.add(IP);
		p.add(new JLabel("用户名："));
		p.add(userName);
		
		JButton link=new JButton("CONNET");
		JButton discon=new JButton("STOP");
		link.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					client = new Socket(IP.getText(),Integer.parseInt(port.getText()));
					if(client!=null){
						port.setEditable(false);
						IP.setEditable(false);
						userName.setEditable(false);
						link.setEnabled(false);
						discon.setEnabled(true);
										
						if(isConnect==false){
							area.setFont(new Font("华文楷体",Font.BOLD,14));
							playerstate.setFont(new Font("华文楷体",Font.BOLD,12));
							playerstate.setForeground(Color.RED);
							BufferedWriter out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
							BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
							System.out.println(userName.getText());
							String st=br.readLine();
							area.append(st+"\n");
							out.write(userName.getText());
							out.newLine();
							out.flush();
							player=new Player();
							try {
								player=PlayerQuery.playerquery(userName.getText());
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(player.getId()!=null) {
								area.append(userName.getText()+"连接成功\n");
								area.append("欢迎回到世界！");
								area.append("用户名："+userName.getText()+"\n");								
								area.append("昵称："+player.getName()+"\n");
							}
							else {
								area.append(userName.getText()+"连接成功\n");
								area.append("欢迎来到这个神奇玄幻的世界!" + "\n");
								String str=br.readLine();
								System.out.println(str);
								area.append("用户名："+str+"\n");
								area.append("用户名未使用过 新建用户："+str+"\n"+"请输入昵称：");
							}
							isConnect=true;
						}
						ct = new ClientThread();
						ct.start();
					}			
				}catch(IOException s)
			      {
			         s.printStackTrace();
			      }
			}
		});
		discon.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(isConnect==true){
						isConnect=false;
						client.close();
						area.append("\n");
						area.append("你断开了连接。");
						port.setEditable(true);
						IP.setEditable(true);
						userName.setEditable(true);
						link.setEnabled(true);
						discon.setEnabled(false);
						ct.stop();
						}
				}catch(IOException s)
			      {
			         s.printStackTrace();
			      }
			}
		});
		p.add(link);
		p.add(discon);
		return p;
	}
	private JScrollPane initEast() {
		playerstate = new JTextArea();
		playerstate.setLineWrap(true);
		playerstate.setEditable(false);
		leftPanel =new JScrollPane(playerstate);
		leftPanel.setBorder(new TitledBorder("玩家属性"));
		return leftPanel;
	}
	private JScrollPane initWest(){
		area=new JTextArea();
		rightPanel =new JScrollPane(area);
		rightPanel.setBorder(new TitledBorder("Content"));
		area.setEditable(false);
		return rightPanel;
	}
	private JPanel initSouth() {
		JPanel p=new JPanel();
		p.setBorder(new TitledBorder("write"));
		input = new JTextField(50);
		input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					BufferedWriter out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					out.write(input.getText());
					out.newLine();
					out.flush();
					input.setText("");
				}catch(Exception e) {
				}
			}
		});
		p.add(input);
		return p;
	}
	public class ClientThread extends Thread{
		public void run() {
			while(true){
				try {	
					player=PlayerQuery.playerquery(userName.getText());
					playerstate.setText("");
					playerstate.append("经验:"+player.getExp()+"\n");
					playerstate.append("攻击:"+player.getAtk()+"\n");
					playerstate.append("防御:"+player.getDef()+"\n");
					playerstate.append("max法:"+player.getMax_hp()+"\n");
					playerstate.append("法:"+player.getHp()+"\n");
					playerstate.append("max血:"+player.getMax_mp()+"\n");
					playerstate.append("血:"+player.getMp()+"\n");
					playerstate.append("闪避:"+player.getSpd()+"\n");
					playerstate.append("暴击:"+player.getCr()+"\n");
					playerstate.append("现金:"+player.getCash()+"\n");
					playerstate.append("门派组织:"+player.getGrou()+"\n");
					playerstate.append("所在地:"+player.getPlace()+"\n");
					BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
					String str=br.readLine();
					area.append(MessageEdit.edit(str)+"\n");
					area.setCaretPosition(area.getText().length());
					}catch(Exception e) {
				}
			}
		}
	}
	public static void main(String[] args) {
		new Client();
	}
}
