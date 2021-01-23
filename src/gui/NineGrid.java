package gui;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NineGrid {
	private JFrame window = new JFrame("NineGrid");
	private Container contentPane;
	
	private JPanel btnPanel = new JPanel();
	private Button exitBtn = new Button("Exit");
	
	private JPanel gamePanel = new JPanel();
	public NineGridPanel nineGridPanel = new NineGridPanel();
	public PlayerPanel playerPanel = new PlayerPanel();
	
	public JPanel[][] gridPanels = new JPanel[3][3];
	
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
//		gamePanel.add(playerPanel);
		
		nineGridPanel.setBackground(Color.white);
		nineGridPanel.setBounds(gamePanel.getWidth()*2/3,0,gamePanel.getWidth(),gamePanel.getWidth()/3);
		nineGridPanel.setSize(gamePanel.getWidth()/3,gamePanel.getWidth()/3);
		
		playerPanel.setBackground(Color.red);
		playerPanel.setBounds(0,0,gamePanel.getWidth()*2/3,gamePanel.getHeight());
		playerPanel.setSize(gamePanel.getWidth()*2/3,gamePanel.getHeight());
		
		// set btnPanel
		btnPanel.setBounds(contentPane.getWidth()*3/4,contentPane.getHeight()*3/4,contentPane.getWidth(),contentPane.getHeight());
		btnPanel.setSize(contentPane.getWidth()/4,contentPane.getHeight()/4);
		btnPanel.setBackground(Color.black);
		btnPanel.add(exitBtn,BorderLayout.SOUTH);
		
		exitBtn.setFont(new Font("Courier New", Font.BOLD, 50));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	window.dispose();
            }
        });
        exitBtn.setBounds(0,0,btnPanel.getWidth(),btnPanel.getHeight());
        exitBtn.setSize(btnPanel.getWidth(),btnPanel.getHeight());
	}
	
	public void openWindow() {
		setWindow();
		window.setVisible(true);
	}
	
	class NineGridPanel extends JPanel{
		
		@Override
		public void paint(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
	        g2.setStroke(new BasicStroke(10));
	        
			//1.呼叫父類函式完成初始化
			super.paint(g2);	
			
			g2.drawRect(0,0,this.getWidth(),this.getHeight());
			g2.drawLine(0,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
			g2.drawLine(0,this.getHeight()*2/3,this.getWidth(),this.getHeight()*2/3);
			g2.drawLine(this.getWidth()/3,0,this.getWidth()/3,this.getHeight());
			g2.drawLine(this.getWidth()*2/3,0,this.getWidth()*2/3,this.getHeight());
			
			for(int i = 0; i < gridPanels.length; i++) {
				for(int j = 0; j < gridPanels[i].length; j++) {
					JPanel gridPanel = new JPanel();
					JLabel panelLb = new JLabel();
					
					gridPanel.setBounds(this.getWidth()/3*j,this.getHeight()/3*i,this.getWidth()/3*(j+1),this.getHeight()/3*(i+1));
					gridPanel.setSize(this.getWidth()/3,this.getHeight()/3);
					gridPanel.setBackground(Color.white);
					gridPanel.setLayout(null);
					gridPanel.add(panelLb);
					
					panelLb.setText(String.valueOf(i*3+j+1));
					panelLb.setBounds(gridPanel.getWidth()/3+3,gridPanel.getHeight()/3-15,gridPanel.getWidth()*2/3,gridPanel.getHeight()*2/3);
					panelLb.setFont (panelLb.getFont ().deriveFont (64.0f));
					
					this.add(gridPanel);
					gridPanels[i][j] = gridPanel;
				}
			}
		}
	}
	
	class PlayerPanel extends JPanel{
		
	}
}
