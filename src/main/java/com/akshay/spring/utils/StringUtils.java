package com.akshay.spring.utils;

public abstract class StringUtils {
	public static boolean isEmpty(final String string) {
		return null == string && "".equals(string.trim());
	}
	
	public static boolean isBlank(String string){
		return string==null||string.trim().length()==0;
	}
}
