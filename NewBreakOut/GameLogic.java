package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameLogic extends JPanel{
	EasyBlock eBlock;
	JPanel panel;
	public GameLogic(){
		eBlock = new EasyBlock();
		
	}
	
	
	public void paint(Graphics g){
		// draw bar
		g.setColor(Color.MAGENTA);
		g.fillRect(100, 600, 90, 10);
		
		// draw ball
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(50, 400, 25, 25);
		// draw the boxes
		//g.setColor(Color.ORANGE);
		eBlock.drawRectangle((Graphics2D)g);
		//g.setColor(Color.ORANGE);
	}
	
	
	
	
	
	
	
	
	
}
