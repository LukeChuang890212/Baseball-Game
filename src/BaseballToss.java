import java.awt.Color;

import gui.NineGrid;
import opencv.DetectThread;
import dataReceiver.DataReceiver;

public class BaseballToss {
	public static void main(String[] args) {		 
		NineGrid nineGrid = new NineGrid();
		nineGrid.openWindow();
		nineGrid.gridPanels[0][0].setBackground(Color.black);
		
		DataReceiver receiver = new DataReceiver();
		receiver.receive();
		
	}
}

