package model;

public class Process {

	private String PID;
	// tamaño 4 hasta 512 MB
	private int size;
	private Stade stade;
	private boolean assigned;
	private int sizeCompleted;
	
	public Process(String PID, int size) {
		this.PID = PID;
		this.size = size;
		this.stade = Stade.WAITING;
		this.assigned = false;
		this.sizeCompleted = 0;
	}
	
	public void execute(int size) {
		this.sizeCompleted = size;
		this.size = this.size - sizeCompleted;
		this.stade = Stade.IN_PROGRESS;
	}

	public String getId() {
		return PID;
	}

	public int getSize() {
		return size;
	}
	
	public Stade getStade() {
		return stade;
	}

	@Override
	public String toString() {
		return PID + "," + size + "," + stade.getName() + "," + sizeCompleted;
	}
	
	

	public String getPID() {
		return PID;
	}

	public String show() {
		String aux = String.format("%s\t%s\t%s", PID,size,stade.getName());
		return aux;
	}

	public void setPID(String pID) {
		PID = pID;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setStade(Stade stade) {
		this.stade = stade;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	public int getSizeCompleted() {
		return sizeCompleted;
	}

	public void setSizeCompleted(int sizeCompleted) {
		this.sizeCompleted = sizeCompleted;
	}
}
