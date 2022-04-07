package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JMBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu jmFile;
	private JMenuItem jIOpen;
	public JMBar() {
		jmFile = new JMenu("Archivo");
		jIOpen = new JMenuItem("Abrir");
		jmFile.add(jIOpen);
		this.add(jmFile);
	}
}
