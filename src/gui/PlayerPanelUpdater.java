package gui;

import java.awt.Color;

import javax.swing.JPanel;

import org.json.JSONArray;

public class PlayerPanelUpdater{
	private NineGrid nineGrid;
	private JPanel gamePanel;
	private PlayerPanel playerPanel;
	
	public PlayerPanelUpdater(NineGrid nineGrid) {
		this.nineGrid = nineGrid;	
	}
	public void update(JSONArray dataArr) {
		System.out.println("Updata playerPanel");
//		System.out.println("Data before updating playerPanel:"+dataArr);
		
		gamePanel = nineGrid.getGamePanel();
		playerPanel = nineGrid.getPlayerPanel();
		
		PlayerPanel newPlayerPanel = new PlayerPanel(dataArr);
		
		gamePanel.remove(playerPanel);
		gamePanel.add(newPlayerPanel);
		
		newPlayerPanel.setBackground(Color.black);
		newPlayerPanel.setBounds(0,0,gamePanel.getWidth()*2/3,gamePanel.getHeight());
		
		newPlayerPanel.repaint();
//		gamePanel.revalidate();
	}
}
