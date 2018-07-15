package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class EasyBlock extends Block {
	int brickWidth;
	int brickHeight;
	public final int HOR_PAD = 80,VERT_PAD =50;
	
@Override
public void createSet(int row, int col) {
	// TODO Auto-generated method stub
	row = 3;
	col = 7;
}
@Override
public void drawRectangle(Graphics2D g){
	brickWidth = 540/7;
	brickHeight = 150/3;
	array = new int[3][7];
	
	for(int i = 0; i < array.length; i++ ){
		for(int j = 0; j < array[0].length; j++){
			g.setColor(Color.ORANGE);
			g.fillRect(j*brickWidth + HOR_PAD + 40, i * brickHeight + VERT_PAD, brickWidth, brickHeight);
			g.setStroke(new BasicStroke(2));
			g.setColor(Color.BLACK);
			g.drawRect(j*brickWidth + HOR_PAD + 40, i * brickHeight + VERT_PAD, brickWidth, brickHeight);
			g.setColor(Color.BLACK);
  			//g.drawRect(30 * y + y + i + x + 30 , x+x + j + y + 20 + 30, 90 * i * y + x * x + y+j + 30 *x, 30 * j + y);
	       // g.setColor(Color.ORANGE);
	       // g.fillRect(30 * y + y + i + x + 30 , x+x + j + y + 20 + 30, 90 * i * y + x * x + y+j + 30 *x, 30 * j + y);
		}
	}
	
	
	
	 		 
	 
		
	}
 
	
}
