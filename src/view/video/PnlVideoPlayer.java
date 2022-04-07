package view.video;

import javax.swing.JPanel;

import view.PnlButtons;
import view.fx.PnlPlayer;

import java.awt.BorderLayout;
import java.io.File;


public class PnlVideoPlayer extends JPanel {


	private static final long serialVersionUID = 1L;
	private PnlPlayer player;
	private PnlButtons buttons;
	private File file;
	 public PnlVideoPlayer(File file) {
		this.file = file;
		this.setSize(700, 400); 
		init();
		
	}
	
	public void init() {
		this.setLayout(new BorderLayout()); 
		player = new PnlPlayer(file,true);
        this.add(player, BorderLayout.CENTER);     
        buttons = new PnlButtons();
        this.add(buttons, BorderLayout.SOUTH);
	}
	
	public void play() {
		player.createScene(false);
	}
	
	public void pause() {
		player.createScene(true);
	}

	public PnlPlayer getPlayer() {
		return player;
	}
	
	public void next() {
//		player.next(new File("D:\\Jonatán\\Videos\\Films\\Avenged Sevenfold - So far away Sub Español.mp4"));
	}

	public void setPlayer(PnlPlayer player) {
		this.player = player;
	}
}
