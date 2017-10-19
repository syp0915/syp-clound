package com.shfc.mac.Utils;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;

public class Md5Utils {

	public static String getMd5Code(String strObj, String charsetName) {
		return getMd5Code(strObj, charsetName, false);
	}

	public static String getMd5Code(String plainText, String charsetName,
			boolean shortFlag) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] byteArr;
			if (StringUtils.isNotBlank(charsetName)) {
				byteArr = plainText.getBytes(charsetName);
			} else {
				byteArr = plainText.getBytes();
			}
			md.update(byteArr);
			byte[] b = md.digest();

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				int i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			if (shortFlag) {
				result = buf.toString().substring(8, 24).toUpperCase();
			} else
				result = buf.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(getMd5Code("黄浦区", ""));
	}
}