package util;

import java.awt.Toolkit;

public class CenterWindow {

	public static int windowX() {
		return (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2;
	}
	
	public static int windowY() {
		return (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight())/2;
	}
}
