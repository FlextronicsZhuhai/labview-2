package com.joe.myvideo.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class T {

	/**
	 * log
	 */
	public static Log log = LogFactory.getLog(T.class);
	private static final String root = SysConfig.getConfig("system.root");
	
	public static void alert(HttpServletResponse res,String msg,String location){
		try {
			res.setContentType("text/html; charset=utf-8");
	    	res.setCharacterEncoding("utf-8");
			PrintWriter out = res.getWriter();
			
			out.println("<script language=\"javascript\">alert(\""+msg+"\");"
					+ "window.location.href='"+root+location+"'"
					+ "</script>");
		} catch (IOException e) {
			log.error("弹出窗发生异常" ,e);
		}
	}
}
