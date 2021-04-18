package view.partition.memory;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class TableMemoryRow extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("Tahoma", Font.BOLD, 15);
	private JLabel lblPartition;
	private JLabel lblPID;
	private JLabel lblSizeProcess;
	private JProgressBar progressBar;
	
	public TableMemoryRow(String partition, String PID, String size, int value) {
		this.setLayout(new GridLayout(1, 4));
		this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		lblPartition = new JLabel(partition);
		lblPartition.setFont(font);
		this.setBorder(new EtchedBorder());
		lblPID = new JLabel(PID);
		lblPID.setFont(font);
		lblSizeProcess = new JLabel(size);
		lblSizeProcess.setFont(font);
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(value);
		this.add(lblPartition);
		this.add(lblPID);
		this.add(lblSizeProcess);
		this.add(progressBar);
	}
}
