package gui;

import org.json.JSONArray;

public class PlayerPanelUpdater{
	private NineGrid nineGrid;
	
	public PlayerPanelUpdater(NineGrid nineGrid) {
		this.nineGrid = nineGrid;
	}
	public void update(JSONArray dataArr) {
		System.out.println("Updata playerPanel");
		nineGrid.getGamePanel().remove(nineGrid.getPlayerPanel());
//		System.out.println("Data before updating playerPanel:"+dataArr);
		nineGrid.getGamePanel().add(new PlayerPanel(dataArr));
		nineGrid.getGamePanel().revalidate();
	}
}
