package util;

import java.awt.Image;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import controller.Constants;

public class Utilities {

	@SuppressWarnings("deprecation")
	public static Date convertDate(String date) {
		String[] temp = date.split("-");
		return new Date(Integer.parseInt(temp[0]) - 1900, Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[2]));
	}

	public static String formatterDate(java.util.Date date) {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		String temp = d.format(date);
		return temp;

	}

	public Icon resizeIcon(String path, int widht, int height) {
		ImageIcon fot = new ImageIcon(getClass().getResource(Constants.ICON_PATH + path));
		Icon icon = new ImageIcon(fot.getImage().getScaledInstance(widht, height, Image.SCALE_DEFAULT));
		return icon;
	}

	public Image SetImage(String path, int widht, int height) {
		ImageIcon fot = new ImageIcon(Constants.ICON_PATH + path);
		return (fot.getImage().getScaledInstance(widht, height, Image.SCALE_DEFAULT));
	}
}
