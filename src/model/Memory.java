package model;

import java.util.ArrayList;

public class Memory {

	private int size;
	private ArrayList<Partition> partitions;

	/**
	 * Constructor para crear particiones de igual tamanio
	 * @param size
	 * @param numberOfPartitions
	 */
	public Memory(int size, int numberOfPartitions) {
		this.size = size;
		this.partitions = new ArrayList<Partition>();
		setPartitions(calculateSizes(numberOfPartitions));
	}

	/** 
	 * Constructor para crear particiones de diferentes tamanios
	 * @param size
	 * @param partitionsSizes
	 */
	public Memory(int size, ArrayList<Integer> partitionsSizes) {
		this.size = size;
		setPartitions(partitionsSizes);
	}

	/**
	 * Metodo para poder calcular el tamanio que van a tener todas las particiones en la particion fija
	 * @param numberOfPartitions
	 * @return
	 */
	private ArrayList<Integer> calculateSizes(int numberOfPartitions) {
		ArrayList<Integer> aux = new ArrayList<Integer>();
		int sizePartition = (int) size / numberOfPartitions;
		for (int i = 0; i < numberOfPartitions; i++) {
			aux.add(sizePartition);
		}
		return aux;
	}

	
	private void setPartitions(ArrayList<Integer> partitionsSizes) {
		partitions = new ArrayList<Partition>();
		for (int i = 0; i < partitionsSizes.size(); i++) {
			partitions.add(new Partition(i, partitionsSizes.get(i)));
		}
	}

	public int getSize() {
		return size;
	}

	public int getNumberOfPartitions() {
		return partitions.size();
	}

	public ArrayList<Partition> getPartitions() {
		return partitions;
	}
}
