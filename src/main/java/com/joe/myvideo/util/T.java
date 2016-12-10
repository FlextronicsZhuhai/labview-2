package com.joe.myvideo.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

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
	
	/**
	 * 返回语句块(适用于Geli2.0)
     * @param resp
     * @param statusCode - 返回状态代码，200=成功，300=失败
     * @param message - 操作后的提示内容
     * @param navTabId - 返回的navTabId
     * @param callbackType - 回调方式，例如closeCurrent
	 * @return
	 */
	public static String callback(HttpServletResponse resp, int statusCode, String message, String navTabId, String callbackType) {
		JSONObject json = new JSONObject();
		resp.setCharacterEncoding("UTF-8");
		if (statusCode > 0) {
			json.put("statusCode", statusCode);
		}
		if (!StringUtils.isBlank(message)) {
			json.put("message", message);
		}
		if (!StringUtils.isBlank(navTabId)) {
			json.put("navTabId", navTabId);
		}
		if (!StringUtils.isBlank(callbackType)) {
			json.put("callbackType", callbackType);
		}
		try {
			resp.getWriter().println(json.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
