package gui;

import javax.swing.JPanel;

import dataReceiver.DataReceiver;

public class PlayerPanelUpdater {
	public void update(JPanel gamePanel, JPanel origPanel, DataReceiver dataReceiver) {
		while(true) {
			gamePanel.remove(origPanel);
			gamePanel.add(new PlayerPanel(dataReceiver));
			gamePanel.revalidate();
		}
	}
}
