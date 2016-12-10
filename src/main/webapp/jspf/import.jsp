<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.joe.myvideo.service.impl.ZipFileServiceImpl"%>
<%@page import="com.joe.myvideo.entity.ZipFile"%>
<%@page import="java.util.List"%>
<%@page import="com.joe.myvideo.service.ZipFileService"%>
<%@page import="com.joe.myvideo.util.StringUtils"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.joe.myvideo.entity.User"%>
<%@page import="com.joe.myvideo.util.SysConfig"%>
<%@page import="com.joe.myvideo.util.SpringCtxUtils"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="/WEB-INF/enums" prefix="en" %>
    
<%
String systemName = SysConfig.getConfig("system.systemName");
String root = SysConfig.getConfig("system.root");
String email = SysConfig.getConfig("system.email");

request.setAttribute("systemName", systemName);
request.setAttribute("root", root); 
request.setAttribute("email", email); 
%>
