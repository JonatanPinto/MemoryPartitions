package model;

public enum Stade {

	FINALIZED("Finalizado"), IN_PROGRESS("En proceso"), WAITING("Esperando");
	
	private String name;
	
	private Stade(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
