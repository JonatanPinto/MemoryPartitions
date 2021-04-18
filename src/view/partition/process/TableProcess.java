package view.partition.process;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TableProcess extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<TableProcessRow> processRow;
	private JScrollPane scrollPane;
	private JPanel pnl;
	
	public TableProcess() {
		processRow = new ArrayList<TableProcessRow>();
		this.setLayout(new FlowLayout());
		pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(pnl);
		this.add(scrollPane);
	}

	public void load(ArrayList<String> process) {
		pnl.removeAll();
		pnl.add(new TableProcessRow(" #", "PID", "Tamaño", "Estado" , "Realizado"));
		for (int i = 0; i < process.size(); i++) {
			String[] aux = process.get(i).split(",");
			processRow.add(new TableProcessRow(" " + (i + 1), aux[0], aux[1], aux[2], aux[3]));
			pnl.add(processRow.get(i));
			repaint();
		}
	}
}
