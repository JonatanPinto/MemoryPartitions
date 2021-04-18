package view.variablePartition;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controller.Commands;
import controller.Constants;
import controller.Controller;

public class VariableParOptions extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Options
	private JPanel pnlOptions;
	private JSpinner spnPartitions;
	private JButton btnCreatePartitions;
	private ArrayList<JSpinner> spinnersPartitions;
	private JSpinner spnMemory;
	//Partitions
	private JPanel pnlPartitions;
	
	//Button
	private JPanel pnlButtons;
	private JButton btnStartSimulation;
	private JButton btnSetPartitions;
	
	public VariableParOptions() {
		this.setLayout(new GridLayout(3, 1));
		pnlOptions = new JPanel();
		pnlOptions.setLayout(new GridLayout(1, 2));
		pnlOptions.setBorder(new EtchedBorder());
		spnMemory = new JSpinner(new SpinnerNumberModel(16,16,256,16));
		spnMemory.setBorder(new TitledBorder(Constants.SPN_MEMORY_NAME));
		spnPartitions = new JSpinner(new SpinnerNumberModel(2,2,8,1));
		spnPartitions.setBorder(new TitledBorder(Constants.SPN_PARTITIONS));
		btnCreatePartitions = new JButton(Commands.VARIABLE_BTN_ADD_PARTITIONS.getName());
		btnCreatePartitions.setActionCommand(Commands.VARIABLE_BTN_ADD_PARTITIONS.getCommand());
		btnCreatePartitions.addActionListener(Controller.getInstance());
		pnlOptions.add(spnMemory);
		pnlOptions.add(spnPartitions);
		pnlOptions.add(btnCreatePartitions);
		this.add(pnlOptions);
		spinnersPartitions = new ArrayList<JSpinner>();
		pnlPartitions = new JPanel();
		this.add(pnlPartitions);
		// ----------------------------------------------------------------------
		pnlButtons = new JPanel();
		btnSetPartitions = new JButton(Commands.VARIABLE_BTN_SET_PARTITIONS.getName());
		btnSetPartitions.setActionCommand(Commands.VARIABLE_BTN_SET_PARTITIONS.getCommand());
		btnSetPartitions.addActionListener(Controller.getInstance());
		
		btnStartSimulation = new JButton(Commands.VARIABLE_BTN_START.getName());
		btnStartSimulation.setActionCommand(Commands.VARIABLE_BTN_START.getCommand());
		btnStartSimulation.addActionListener(Controller.getInstance());
		pnlButtons.add(btnSetPartitions);
		pnlButtons.add(btnStartSimulation);
		btnStartSimulation.setEnabled(false);
	}



	public void addPartitions() {
		spnMemory.setEnabled(false);
		spnPartitions.setEnabled(false);
		btnCreatePartitions.setEnabled(false);
		System.out.println("CONTROL MESSAGE [CLASS: VariableParOptions] --> Agregando");
		int partitions = Integer.parseInt(spnPartitions.getValue().toString());
		pnlPartitions.setLayout(new GridLayout(1, partitions));
		pnlPartitions.setBorder(new EtchedBorder());
		for (int i = 0; i < partitions; i++) {
			JSpinner aux = new JSpinner(new SpinnerNumberModel(4,4,512,(int) getMemory() / getNumberOfPartitions()));
			aux.setBorder(new TitledBorder("Particion " + (i+1)));
			pnlPartitions.add(aux);
			spinnersPartitions.add(aux);
		}
		this.add(pnlButtons);
		repaint();
	}
	
	public boolean verifyPartitionsSize() {
		int sum = 0;
		for (int i = 0; i < spinnersPartitions.size(); i++) {
			sum += Integer.parseInt(spinnersPartitions.get(i).getValue().toString());
		}
		if (sum <= getMemory()) {
			return true;
		}
		return false;
	}
	
	public int getNumberOfPartitions() {
		return Integer.parseInt(spnPartitions.getValue().toString());
	}
	
	public ArrayList<Integer> getPartitions(){
		ArrayList<Integer> partitions = new ArrayList<Integer>();
		for (int i = 0; i < spinnersPartitions.size(); i++) {
			partitions.add(Integer.parseInt(spinnersPartitions.get(i).getValue().toString()));
		}
		disableSpinners();
		btnSetPartitions.setEnabled(false);
		btnStartSimulation.setEnabled(true);
		return partitions;
	}
	
	public void disableSpinners() {
		for (int i = 0; i < spinnersPartitions.size(); i++) {
			spinnersPartitions.get(i).setEnabled(false);
		}
		
	}



	public int getMemory() {
		return Integer.parseInt(spnMemory.getValue().toString());
	}
}
