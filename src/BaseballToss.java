import java.awt.Color;

import gui.NineGrid;
import gui.PlayerPanelUpdater;
import opencv.MoveDetector;
import dataReceiver.DataReceiver;

import org.json.JSONArray;

public class BaseballToss {
	public static void main(String[] args) throws InterruptedException{
		NineGrid nineGrid = new NineGrid();
		nineGrid.openWindow();
//		nineGrid.gridPanels[0][0].setBackground(Color.black);
		
		PlayerPanelUpdater playerPanelUpdater = new PlayerPanelUpdater(nineGrid);
		
		DataReceiver dataReceiver = new DataReceiver(playerPanelUpdater);
		
		MoveDetector moveDetector = new MoveDetector(dataReceiver);
		moveDetector.detect();
	}
}

