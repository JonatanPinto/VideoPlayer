package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.File;

import javax.swing.border.LineBorder;

import view.video.PnlTopVideo;
import view.video.PnlVideoPlayer;

import java.awt.Color;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMBar bar;
	private PnlVideoPlayer videoPlayer;
	private PnlButtons buttons;
	private PnlTopVideo topVideo;

	public MainWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1080, 620);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		bar = new JMBar();
		this.setJMenuBar(bar);

		videoPlayer = new PnlVideoPlayer(new File("D:\\Jonatán\\Videos\\Films\\Imagine Dragons It's Time.mp4"));
		videoPlayer.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		videoPlayer.setBounds(12, 13, 600, 435);
		contentPane.add(videoPlayer);

		JPanel listaVideos = new JPanel();
		listaVideos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		listaVideos.setBounds(12, 460, 1040, 100);
		contentPane.add(listaVideos);

		topVideo = new PnlTopVideo(askSizeTop());
		topVideo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		topVideo.setBounds(620, 13, 435, 435);
		contentPane.add(topVideo);

		buttons = new PnlButtons();
		buttons.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		buttons.setBounds(12, 357, 462, 37);
		contentPane.add(buttons);
	}

	public int askSizeTop() {
		Object[] options = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
		Object option = JOptionPane.showOptionDialog(this,
				"Bienvenido Usuario\\n¿Cuántas canciones desea incluir en su top el día de hoy?", "Capacidad del top",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		System.out.println("Cantidad de puntos = " + (Integer.parseInt(option.toString()) + 4));
		return (Integer.parseInt(option.toString())) + 4;
	}
	
	public PnlVideoPlayer getVideoPlayer() {
		return videoPlayer;
	}

	public void setVideoPlayer(PnlVideoPlayer videoPlayer) {
		this.videoPlayer = videoPlayer;
	}

	public PnlButtons getButtons() {
		return buttons;
	}

	public void setButtons(PnlButtons buttons) {
		this.buttons = buttons;
	}
}
