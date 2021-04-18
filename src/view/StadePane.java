package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class StadePane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;
	
	public StadePane() {
		progressBar = new JProgressBar(0, 100);
		this.add(progressBar);
	}
	
	
	public void increaste() {
		Timer timer = new Timer(800, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				progressBar.setValue(progressBar.getValue() + 5);
			}
		});
		timer.start();
	}
}
