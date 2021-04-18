package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import util.Utilities;

public class Messages {
	
	private Utilities utilities;
	public Messages() {
		utilities = new Utilities();
	}

	public  void confirmMessage(JFrame component, String text) {
		JOptionPane.showMessageDialog(component, text, "Confirmacion",JOptionPane.OK_OPTION, utilities.resizeIcon("confirmar.png", 40, 40));
	}
	
	public void exitMessage(JFrame component) {
		int option = JOptionPane.showConfirmDialog(component, "¿Realmente deseas salir?", "Confirmacion",JOptionPane.OK_CANCEL_OPTION,JOptionPane.OK_OPTION, utilities.resizeIcon("logout.png", 40, 40));
		if (option == 0) {
			System.exit(0);
		}
	}
	
	public void exitMessage(JDialog component) {
		int option = JOptionPane.showConfirmDialog(component, "¿Realmente deseas salir?", "Confirmacion",JOptionPane.OK_CANCEL_OPTION,JOptionPane.OK_OPTION, utilities.resizeIcon("logout.png", 40, 40));
		if (option == 0) {
			System.exit(0);
		}
	}
}
