package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import opencv.MoveDetector;

public class MenuPanel extends JPanel{
	public static final long serialVersionUID = 1L;
	
	public MenuPanel() {
		ExitBtn exitBtn = new ExitBtn();
		
		this.add(exitBtn,BorderLayout.SOUTH);
		
		exitBtn.setText("Exit");
		exitBtn.setFont(new Font("Courier New", Font.BOLD, 50));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MoveDetector.process.destroy();
            	System.exit(0);
            }
        });
        exitBtn.setBounds(0,0,this.getWidth(),this.getHeight());
        exitBtn.setSize(this.getWidth(),this.getHeight());
	}
}
