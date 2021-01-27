package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.json.JSONArray;

public class PlayerPanel extends JPanel{
	public static final long serialVersionUID = 1L;
	
	private JSONArray dataArr;
	public PlayerPanel(JSONArray dataArr) {
		this.dataArr = dataArr;
		System.out.println("Data before updating playerPanel:"+dataArr);
	}
	
	@Override
	public void paint(Graphics g)
	{
		System.out.println("paint new playerPanel");
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        
		//1.呼叫父類函式完成初始化
		super.paint(g2);
		
		JSONArray point;
		System.out.println("Data used to paint:"+dataArr);
		if(dataArr != null) {
			for (int i = 0; i < dataArr.length(); i++){
	        	for(int j = 0; j < dataArr.getJSONArray(i).length(); j++) {
	        		point = dataArr.getJSONArray(i).getJSONArray(j).getJSONArray(0); 
	        		g2.drawLine(point.getInt(0),point.getInt(1),point.getInt(0),point.getInt(1));
	        	}
	        }
		}
	}
}
