package game;

import javax.swing.SwingUtilities;

public class Driver {
	public static void main(String[] args) {
		SwingUtilities.invokeLater((Runnable) new Frame());
		}
}
