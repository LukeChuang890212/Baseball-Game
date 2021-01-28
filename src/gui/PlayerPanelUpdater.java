package gui;

import org.json.JSONArray;

public class PlayerPanelUpdater{
	private NineGrid nineGrid;
	private GamePanel gamePanel;
	private PlayerPanel playerPanel;
	
	public PlayerPanelUpdater(NineGrid nineGrid) {
		this.nineGrid = nineGrid;	
	}
	
	public void update(JSONArray dataArr) {
		System.out.println("Updata playerPanel");
//		System.out.println("Data before updating playerPanel:"+dataArr);
		
		gamePanel = nineGrid.getGamePanel();
		playerPanel = nineGrid.getGamePanel().getPlayerPanel();
		
		PlayerPanel newPlayerPanel = new PlayerPanel(dataArr);
		
		gamePanel.remove(playerPanel);
		gamePanel.setPlayerPanel(newPlayerPanel);
		gamePanel.repaint();
	}
}
