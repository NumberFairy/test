package com.wisdombud.alumni.util;

import java.util.ArrayList;
import java.util.List;

public class Toolkit {

	public static String findFileExtension(String fileName) {
		String[] aa = fileName.split(".");
		if (aa.length > 1) {
			return aa[aa.length - 1].toLowerCase();
		}
		return "";
	}

	public static boolean isFileImage(String fileName) {
		List<String> imageLists = new ArrayList<String>();
		imageLists.add("png");
		imageLists.add("jpg");
		imageLists.add("bmp");
		imageLists.add("jpeg");
		imageLists.add("gif");
		return imageLists.contains(findFileExtension(fileName));
	}
}
