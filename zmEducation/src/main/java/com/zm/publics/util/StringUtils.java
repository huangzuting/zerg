package com.zm.publics.util;


public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static final String SLASH = "/";
	
	public static final String DOT = "\\.";
	
	public static final String COMMA = ",";
	
	public static final String CHINESE_COMMA = "ã€?";
	
	public static final String joinByComma(String... array){
		return StringUtils.join(array, COMMA);
	}
	
	public static final String joinByChineseComma(String... array){
		return StringUtils.join(array, CHINESE_COMMA);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
