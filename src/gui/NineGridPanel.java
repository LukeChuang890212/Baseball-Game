package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NineGridPanel extends JPanel{
	public static final long serialVersionUID = 1L;
	
	public GridPanel[][] gridPanels;
	public JLabel[][] panelLbs;
	
	public JLabel panelLb1;
	public JLabel panelLb2;
	public JLabel panelLb3;
	public JLabel panelLb4;
	public JLabel panelLb5;
	public JLabel panelLb6;
	public JLabel panelLb7;
	public JLabel panelLb8;
	public JLabel panelLb9;
	
	public GridPanel gridPanel1;
	public GridPanel gridPanel2;
	public GridPanel gridPanel3;
	public GridPanel gridPanel4;
	public GridPanel gridPanel5;
	public GridPanel gridPanel6;
	public GridPanel gridPanel7;
	public GridPanel gridPanel8;
	public GridPanel gridPanel9;
	
	public NineGridPanelFrame nineGridPanelFrame;
	
	public NineGridPanel() {
		System.out.println("New NineGridPanel()");
		
		this.panelLbs = new JLabel[3][3];
		this.gridPanels = new GridPanel[3][3];
		
		this.panelLb1 = new JLabel();
		this.panelLb2 = new JLabel();
		this.panelLb3 = new JLabel();
		this.panelLb4 = new JLabel();
		this.panelLb5 = new JLabel();
		this.panelLb6 = new JLabel();
		this.panelLb7 = new JLabel();
		this.panelLb8 = new JLabel();
		this.panelLb9 = new JLabel();
		
		
		this.gridPanel1 = new GridPanel();
		this.gridPanel2 = new GridPanel();
		this.gridPanel3 = new GridPanel();
		this.gridPanel4 = new GridPanel();
		this.gridPanel5 = new GridPanel();
		this.gridPanel6 = new GridPanel();
		this.gridPanel7 = new GridPanel();
		this.gridPanel8 = new GridPanel();
		this.gridPanel9 = new GridPanel();
		
		this.nineGridPanelFrame = new NineGridPanelFrame();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		System.out.println("Paint new nineGridPanel");
		
		Graphics2D g2 = (Graphics2D) g;
		
		//1.呼叫父類函式完成初始化
		super.paintComponent(g2);
		
		setNineGridPanel();
		
		this.add(nineGridPanelFrame,0);
		nineGridPanelFrame.setBackground(null);
		nineGridPanelFrame.setOpaque(false);
		nineGridPanelFrame.setBounds(0,0,this.getWidth(),this.getHeight());
		nineGridPanelFrame.setSize(this.getWidth(),this.getWidth());
	}
	
	public void setNineGridPanel() {
		gridPanels[0][0] = gridPanel1;
		gridPanels[0][1] = gridPanel2;
		gridPanels[0][2] = gridPanel3;
		gridPanels[1][0] = gridPanel4;
		gridPanels[1][1] = gridPanel5;
		gridPanels[1][2] = gridPanel6;
		gridPanels[2][0] = gridPanel7;
		gridPanels[2][1] = gridPanel8;
		gridPanels[2][2] = gridPanel9;
		
		panelLbs[0][0] = panelLb1;
		panelLbs[0][1] = panelLb2;
		panelLbs[0][2] = panelLb3;
		panelLbs[1][0] = panelLb4;
		panelLbs[1][1] = panelLb5;
		panelLbs[1][2] = panelLb6;
		panelLbs[2][0] = panelLb7;
		panelLbs[2][1] = panelLb8;
		panelLbs[2][2] = panelLb9;
		
		
		for(int i = 0; i < gridPanels.length; i++) {
			for(int j = 0; j < gridPanels[i].length; j++) {
				System.out.println("add gridPanel");
				
				gridPanels[i][j].setBounds(this.getWidth()/3*j,this.getHeight()/3*i,this.getWidth()/3*(j+1),this.getHeight()/3*(i+1));
				gridPanels[i][j].setSize(this.getWidth()/3,this.getHeight()/3);
				gridPanels[i][j].setBackground(Color.white);
				gridPanels[i][j].setLayout(null);
				
				panelLbs[i][j].setText(String.valueOf(i*3+j+1));
				panelLbs[i][j].setBounds(gridPanels[i][j].getWidth()/3+3,gridPanels[i][j].getHeight()/3-15,gridPanels[i][j].getWidth()*2/3,gridPanels[i][j].getHeight()*2/3);
				panelLbs[i][j].setFont (gridPanels[i][j].getFont ().deriveFont (64.0f));
				
				this.add(gridPanels[i][j]);
				gridPanels[i][j].add(panelLbs[i][j]);
			}
		}
	}
	
	public GridPanel[][] getGridPanels(){
		return gridPanels;
	}
}
