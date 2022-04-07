package view.video;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PnlTopVideo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int LENGTH = 400;
	private int points;
	public PnlTopVideo(int sizeTop) {
		this.setSize(LENGTH, LENGTH);
		points = 360 / sizeTop;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		g.drawLine(0, LENGTH/2, LENGTH, LENGTH/2);
//		g.drawLine(LENGTH/2, 0, LENGTH/2, LENGTH);
		for (int i = 0; i < 360; i = i + points) {
			drawXY(g, i, (LENGTH/2) - 40);
		}
	}
	
	public void drawXY(Graphics g,double angle,int radius) {
		double rad = ((2*Math.PI) * angle)/360;
		int x = (int) (radius * Math.cos(rad));
		int y = (int) (radius * Math.sin(rad));
//		g.drawLine(LENGTH/2,LENGTH/2 , x + (LENGTH/2), y + (LENGTH/2));
		g.fillOval(x + (LENGTH/2), y + (LENGTH/2), 10, 10);
//		System.out.println("Coordenadas ( " + x + " , " + y + " )");
	}
}
