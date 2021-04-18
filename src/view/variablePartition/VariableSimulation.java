package view.variablePartition;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import view.partition.memory.TableMemory;
import view.partition.process.TableProcess;

public class VariableSimulation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------------- Process ------------------------------------- //	
	private TableProcess tableProcess;
	
	private TableMemory tableMemory;
	
	public VariableSimulation() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weighty = 0.5;
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.BOTH;
		tableProcess = new TableProcess();
		tableMemory = new TableMemory();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		this.add(tableProcess, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		this.add(tableMemory, gbc);
	}

	public void setProcess(ArrayList<String> process) {
		this.tableProcess.load(process);
	}
	
	public void setPartitions(ArrayList<Integer> partitions) {
		this.tableMemory.load(partitions);
	}
}
