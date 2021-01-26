package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerPanelUpdater {
	public void update(JPanel gamePanel, JPanel origPanel) {
		while(true) {
			gamePanel.remove(origPanel);
			gamePanel.add(createNewPanel());
			gamePanel.revalidate();
		}
	}
}
