package game;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
public Frame(){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800, 800);
	frame.setVisible(true);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.setResizable(false);
	frame.setTitle("Break Blocks!!!");
	//JPanel jp = new JPanel();
	GameLogic gl = new GameLogic();
	frame.add(gl);
	
	
}
public static void main(String[] args){
	Frame frame = new Frame();
	
}
}
