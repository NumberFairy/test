package com.wisdombud.alumni.util;

import java.security.SecureRandom;
import java.util.Random;

import common.toolkit.java.util.StringUtil;

public class GenerateSalt {
	public static String generateSalt() {
		final Random r = new SecureRandom();
		byte[] salt = new byte[32];
		r.nextBytes(salt);
		return StringUtil.encrypt(new String(salt));
	}
}
