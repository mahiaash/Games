package game;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Frame extends JPanel implements Runnable  {
	JFrame frame;
	@Override
	public void run() {
	frame = new JFrame();
	Model model = new Model();
	frame.setBounds(10,10,700,600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.getContentPane().setBackground(Color.black);
	frame.add(model);
	
	}
	

}
