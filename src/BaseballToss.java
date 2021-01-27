import java.awt.Color;

import gui.NineGrid;
import gui.PlayerPanelUpdater;
import opencv.MoveDetector;
import dataReceiver.DataReceiver;

import org.json.JSONArray;

public class BaseballToss {
	public static void main(String[] args) {
		MoveDetector moveDetector = new MoveDetector();
		
		NineGrid nineGrid = new NineGrid();
		nineGrid.openWindow();
		nineGrid.gridPanels[0][0].setBackground(Color.black);
		
		PlayerPanelUpdater playerPanelUpdater = new PlayerPanelUpdater(nineGrid);
		
		DataReceiver dataReceiver = new DataReceiver(playerPanelUpdater);
		
		moveDetector.setPriority(1);
		dataReceiver.setPriority(5);
		
		moveDetector.start();
		dataReceiver.start();
		
		JSONArray arr;
		while(true){
			arr = dataReceiver.getDataArray(); 
			if(arr != null) {
				System.out.println(arr.length());
		        for (int i = 0; i < arr.length(); i++){
		        	for(int j = 0; j < arr.getJSONArray(i).length(); j++) {
		        		System.out.println(arr.getJSONArray(i).getJSONArray(j).getJSONArray(0).getInt(0)); 
		        	}
		        }
			}
		}
	}
}

