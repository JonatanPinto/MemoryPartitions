package model;

public class Partition extends Thread{

	private int id;
	private Process process;
	private int totalSize;
	private int usedSize;
	private int freeSize;
	private boolean busy;

	public Partition(int id, int totalSize) {
		super();
		this.id = id;
		this.totalSize = totalSize;
		this.usedSize = 0;
		this.freeSize = totalSize;
		this.busy = false;
	}

	public Partition(int id, Process process, int totalSize) {
		super();
		this.id = id;
		this.totalSize = totalSize;
		this.process = process;
		this.usedSize = process.getSize();
		this.freeSize = totalSize - usedSize;
		this.busy = false;
	}

	/**
	 * Metodo que agrega un proceso a la particion
	 * @param process
	 */
	public void setProcess(Process process) {
		if (process.getSize() > totalSize) {
			freeSize = 0;
			usedSize = totalSize;
			process.execute(totalSize);
			this.busy = true;
		} else {
			usedSize = process.getSize();
			freeSize = totalSize - usedSize;
			this.busy = true;
		}
	}
	
	/**
	 * Metodo que libera a la particion del proceso
	 */
	public void free() {
		usedSize = 0;
		freeSize = totalSize;
		process = null;
		busy = false;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public int getUsedSize() {
		return usedSize;
	}

	public int getFreeSize() {
		return freeSize;
	}

	public Process getProcess() {
		return process;
	}

	public long getId() {
		return id;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public void setUsedSize(int usedSize) {
		this.usedSize = usedSize;
	}

	public void setFreeSize(int freeSize) {
		this.freeSize = freeSize;
	}

	@Override
	public String toString() {
		if (process == null) {
			return id + "," + " " + "," + totalSize + "," + usedSize + "," + freeSize;
		}
		return id + "," + process.getPID() + "," + totalSize + "," + usedSize + "," + freeSize;
	}
	
	
}
