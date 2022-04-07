package test;

import java.io.File;

import javax.swing.JFrame;

import view.fx.PnlPlayer;

public class TestFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestFrame() {
		this.setBounds(10, 10, 600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		PnlPlayer player = new PnlPlayer(new File("D:\\Jonatán\\Videos\\Films\\Ed Sheeran Lego House Rock COVER_HIGH.mp4"),true);
		this.add(player);
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		new TestFrame();
	}
}
