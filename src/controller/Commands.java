package controller;

public enum Commands {

	FIXED_BTN_ADD_PARTITIONS("Crear Particiones", "FIXED_BTN_ADD_PARTITIONS"),
	FIXED_BTN_SET_PARTITIONS("Agregar Particiones", "FIXED_BTN_SET_PARTITIONS"),
	FIXED_BTN_START("Iniciar Simulacion","FIXED_BTN_START"),
	
	
	VARIABLE_BTN_ADD_PARTITIONS("Crear Particiones", "VARIABLE_BTN_ADD_PARTITIONS"), 
	VARIABLE_BTN_SET_PARTITIONS("Agregar Particiones", "VARIABLE_BTN_SET_PARTITIONS"), 
	VARIABLE_BTN_START("Iniciar Simulacion","VARIABLE_BTN_START");
	
	private String name;
	private String command;
	
	private Commands(String name, String command) {
		this.name = name;
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getName() {
		return name;
	}
}
