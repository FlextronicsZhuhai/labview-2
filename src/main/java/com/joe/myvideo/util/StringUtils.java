package com.joe.myvideo.util;

import java.util.regex.Pattern;

/**
 * 字符串操作工具类
 * 已继承了org.apache.commons.lang3.StringUtils�?
 * 如需使用�?些工具方法时请仔细查看其api，其已有的方法可直接调用避免重复造轮�?
 * http://commons.apache.org/proper/commons-lang/javadocs/api-3.1/org/apache/commons/lang3/StringUtils.html
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	public static String firstToUpper(String str){
		if (str == null || "".equals(str)) {
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String firstToLower(String str){
		if (str == null || "".equals(str)) {
			return str;
		}

		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}


	public static String splitTag(String input){
		return splitTag(input, 0, null);
	}

	public static String splitTag(String input, int length){
		return splitTag(input, length, "...");
	}

	public static String splitTag(String input, int length, String fill){
		if (input == null || input.trim().equals("")) {
			return input;
		}
		// 去掉�?有html元素,
		String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "");
		str = str.replaceAll("<[a-zA-Z]+[1-9]?[^><]*>", "");
		str = str.replaceAll("</[a-zA-Z]+[1-9]?>", "");
		str = str.replace("\\r", "").replace("\\n", "");
		if (length > 0) {
			int len = str.length();
			if (len <= length) {
				return str;
			} else {
				str = str.substring(0, length);
				if (fill != null) {
					str += fill;
				}
			}
		}
		return str;
	}

	public static String substr(String input, int length){
		return substr(input, length, "...");
	}

	public static String substr(String input, int length, String fill){
		if (input == null) {
			return null;
		}
		if (input.length() > length) {
			input = input.substring(0, length);
			if (fill != null) {
				input += fill;
			}
		}
		return input;
	}

	public static String obj2String(Object obj) {
		if(obj == null) {
			return "";
		}
		return obj.toString();
	}

	 /**
	  * 替换xml文件中的特殊字符
	  * @param str
	  * @return
	  */
     public static String replaceXmlString(String str){
         if (str == null){
             return "";
         }
         str = str.replaceAll( "&", "&amp;")
		         .replaceAll( "<", "&lt;")
		         .replaceAll( ">", "&gt;")
		         .replaceAll( "'", "&apos;")
		         .replaceAll( "\"", "&quot;");
         return str;
     }
     
    /**
     *  正则匹配
     *  
     * @param reg
     * @param value
     * @return
     * 
     * @author Mike He
     */
    public static boolean regex(String reg,String value){
		 return Pattern.compile(reg).matcher(value).find();
	}

    
	/**
	 * 对json字符串中含有的特殊符进行转义
	 * @param str
	 * @return
	 */
	public static String replaceJsonStr(String str){
		String s = "";
		if(str!=null){
			s  = str
			.replace( "\b", "\\b" )
			.replace( "\r", "\\r" )
			.replace( "\n", "\\n" )
			.replace( "\f", "\\f" )
			.replace( "\t", "\\t" )
			//.replace( "/", "\\/" )
			//.replace( "\"", "\\\"" )
			//.replaceAll( "\\\\", "\\\\\\\\" )
			//.replace( "'", "\\'" )
			;
		}
		return s;
	}
	
	/**
	 * 字符串默认值判断
	 * @param str
	 * @param def
	 * @return
	 */
	public static String get(Object object , String def){
		if(null == object){
			return def;
		}else if("".equals(object.toString())){
			return object.toString();
		}
		return object.toString();
	}
	
	/**
	 * 字符串默认值判断
	 * @param str
	 * @param def
	 * @return
	 */
	public static int getInt(Object object , int def){
		if(null == object || "".equals(object.toString())){
			return def;
		}else{
			return Integer.parseInt(object.toString());
		}
	}
}
