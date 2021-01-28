package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class NineGridPanelFrame extends JPanel{
	public static final long serialVersionUID = 1L;
	
	@Override
	public void paint(Graphics g)
	{
		System.out.println("Paint new nineGridPanel");
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(7));

		//1.呼叫父類函式完成初始化
		super.paintComponent(g2);	
		
		g2.drawRect(0,0,this.getWidth(),this.getHeight());
		g2.drawLine(0,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
		g2.drawLine(0,this.getHeight()*2/3,this.getWidth(),this.getHeight()*2/3);
		g2.drawLine(this.getWidth()/3,0,this.getWidth()/3,this.getHeight());
		g2.drawLine(this.getWidth()*2/3,0,this.getWidth()*2/3,this.getHeight());
	}

}
