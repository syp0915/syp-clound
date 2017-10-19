package com.shfc.authentication.utils;

import com.shfc.common.base.ValidateHelper;

import java.security.MessageDigest;

public class MD5Util {
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 32位MD5签名
	 *
	 * @param strObj
	 *            明文串
	 * @return
	 */
	public static String getMd5Code(String strObj) {
		if (strObj == null) {
			return "";
		}
		return getMd5Code(strObj, "utf-8", false);
	}

	/**
	 * 32位MD5签名
	 *
	 * @param strObj
	 *            明文串
	 * @param charsetName
	 *            字符编码，可为空
	 * @return
	 */
	public static String getMd5Code(String strObj, String charsetName) {
		if (strObj == null) {
			return "";
		}
		return getMd5Code(strObj, charsetName, false);
	}

	/**
	 * 16位或者32位MD5签名
	 *
	 * @param plainText
	 *            明文串
	 * @param charsetName
	 *            字符编码，可为空
	 * @return
	 */
	public static String getMd5Code(String plainText, String charsetName, boolean shortFlag) {
		if (plainText == null) {
			return "";
		}
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] byteArr;
			if (!ValidateHelper.isEmpty(charsetName)) {
				byteArr = plainText.getBytes(charsetName);
			} else {
				byteArr = plainText.getBytes();
			}
			md.update(byteArr);
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
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
			} else {
				result = buf.toString().toUpperCase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static String getSignCode(String appId,String version,String signType,String params,String appSecret){
		StringBuffer sb = new StringBuffer();
		sb.append("appId=").append(appId).append("&").append("version=").append(version).append("&").append("signType=")
				.append(signType).append("&").append("params=").append(params).append("&").append("appSecret=")
				.append(appSecret);
		System.out.println("待签名字符串是sourceStr=" + sb.toString());
		String result = getMd5Code(sb.toString());
		return result;
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.MD5("royal").toLowerCase());
		System.out.println(System.currentTimeMillis() + "");
	}
}