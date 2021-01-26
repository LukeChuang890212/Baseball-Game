package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NineGridPanel extends JPanel{
	public static final long serialVersionUID = 1L;
	
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        
		//1.呼叫父類函式完成初始化
		super.paint(g2);	
		
		g2.drawRect(0,0,this.getWidth(),this.getHeight());
		g2.drawLine(0,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
		g2.drawLine(0,this.getHeight()*2/3,this.getWidth(),this.getHeight()*2/3);
		g2.drawLine(this.getWidth()/3,0,this.getWidth()/3,this.getHeight());
		g2.drawLine(this.getWidth()*2/3,0,this.getWidth()*2/3,this.getHeight());
		
		for(int i = 0; i < gridPanels.length; i++) {
			for(int j = 0; j < gridPanels[i].length; j++) {
				JPanel gridPanel = new JPanel();
				JLabel panelLb = new JLabel();
				
				gridPanel.setBounds(this.getWidth()/3*j,this.getHeight()/3*i,this.getWidth()/3*(j+1),this.getHeight()/3*(i+1));
				gridPanel.setSize(this.getWidth()/3,this.getHeight()/3);
				gridPanel.setBackground(Color.white);
				gridPanel.setLayout(null);
				gridPanel.add(panelLb);
				
				panelLb.setText(String.valueOf(i*3+j+1));
				panelLb.setBounds(gridPanel.getWidth()/3+3,gridPanel.getHeight()/3-15,gridPanel.getWidth()*2/3,gridPanel.getHeight()*2/3);
				panelLb.setFont (panelLb.getFont ().deriveFont (64.0f));
				
				this.add(gridPanel);
				gridPanels[i][j] = gridPanel;
			}
		}
	}
}
