package model;

import java.util.ArrayList;

public class VariablePartition {

	public static final int NUMBER_OF_PROCESS = 20;
	private Memory memory;
	private ArrayList<Partition> partitions;
	private ArrayList<Process> processes;
	
	/**
	 * 
	 * @param sizeMemory
	 * @param partitions
	 */
	public VariablePartition(int sizeMemory, ArrayList<Integer> partitionsSize) {
		memory = new Memory(sizeMemory, partitionsSize);
		this.partitions = memory.getPartitions();
		processes = new ArrayList<Process>();
		createProcess();
	}
	
	/**
	 * 
	 * @param sizeMemory
	 * @param partitions
	 * @param processes
	 */
	public VariablePartition(int sizeMemory, ArrayList<Integer> partitionsSize, ArrayList<Process> processes) {
		memory = new Memory(sizeMemory, partitionsSize);
		this.partitions = memory.getPartitions();
		this.processes = processes;
	}
	
	/**
	 * Metodo que asigna un proceso a una particion que este disponible
	 * @param process
	 */
	public void assing(Process process) {
		for (int i = 0; i < partitions.size(); i++) {
			final int a = i;
			if (process.getStade() != Stade.FINALIZED && process.isAssigned() == false) {
				if (partitions.get(i).isBusy() == false) {
					partitions.get(i).setProcess(process);
					System.out.println("CONTROL MESSAGE [CLASS: FixedPartition] --> \nEl proceso " + process.getId() + "[" + process.getSize() + "]" + "ha sido asignado a la particion " + partitions.get(i).getId());
					process.setStade(Stade.IN_PROGRESS);
					process.setAssigned(true);
					try {
						Thread.sleep(process.getSize() * 10);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					process.setStade(Stade.FINALIZED);
					process.execute(partitions.get(i).getTotalSize());
					processes.remove(process);
					partitions.get(a).free();
					System.err.println("CONTROL MESSAGE [CLASS: FixedPartition] --> Particion liberada");
				} else {
					System.out.println("CONTROL MESSAGE [CLASS: FixedPartition] --> \nEl proceso " + process.getId() + "[" + process.getSize() + "]" + "no pudo asignarse por falta de espacio en particion " + partitions.get(i).getId() + "["+ partitions.get(i).getFreeSize() + "]");
					process.setStade(Stade.WAITING);
				}
			}
			System.out.println("El proceso " + process.getPID() + " esta en estado: " + process.getStade().getName());
		}
	}
	
	/**
	 * Metodo que verifica si la lista de procesos en espera sigue con elementos
	 * @return
	 */
	public boolean isEmpty() {
		return (processes.size() == 0);
	}
	
	/**
	 * Metodo para crear 20 procesos de forma pseudoaleatoria
	 */
	private void createProcess() {
		int max = 256;
		for (int i = 0; i < NUMBER_OF_PROCESS; i++) {
			if (i < 10) {
				processes.add(new Process("PRCSS0" + i + "", (int) (Math.random() * max + 4)));
			} else {
				processes.add(new Process("PRCSS" + i + "", (int) (Math.random() * max + 4)));
			}
		}
	}

	public Memory getMemory() {
		return memory;
	}

	public ArrayList<Process> getProcesses() {
		return processes;
	}
}
