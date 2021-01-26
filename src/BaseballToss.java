import java.awt.Color;

import gui.NineGrid;
import opencv.MoveDetector;
import dataReceiver.DataReceiver;

import org.json.JSONArray;

public class BaseballToss {
	public static void main(String[] args) {
		MoveDetector moveDetector = new MoveDetector();
		moveDetector.start();
		
		DataReceiver dataReceiver = new DataReceiver();
		dataReceiver.start();
		
		NineGrid nineGrid = new NineGrid(dataReceiver);
		nineGrid.openWindow();
		nineGrid.gridPanels[0][0].setBackground(Color.black);
		
//		JSONArray arr;
//		while(true){
//			arr = dataReceiver.getDataArray(); 
//			if(arr != null) {
//				System.out.println(arr.length());
//		        for (int i = 0; i < arr.length(); i++){
//		        	for(int j = 0; j < arr.getJSONArray(i).length(); j++) {
//		        		System.out.println(arr.getJSONArray(i).getJSONArray(j).getJSONArray(0).getInt(0)); 
//		        	}
//		        }
//			}
//		}
	}
}

