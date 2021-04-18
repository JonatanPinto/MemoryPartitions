package view.variablePartition;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class VariablePartitionPane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VariableParOptions variableParOptions;
	private VariableSimulation simulation;
	
	public VariablePartitionPane() {
		this.setLayout(new BorderLayout());
		variableParOptions = new VariableParOptions();
		simulation = new VariableSimulation();
		this.add(variableParOptions, BorderLayout.NORTH);
		this.add(simulation, BorderLayout.CENTER);
	}
	
	public void addPartitions() {
		variableParOptions.addPartitions();
	}
	
	public void loadProcess(ArrayList<String> process) {
		simulation.setProcess(process);
	}
	
	public int getNumberOfPartitions() {
		return variableParOptions.getNumberOfPartitions();
	}
	
	public void loadPartitions(ArrayList<Integer> partitions) {
		simulation.setPartitions(partitions);
	}
	
	public ArrayList<Integer> getPartitions(){
		return variableParOptions.getPartitions();
	}
	
	
	public int getMemory() {
		return variableParOptions.getMemory();
	}

	public VariableParOptions getVariableParOptions() {
		return variableParOptions;
	}

	public void setVariableParOptions(VariableParOptions variableParOptions) {
		this.variableParOptions = variableParOptions;
	}

	public VariableSimulation getSimulation() {
		return simulation;
	}

	public void setSimulation(VariableSimulation simulation) {
		this.simulation = simulation;
	}
}
