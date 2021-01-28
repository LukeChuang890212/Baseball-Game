package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import dataReceiver.DataReceiver;

public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private NineGridPanel nineGridPanel;
	private PlayerPanel playerPanel;
	
	public GamePanel() {
		this.setLayout(null);
		
		this.nineGridPanel = new NineGridPanel();
		this.playerPanel = new PlayerPanel(DataReceiver.dataArr);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		System.out.println("Paint new nineGamePanel");
		
		Graphics2D g2 = (Graphics2D) g;
		
		//1.呼叫父類函式完成初始化
		super.paintComponent(g2);
		
		setGamePanel();
	}
	public void setGamePanel() {	
		this.add(nineGridPanel);
		this.add(playerPanel);
		
		nineGridPanel.setBackground(Color.white);
		nineGridPanel.setBounds(this.getWidth()*2/3,0,this.getWidth(),this.getWidth()/3);
		nineGridPanel.setSize(this.getWidth()/3,this.getWidth()/3); 
		
		playerPanel.setBackground(Color.black);
		playerPanel.setBounds(0,0,this.getWidth()*2/3,this.getHeight());
		playerPanel.setSize(this.getWidth()*2/3,this.getHeight());
	}
	
	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}
	
	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}
}
