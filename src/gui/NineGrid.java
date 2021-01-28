package gui;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class NineGrid {
	private JFrame window;
	private Container contentPane;
	private MenuPanel menuPanel;
	private GamePanel gamePanel;
			
	public NineGrid(){
		this.window = new JFrame("NineGrid");
		this.menuPanel = new MenuPanel();
		this.gamePanel = new GamePanel();
	}
	
	private void setWindow() {
		window.setUndecorated(true);
		window.getGraphicsConfiguration().getDevice().setFullScreenWindow(window);
		window.setBackground(Color.black);
		
		contentPane = window.getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.black);
		
		contentPane.add(gamePanel);
		contentPane.add(menuPanel);
		
		// set gamePanel
		gamePanel.setBackground(Color.blue);
		gamePanel.setBounds(0,contentPane.getHeight()/4-100,contentPane.getWidth()*2/3+100,contentPane.getHeight());
		gamePanel.setSize(contentPane.getWidth()*2/3+100,contentPane.getHeight()*3/4+100);
//		gamePanel.setLayout(null);

		// set menuPanel
		menuPanel.setBackground(Color.black);
		menuPanel.setBounds(contentPane.getWidth()*3/4,contentPane.getHeight()*3/4,contentPane.getWidth(),contentPane.getHeight());
		menuPanel.setSize(contentPane.getWidth()/4,contentPane.getHeight()/4);
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	public void openWindow() {
		setWindow();
		window.setVisible(true);
	}
}
