package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PnlImage extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path;
	public PnlImage(String path) {
		this.path = path;
		this.setSize(100, 100);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		g2.drawImage(new ImageIcon(path).getImage(),0,0,this.getWidth(),this.getHeight(),null);
		
	}
}
