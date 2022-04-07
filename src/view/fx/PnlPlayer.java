package view.fx;

import java.awt.Color;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PnlPlayer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFXPanel jfxPanel;
	private Media media;
	private MediaPlayer player;
	private MediaView view;
	private Scene scene;
	private MultimetiaControlPlayer multimediaControlPlayer;
	private File file;	
	
	public PnlPlayer(File file, boolean multimediaBottons) {
		this.setSize(700, 400); 
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.file = file;
		jfxPanel = new JFXPanel();
		this.add(jfxPanel);
//		media = new Media(file.toURI().toString());
//		player = new MediaPlayer(media);
//		view = new MediaView(player);
		multimediaControlPlayer = new MultimetiaControlPlayer(file);
		media = multimediaControlPlayer.getMedia();
		player = multimediaControlPlayer.getPlayer();
		view = multimediaControlPlayer.getView();
		view.setFitHeight(930);
		view.setFitWidth(560);
		jfxPanel.setScene(scene);
	}
	
	public void player(File file) {
		media = new Media(file.toURI().toString());
		player = new MediaPlayer(media);
		view = new MediaView(player);
		view.setFitHeight(930);
		view.setFitWidth(560);
		multimediaControlPlayer = new MultimetiaControlPlayer(file);
		scene = new Scene(multimediaControlPlayer.getRoot());
		jfxPanel.setScene(scene);
	}

	public void createScene(boolean boton) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (boton == true) {
					player.play();// play video
				} else {
					player.pause();
				}
			}
		});
	}

	public JFXPanel getJfxPanel() {
		return jfxPanel;
	}

	public void setJfxPanel(final JFXPanel jfxPanel) {
		this.jfxPanel = jfxPanel;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(final Media media) {
		this.media = media;
	}

	public MediaPlayer getPlayer() {
		return player;
	}

	public void setPlayer(final MediaPlayer player) {
		this.player = player;
	}

	public MediaView getView() {
		return view;
	}

	public void setView(final MediaView view) {
		this.view = view;
	}

	public File getFile() {
		return file;
	}

	public void setFile(final File file) {
		this.file = file;
	}
}
