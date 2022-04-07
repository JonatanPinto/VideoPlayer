package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import model.ManagerVideo;
import view.MainWindow;

public class Controller implements ActionListener {
	
	private MainWindow mainWindow;
	private ManagerVideo managerVideo;
	private static Controller controller;
	
	public static Controller get() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	private Controller() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case PLAY:
			mainWindow.getVideoPlayer().getPlayer().getPlayer().play();
			break;
		case PAUSE:
			mainWindow.getVideoPlayer().getPlayer().getPlayer().pause();
			break;
		case NEXT:
			mainWindow.getVideoPlayer().getPlayer().getPlayer().stop();
			mainWindow.getVideoPlayer().getPlayer().player(new File("D:\\Jonatán\\Videos\\Films\\Avenged Sevenfold - So far away Sub Español.mp4"));
		default:
			break;
		}
	}
	
	public void setView(MainWindow window) {
		mainWindow = window;
	}
	
	public void setModel(ManagerVideo manager) {
		managerVideo = manager;
	}
	
	public void play() {
		mainWindow.setVisible(true);
	}
}
