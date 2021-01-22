package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NineGrid {
	private JFrame window = new JFrame("NineGrid");
	private Container contentPane;
	
	private JPanel btnPanel = new JPanel();
	private Button exitBtn = new Button("Exit");
	
	private JPanel gamePanel = new JPanel();
	public NineGridPanel nineGridPanel = new NineGridPanel();
	
	private void setWindow() {
		window.setUndecorated(true);
		window.getGraphicsConfiguration().getDevice().setFullScreenWindow(window);
		
		contentPane = window.getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.black);
		contentPane.add(btnPanel);
		contentPane.add(gamePanel);
		
		// set gamePanel
		gamePanel.setBounds(contentPane.getWidth()/3,contentPane.getHeight()/4,contentPane.getWidth()*2/3,contentPane.getHeight()/4+contentPane.getWidth()/3);
		gamePanel.setSize(contentPane.getWidth()/3,contentPane.getWidth()/3);
		gamePanel.setLayout(null);
		gamePanel.add(nineGridPanel);
		
		nineGridPanel.setBackground(Color.white);
		nineGridPanel.setBounds(0,0,gamePanel.getWidth(),gamePanel.getHeight());
		nineGridPanel.setSize(gamePanel.getWidth(),gamePanel.getWidth());
		System.out.println(gamePanel.getWidth());
		
		// set Button
		btnPanel.setBounds(contentPane.getWidth()*3/4,contentPane.getHeight()*3/4,contentPane.getWidth(),contentPane.getHeight());
		btnPanel.setSize(contentPane.getWidth()/4,contentPane.getHeight()/4);
		btnPanel.setBackground(Color.black);
		btnPanel.add(exitBtn,BorderLayout.SOUTH);
		
		exitBtn.setFont(new Font("Courier New", Font.BOLD, 50));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	window.dispose();
            }
        });
        exitBtn.setBounds(0,0,btnPanel.getWidth(),btnPanel.getHeight());
        exitBtn.setSize(btnPanel.getWidth(),btnPanel.getHeight());
	}
	
	public void openWindow() {
		setWindow();
		window.setVisible(true);
	}

}

class NineGridPanel extends JPanel{
	
	@Override
	public void paint(Graphics g)
	{
		//1.呼叫父類函式完成初始化
		super.paint(g);	
		
		g.drawRect(0,0,this.getWidth(),this.getHeight());
		g.drawLine(0,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
		g.drawLine(0,this.getHeight()*2/3,this.getWidth(),this.getHeight()*2/3);
		g.drawLine(this.getWidth()/3,0,this.getWidth()/3,this.getHeight());
		g.drawLine(this.getWidth()*2/3,0,this.getWidth()*2/3,this.getHeight());
		//畫填充矩形
//		g.setColor(Color.BLUE);		//設定顏色
//		g.fillRect(80,60,40,60);
		
	}
}