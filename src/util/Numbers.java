package util;


public class Numbers {
	
	public Numbers() {
		
	}
	
	public static int generateNumberInt(int min, int max) {
		return (int) (Math.random() * max + min);
	}
}
