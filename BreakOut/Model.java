package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Model extends JPanel implements KeyListener,ActionListener{
	boolean f = false; // the game should not start playing by itself
	int score = 0;  // the score of the game
	int numBricks = 21; // how many bricks
	Timer timerClock; // the timer for how long it takes to break the bricks
	int time = 8; // the time of the timer
	int playerX = 310;  // the position of the player by the x axis
	int ballPosX = 120; // ball position in the x axis
	int ballPosY = 350; // ball position in the y axis
	int ballDircX = -1; // ball movement in the x direction 
	int ballDircY = -2; // ball movement in the y direction
	Bricks b;
	static final int WIDTH = 640;
	static final int HEIGHT = 480;
	public Model(){
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
	timerClock = new Timer(time,this); // creating timer object
	timerClock.start(); // starting timer
	b = new Bricks();
	}
public void paint(Graphics g){
	//Background
	g.setColor(Color.BLACK);
	g.fillRect(1, 1, 692, 592);
	//Draw Bricks
	b.paint((Graphics2D) g);
	// Border
	g.setColor(Color.YELLOW);
	//Rectangles
	g.fillRect(0, 0, 3, 592);
	g.fillRect(0, 0, 692, 3);
	g.fillRect(691, 0, 3, 592);
	//Score
	g.setColor(Color.GREEN);
	g.setFont(new Font("serif",Font.BOLD,25));
	g.drawString(""+score, 590, 30);
	
	//Scrolling Bar
	g.setColor(Color.RED);
	g.fillRect(playerX, 550, 100, 8);
	//Ball
	g.setColor(Color.MAGENTA);
	g.fillOval(ballPosX, ballPosY, 20, 20);
	
	if(numBricks <= 0){
		f = false;
		ballDircX = 0;
		ballDircY = 0;
		g.setColor(Color.ORANGE);
		g.setFont(new Font("serif",Font.BOLD,30));
		g.drawString("You Won!!", 260, 300);
		
		
		g.setFont(new Font("serif",Font.BOLD,20));
		g.drawString("Press Enter to Replay", 230, 350);
		
	}
	
	
	if(ballPosY > 570){
		f = false;
		ballDircX = 0;
		ballDircY = 0;
		g.setColor(Color.ORANGE);
		g.setFont(new Font("serif",Font.BOLD,30));
		g.drawString("Game Over  Score: "+score, 190, 300);
		
		
		g.setFont(new Font("serif",Font.BOLD,20));
		g.drawString("Press Enter to Replay", 230, 350);
		
	}
	
	
	g.dispose();
}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(playerX >= 600){
				playerX = 600;
			}
			else{
				f = true;
				playerX += 20;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(playerX < 10){
				playerX = 10;
			}
			else{
				f = true;
				playerX -= 20;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(!f){
				f = true;
				ballPosX = 120;
				ballPosY = 350;
				ballDircX = -1;
				ballDircY = -2;
				playerX = 310;
				score = 0;
				numBricks = 21;
				b = new Bricks();
				
				repaint();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timerClock.start();
		if(f){
			if(new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(playerX,550,100,8))){
				ballDircY =-ballDircY;
				}
		A:	for(int i =0; i<b.bricks.length;i++){
				for(int j=0; j<b.bricks[0].length;j++){
					if(b.bricks[i][j]>0){
						int brickX = j* b.brickWidth +80;
						int brickY = i*b.brickHeight + 50;
						int brickWidth = b.brickWidth;
						int brickHeight = b.brickHeight;
						
						Rectangle rectangle = new Rectangle(brickX,brickY,brickWidth,brickHeight);
						Rectangle ballRect = new Rectangle(ballPosX,ballPosY,20,20);
						Rectangle brickRect = rectangle;
						
						if(ballRect.intersects(brickRect)){
							b.setBrickValue(0,i,j);
							numBricks--;
							score += 5;
							
							if(ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width){
								ballDircX = -ballDircX;
							}
							else{
								ballDircY = -ballDircY;
							}
							break A;
						}
						
					}
				}
			}
			
			
			
			ballPosX += ballDircX;
			ballPosY += ballDircY;
			}
		if(ballPosX <0){
			ballDircX = -ballDircX;
		}
		if(ballPosY <0){
			ballDircY = -ballDircY;
		}
		if(ballPosX > 670){
			ballDircX = -ballDircX;
		}
		repaint();
	}

}
