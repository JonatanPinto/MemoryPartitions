package view.partition.process;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class TableProcessRow extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("Tahoma", Font.BOLD, 13);
	private JLabel lblNum;
	private JLabel lblPID;
	private JLabel lblSize;
	private JLabel lblStade;
	private JLabel lblRealized;
	private JLabel lblIcon;
	
	public TableProcessRow(String num, String PID, String size, String stade, String realized) {
		this.setLayout(new GridLayout(1, 5));
		this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		lblNum = new JLabel(num);
		lblNum.setFont(font);
		lblPID = new JLabel(PID);
		lblPID.setFont(font);
		lblSize = new JLabel(size);
		lblSize.setFont(font);
		lblStade = new JLabel(stade);
		lblStade.setFont(font);
		lblRealized = new JLabel(realized);
		lblRealized.setFont(font);
		lblIcon = new JLabel();
		this.add(lblNum);
		this.add(lblPID);
		this.add(lblSize);
		this.add(lblStade);
		this.add(lblIcon);
		this.add(lblRealized);
	}
}
