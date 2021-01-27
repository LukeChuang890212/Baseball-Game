package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import opencv.MoveDetector;
import dataReceiver.DataReceiver;

public class NineGrid {
	private JFrame window;
	private Container contentPane;
	
	private JPanel btnPanel;
	private Button exitBtn;
	
	public JPanel[][] gridPanels;
	public NineGridPanel nineGridPanel;
	public PlayerPanel playerPanel;
	private JPanel gamePanel;
			
	public NineGrid() {
		this.window = new JFrame("NineGrid");
//		this.contentPane;
		
		this.btnPanel = new JPanel();
		this.exitBtn = new Button("Exit");
		
		this.gridPanels = new JPanel[3][3];
		this.nineGridPanel = new NineGridPanel(this.gridPanels);
		this.playerPanel = new PlayerPanel(DataReceiver.dataArr);
		this.gamePanel = new JPanel();
	}
	
	private void setWindow() {
		window.setUndecorated(true);
		window.getGraphicsConfiguration().getDevice().setFullScreenWindow(window);
		
		contentPane = window.getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.black);
		contentPane.add(btnPanel);
		contentPane.add(gamePanel);
		
		// set gamePanel
		gamePanel.setBackground(Color.blue);
		gamePanel.setBounds(0,contentPane.getHeight()/4-100,contentPane.getWidth()*2/3+100,contentPane.getHeight());
		gamePanel.setLayout(null);
		gamePanel.add(nineGridPanel);
		gamePanel.add(playerPanel);
		
		nineGridPanel.setBackground(Color.white);
		nineGridPanel.setBounds(gamePanel.getWidth()*2/3,0,gamePanel.getWidth(),gamePanel.getWidth()/3);
		nineGridPanel.setSize(gamePanel.getWidth()/3,gamePanel.getWidth()/3);
		
		playerPanel.setBackground(Color.black);
		playerPanel.setBounds(0,0,gamePanel.getWidth()*2/3,gamePanel.getHeight());
		playerPanel.setSize(gamePanel.getWidth()*2/3,gamePanel.getHeight());
		
		// set btnPanel
		btnPanel.setBackground(Color.black);
		btnPanel.setBounds(contentPane.getWidth()*3/4,contentPane.getHeight()*3/4,contentPane.getWidth(),contentPane.getHeight());
		btnPanel.setSize(contentPane.getWidth()/4,contentPane.getHeight()/4);
		btnPanel.add(exitBtn,BorderLayout.SOUTH);
		
		exitBtn.setFont(new Font("Courier New", Font.BOLD, 50));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	window.dispose();
            	MoveDetector.process.destroy();
            }
        });
        exitBtn.setBounds(0,0,btnPanel.getWidth(),btnPanel.getHeight());
        exitBtn.setSize(btnPanel.getWidth(),btnPanel.getHeight());
	}
	
	public JPanel getGamePanel() {
		return gamePanel;
	}
	
	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}
	
	public void openWindow() {
		setWindow();
		window.setVisible(true);
	}
	
}
