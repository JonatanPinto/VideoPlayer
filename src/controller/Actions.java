package controller;

import java.io.File;

import javax.swing.ImageIcon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public enum Actions {
	
	PLAY("PLAY","src/img/play-2.png"),
	PAUSE("PAUSE","src/img/pause-2.png"),
	STOP("STOP","src/img/stop-2.png"),
	NEXT("NEXT","src/img/fast-forward-2.png");

	private String command;
	private String pathIcon;
	
	
	private Actions(String command, String pathIcon) {
		this.command = command;
		this.pathIcon = pathIcon;
	}
	
	public String getCommand() {
		return command;
	}
	public ImageIcon getIcon() {
		java.awt.Image image = new ImageIcon(pathIcon).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT);
		return new ImageIcon(image);
	}
	
	public ImageView getIconFx() {
		File file = new File(pathIcon);
		ImageView imageView = new ImageView(new Image(file.toURI().toString()));
		imageView.setFitHeight(35);
		imageView.setFitWidth(35);
		return imageView;
	}
	
}
