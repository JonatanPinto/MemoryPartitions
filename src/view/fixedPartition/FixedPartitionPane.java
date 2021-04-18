package view.fixedPartition;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FixedPartitionPane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FixedParOptions fixParOptions;
	private FixedSimulation simulation;
	
	public FixedPartitionPane() {
		this.setLayout(new BorderLayout());
		fixParOptions = new FixedParOptions();
		simulation = new FixedSimulation();
		this.add(fixParOptions, BorderLayout.NORTH);
		this.add(simulation, BorderLayout.CENTER);
	}
	
	public void loadProcess(ArrayList<String> process) {
		simulation.setProcess(process);
	}
	
	public int getNumberOfPartitions() {
		return fixParOptions.getNumberOfPartitions();
	}
	
	public int loadPartitions() {
		simulation.setPartitions(fixParOptions.getMemory(), fixParOptions.getPartitions());
		return fixParOptions.getPartitions();
	}
	
	public int getPartitions(){
		return fixParOptions.getPartitions();
	}
	
	public int getMemory() {
		return fixParOptions.getMemory();
	}

	public FixedParOptions getFixParOptions() {
		return fixParOptions;
	}

	public void setFixParOptions(FixedParOptions fixParOptions) {
		this.fixParOptions = fixParOptions;
	}

	public FixedSimulation getSimulation() {
		return simulation;
	}

	public void setSimulation(FixedSimulation simulation) {
		this.simulation = simulation;
	}	
}
