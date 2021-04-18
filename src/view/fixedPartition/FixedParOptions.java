package view.fixedPartition;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controller.Commands;
import controller.Constants;
import controller.Controller;

public class FixedParOptions extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Options
	private JPanel pnlOptions;
	private JSpinner spnMemory;
	private JSpinner spnPartitions;
	
	//Button
	private JButton btnStartSimulation;
	
	public FixedParOptions() {
		this.setLayout(new GridLayout(3, 1));
		pnlOptions = new JPanel();
		pnlOptions.setLayout(new GridLayout(1, 3));
		pnlOptions.setBorder(new EtchedBorder());
		spnMemory = new JSpinner(new SpinnerNumberModel(16,16,256,16));
		spnMemory.setBorder(new TitledBorder(Constants.SPN_MEMORY_NAME));
		spnPartitions = new JSpinner(new SpinnerNumberModel(2,2,8,1));
		spnPartitions.setBorder(new TitledBorder(Constants.SPN_PARTITIONS));
		btnStartSimulation = new JButton(Commands.FIXED_BTN_START.getName());
		btnStartSimulation.setActionCommand(Commands.FIXED_BTN_START.getCommand());
		btnStartSimulation.addActionListener(Controller.getInstance());
		pnlOptions.add(spnMemory);
		pnlOptions.add(spnPartitions);
		pnlOptions.add(btnStartSimulation);
		this.add(pnlOptions);
	}
	
	public int getNumberOfPartitions() {
		return Integer.parseInt(spnPartitions.getValue().toString());
	}
	
	public int getPartitions(){
		return Integer.parseInt(spnPartitions.getValue().toString());
	}
	
	public int getMemory(){
		return Integer.parseInt(spnMemory.getValue().toString());
	}
	
	public void disableSpinners() {
		spnMemory.setEnabled(false);
		spnPartitions.setEnabled(false);
		btnStartSimulation.setEnabled(false);
		
	}
}
