package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class FixedPartition {

	public static final int NUMBER_OF_PROCESS = 20;
	private Memory memory;
	private ArrayList<Partition> partitions;
	private ArrayList<Process> processes;
	private ArrayList<Process> processesFinalized;
	
	/**
	 * 
	 * @param sizeMemory
	 * @param partitions
	 */
	public FixedPartition(int sizeMemory, int partitions) {
		memory = new Memory(sizeMemory, partitions);
		this.partitions = memory.getPartitions();
		processes = new ArrayList<Process>();
		processesFinalized = new ArrayList<Process>();
		createProcess();
	}
	
	/**
	 * 
	 * @param sizeMemory
	 * @param partitions
	 * @param processes
	 */
	public FixedPartition(int sizeMemory, int partitions, ArrayList<Process> processes) {
		memory = new Memory(sizeMemory, partitions);
		this.partitions = memory.getPartitions();
		this.processes = new ArrayList<Process>();
		this.processes = processes;
		processesFinalized = new ArrayList<Process>();
	}
	
	/**
	 * Metodo que asigna un proceso a una particion que este disponible
	 * @param process
	 */
	public void assing(Process process) {
		if (process.isAssigned() == true) {
			return;
		}
		for (int i = 0; i < partitions.size(); i++) {
			if (process.getSize() <= 0) {
				process.setStade(Stade.FINALIZED);
				processes.remove(process);
				processesFinalized.add(process);
				return;
			}
			if (partitions.get(i).isBusy() == false) {
				partitions.get(i).setProcess(process);
				System.out.println("CONTROL MESSAGE [CLASS: FixedPartition] --> El proceso " + process.getId() + "[" + process.getSize() + "]" + "ha sido asignado a la particion " + partitions.get(i).getId() + "["+ partitions.get(i).getFreeSize() + "]");
				process.execute(partitions.get(i).getTotalSize());
				return;
//				partitions.get(i).free();
//				System.err.println("CONTROL MESSAGE [CLASS: FixedPartition] --> [Particion "+ partitions.get(i).getId() + " liberada]\n");
			}
		}
	}
	
	public void free() {
		for (int i = 0; i < partitions.size(); i++) {
			if (partitions.get(i).isBusy()) {
				partitions.get(i).free();
				System.err.println("CONTROL MESSAGE [CLASS: FixedPartition] --> [Particion "+ partitions.get(i).getId() + " liberada]");
			}
		}
	}
	
	/**
	 * Metodo que verifica si la lista de procesos en espera sigue con elementos
	 * @return
	 */
	public boolean isEmpty() {
		return (processes.size() == 0);
	}
	
	public static void main(String[] args) {
		FixedPartition fixedPartition = new FixedPartition(256, 2);
		fixedPartition.showProcesses();
		Runnable run1 = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < fixedPartition.getProcesses().size(); i++) {
					fixedPartition.assing(fixedPartition.getProcesses().get(i));
					try {
						Thread.sleep(200);
					} catch (InterruptedException er) {
						er.printStackTrace();
					}
				}
			}
		};
		Runnable run2 = new Runnable() {
			
			@Override
			public void run() {
				fixedPartition.free();
				try {
					Thread.sleep(600);
				} catch (InterruptedException er) {
					er.printStackTrace();
				}
			}
		};
		Runnable run3 = new Runnable() {
			
			@Override
			public void run() {
				fixedPartition.showProcesses();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
//		Thread h1,h2, h3;
//		h1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 0; i < fixedPartition.getProcesses().size(); i++) {
//					fixedPartition.assing(fixedPartition.getProcesses().get(i));
//					try {
//						Thread.sleep(200);
//					} catch (InterruptedException er) {
//						er.printStackTrace();
//					}
//				}	
//			}
//		});
//		h2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				fixedPartition.free();
//				try {
//					Thread.sleep(600);
//				} catch (InterruptedException er) {
//					er.printStackTrace();
//				}
//			}
//		});
//		h3 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				fixedPartition.showProcesses();
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
		while (fixedPartition.isEmpty() == false) {
			new Thread(run1).run();
			new Thread(run2).run();
			new Thread(run3).run();
		}
	}
	
	
	
	
	private void showProcesses() {
		System.out.println("------- Procesos -------");
		String aux = String.format("%s\t%s\t%s", "PID","Tamaño","Estado");
		System.out.println(aux);
		for (int i = 0; i < processes.size(); i++) {
			System.out.println(processes.get(i).show());
		}
		System.out.println("------------------------\n\n");
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

	public ArrayList<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(ArrayList<Partition> partitions) {
		this.partitions = partitions;
	}

	public ArrayList<Process> getProcessesFinalized() {
		return processesFinalized;
	}

	public void setProcessesFinalized(ArrayList<Process> processesFinalized) {
		this.processesFinalized = processesFinalized;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public void setProcesses(ArrayList<Process> processes) {
		this.processes = processes;
	}

	
	public ArrayList<String> getProcessesString() {
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < processes.size(); i++) {
			aux.add(processes.get(i).toString());
		}
		return aux;
	}
	
	public ArrayList<String> getPartitionsString(){
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < partitions.size(); i++) {
			aux.add(partitions.get(i).toString());
		}
		return aux;
	}
	
	
}
