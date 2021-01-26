package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.json.JSONArray;

import dataReceiver.DataReceiver;

public class PlayerPanel extends JPanel{
	public static final long serialVersionUID = 1L;
	
	private DataReceiver dataReceiver;
	public PlayerPanel(DataReceiver dataReceiver) {
		this.dataReceiver = dataReceiver;
	}
	
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        
		//1.呼叫父類函式完成初始化
		super.paint(g2);
		
		JSONArray dataArr;
		JSONArray point;
		dataArr = dataReceiver.getDataArray();
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
