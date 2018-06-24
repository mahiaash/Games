package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bricks {
	int [][] bricks;
	int brickWidth;
	int brickHeight;
	public final int HOR_PAD = 80,VERT_PAD =50;
	public Bricks(){
		bricks = new int [3][7];
		for(int i = 0; i<3;i++){
			for(int j =0; j<7;j++){
				bricks[i][j] = 1;
			}
		}
		brickWidth = 540/7;
		brickHeight = 150/3;
	}
	public void paint(Graphics2D g){
	 for(int i = 0; i < 3; i++){
		 for(int j =0; j< 7;j++){
			if(bricks [i][j] >0){
					g.setColor(Color.WHITE);
					g.fillRect(j*brickWidth + HOR_PAD, i*brickHeight+VERT_PAD, brickWidth, brickHeight);
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.BLACK);
					g.drawRect(j*brickWidth + HOR_PAD, i*brickHeight+VERT_PAD, brickWidth, brickHeight);
				
			}
		 }
	 }
		
	}
	public void setBrickValue(int value, int rows, int cols){
		bricks[rows][cols] = value;
	}
}
