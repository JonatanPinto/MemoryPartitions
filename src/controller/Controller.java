package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import model.FixedPartition;
import model.Process;
import model.VariablePartition;
import util.Numbers;
import view.MainWindow;
import view.Messages;

public class Controller implements ActionListener{
	
	private static Controller instance;
	private MainWindow mainWindow;
	private ArrayList<Process> processes;
	private Messages messages;
	
	private FixedPartition fixedPartition;
	private VariablePartition variablePartition;
	
	private Controller() {
		messages = new Messages();
	}
	
	public void set(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		// ----------------------- Fixed Partition -----------------------
		case FIXED_BTN_START:
			int fixedPartitions = mainWindow.getFixedPartitionPane().loadPartitions();
			fixedPartition = new FixedPartition(mainWindow.getFixedPartitionPane().getMemory(), fixedPartitions, processes);
			startFixed();
		// ---------------------  Variable Partition ---------------------
		case VARIABLE_BTN_ADD_PARTITIONS:
			mainWindow.getVariablePartitionPane().addPartitions();			
			break;
		case VARIABLE_BTN_SET_PARTITIONS:
			System.out.println("CONTROL MESSAGE [CLASS: Controller] --> Iniciando de particiones");
			if (mainWindow.getVariablePartitionPane().getVariableParOptions().verifyPartitionsSize()) {
				variablePartition = new VariablePartition(mainWindow.getVariablePartitionPane().getMemory(), mainWindow.getVariablePartitionPane().getPartitions(), processes);
				ArrayList<Integer> partitionsSize = mainWindow.getVariablePartitionPane().getPartitions();
				mainWindow.getVariablePartitionPane().loadPartitions(partitionsSize);
			} else {
				messages.confirmMessage(mainWindow, "El tamaño de las particiones es mayor que el de la memoria");
			}
			System.out.println("CONTROL MESSAGE [CLASS: Controller] --> Fin de Inicio de particiones");
			
		case VARIABLE_BTN_START:
			startVariable();
		default:
			break;
		}
		
	}

	private void startVariable() {
		// TODO
		variablePartition.assing(null);
	}

	private void startFixed() {
		Timer timer = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < processes.size(); i++) {
					fixedPartition.assing(processes.get(i));
					mainWindow.getFixedPartitionPane().loadProcess(fixedPartition.getProcessesString());
					mainWindow.getFixedPartitionPane().getSimulation().updatePartitions(fixedPartition.getPartitionsString());
					try {
						Thread.sleep(900);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		timer.start();
	}

	public static void main(String[] args) {
		Controller.getInstance().set(new MainWindow());;
		Controller.getInstance().load();
	}
	
	
	public void load() {
		processes = new ArrayList<Process>();
		for (int i = 1; i <= 20; i++) {
			if (i < 10) {
				processes.add(new Process("PRC00" + (i), Numbers.generateNumberInt(4, 512)));
			} else {
				processes.add(new Process("PRC0" + (i), Numbers.generateNumberInt(4, 512)));
			}
		}
		ArrayList<String> processString = new ArrayList<String>();
		for (int i = 0; i < processes.size(); i++) {
			processString.add(processes.get(i).toString());
		}
		mainWindow.getFixedPartitionPane().loadProcess(processString);
		mainWindow.getVariablePartitionPane().loadProcess(processString);
	}
}
