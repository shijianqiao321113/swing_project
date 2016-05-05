package com.init;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class ImageLoad {

	public static Map<String, ImageIcon> images = new HashMap<String, ImageIcon>();

	public static Boolean loadImages() {
		String fileDis = System.getProperty("user.dir") + File.separator + "images";
		File f = new File(fileDis);
		if (!f.exists() && !f.isDirectory()) {
			return Boolean.FALSE;
		}
		File[] File = f.listFiles();
		for (File fs : File) {
			if (fs.isFile()) {
				ImageIcon image = new ImageIcon(fs.getPath());
				images.put(fs.getName().substring(0, fs.getName().lastIndexOf(".")), image);
			}
		}
		return Boolean.TRUE;
	}
}
