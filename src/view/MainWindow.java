package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controller.Constants;
import util.CenterWindow;
import view.fixedPartition.FixedPartitionPane;
import view.variablePartition.VariablePartitionPane;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private StadePane stadePane;
	//-------------------------------------------------------------------------------//
	private FixedPartitionPane fixedPartitionPane;
	private VariablePartitionPane variablePartitionPane;
	
	public MainWindow() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("Proyecto");
		tabbedPane = new JTabbedPane();
		this.setLocationRelativeTo(null);
		this.setBounds(CenterWindow.windowX() - (Constants.WIDHT_WINDOW/2) , CenterWindow.windowY() - (Constants.HEIGHT_WINDOW/2) , Constants.WIDHT_WINDOW, Constants.HEIGHT_WINDOW);
		this.addWindowListener(new WindowsOptions(this));
		this.setResizable(false);
		addPanels();
		this.setVisible(true);
		this.add(tabbedPane, BorderLayout.CENTER);
		stadePane = new StadePane();
		this.add(stadePane, BorderLayout.SOUTH);
	}

	private void addPanels() {
		fixedPartitionPane = new FixedPartitionPane();
		tabbedPane.addTab("Particion Fija", fixedPartitionPane);
		variablePartitionPane = new VariablePartitionPane();
		tabbedPane.addTab("Particion Variable", variablePartitionPane);
	}

	public VariablePartitionPane getVariablePartitionPane() {
		return variablePartitionPane;
	}
	
	public FixedPartitionPane getFixedPartitionPane() {
		return fixedPartitionPane;
	}
}
