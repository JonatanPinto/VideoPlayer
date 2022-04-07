package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Actions;
import controller.Controller;

public class PnlButtons extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnPlay,btnPause,btnNext;
	public PnlButtons() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		btnPlay = new JButton(Actions.PLAY.getIcon());
		btnPlay.addActionListener(Controller.get());
		btnPlay.setActionCommand(Actions.PLAY.getCommand());
		
		btnPause = new JButton(Actions.PAUSE.getIcon());
		btnPause.addActionListener(Controller.get());
		btnPause.setActionCommand(Actions.PAUSE.getCommand());
		
		btnNext = new JButton(Actions.NEXT.getIcon());
		btnNext.addActionListener(Controller.get());
		btnNext.setActionCommand(Actions.NEXT.getCommand());
		this.add(btnPlay);
		this.add(btnPause);
		this.add(btnNext);
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}

	public JButton getBtnPause() {
		return btnPause;
	}

	public void setBtnPause(JButton btnPause) {
		this.btnPause = btnPause;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
