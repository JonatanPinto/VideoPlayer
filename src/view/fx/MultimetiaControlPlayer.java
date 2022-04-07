package view.fx;

import java.io.File;

import controller.Actions;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MultimetiaControlPlayer {
	
	private Slider sliderTime, volumen;
	private Label actualTime,totalTime,lbl_volumen,actual_volumen;
	private Button play,pause,stop,next;
	private Media media;
	private MediaPlayer player;
	private MediaView view;
	private File file;
	private VBox root;

	
	public MultimetiaControlPlayer(File file) {
		this.file = file;
		this.media = new Media(file.toURI().toString());
		this.player = new MediaPlayer(media);
		this.view = new MediaView(player);
		//----------------------------------------------------------
		setSliderTime(media, player);
		setVolumen(player);
		HBox.setHgrow(sliderTime, Priority.ALWAYS);
		HBox time_bar = new HBox(actualTime, sliderTime, totalTime,lbl_volumen, volumen, actual_volumen);
		time_bar.setSpacing(9.0);
		root = new VBox(view, time_bar);
		root.setPadding(new Insets(10.0));
		root.setSpacing(9.0);
		System.out.println(player.getMedia().getMetadata());
	}

	private void setVolumen(MediaPlayer player) {
		lbl_volumen = new Label("Volumen");
		volumen = new Slider(0, 1, 0.8);
		player.volumeProperty().bind(volumen.valueProperty());
		actual_volumen = new Label("80%");
		actual_volumen.textProperty().bind(player.volumeProperty().multiply(100.0).asString("%.0f %%"));
	
	}

	private void setSliderTime(Media media, MediaPlayer player) {
		sliderTime = new Slider();
		actualTime = new Label("0:00");
		totalTime = new Label("0:00");
		player.setOnReady(() -> {
			media.getMetadata().forEach((k, v) -> System.out.println(k + ", " + v));
			totalTime.setText(String.format("%.2f", player.getTotalDuration().toMinutes()));
			sliderTime.setMax(player.getTotalDuration().toSeconds());
			sliderTime.valueProperty().addListener((p, o, value) -> {
				if (sliderTime.isPressed()) {
					player.seek(Duration.seconds(value.doubleValue()));}});
			player.currentTimeProperty().addListener((p, o, value) -> {
				sliderTime.setValue(value.toSeconds());
				actualTime.setText(String.format("%.2f", value.toMinutes()));});});
	}
	
	public void next(File file) {
		media = new Media(file.toURI().toString());
		player = new MediaPlayer(media);
		view = new MediaView(player);
		view.setFitHeight(930);
		view.setFitWidth(560);
	}

	private void setButtons(MediaPlayer player) {
		play = new Button("",Actions.PLAY.getIconFx());
		pause = new Button("",Actions.PAUSE.getIconFx());
		stop = new Button("",Actions.STOP.getIconFx());
		next = new Button("", Actions.NEXT.getIconFx());
		play.setShape(new Circle(1.8));
		pause.setShape(new Circle(1.8));
		stop.setShape(new Circle(1.8));
		next.setShape(new Circle(1.8));
		play.setOnAction(e -> player.play());
		pause.setOnAction(e -> player.pause());
		stop.setOnAction(e -> player.stop());
		next.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Next has pressed!!");
//				next(file);
				new MultimetiaControlPlayer(new File("D:\\Jonatán\\Videos\\Films\\Avenged Sevenfold - So far away Sub Español.mp4"));
			}
		});
	}
	
	public void setFile(File file) {
		this.file = file;
	}

	public VBox getRoot() {
		return root;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public MediaPlayer getPlayer() {
		return player;
	}

	public void setPlayer(MediaPlayer player) {
		this.player = player;
	}

	public MediaView getView() {
		return view;
	}

	public void setView(MediaView view) {
		this.view = view;
	}
}
