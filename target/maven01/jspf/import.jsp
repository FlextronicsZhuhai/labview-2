<%@page import="com.joe.myvideo.util.SysConfig"%>
<%@page import="com.joe.myvideo.util.SpringCtxUtils"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<%
String systemName = SysConfig.getConfig("system.systemName");
String root = SysConfig.getConfig("system.root");

request.setAttribute("systemName", systemName);
request.setAttribute("root", root);
%>
