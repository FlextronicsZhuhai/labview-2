package com.joe.myvideo.web;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joe.myvideo.entity.User;
import com.joe.myvideo.service.impl.UserServiceImpl;
import com.joe.myvideo.util.EncryptionUtils;
import com.joe.myvideo.util.StringUtils;
import com.joe.myvideo.util.SysConfig;
import com.joe.myvideo.util.T;

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * log
	 */
	public static Log log = LogFactory.getLog(UserController.class);
	private static final String root = SysConfig.getConfig("system.root");
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	
	@RequestMapping("/checkusername.do")
	public void getValidCode(HttpServletRequest req,HttpServletResponse res,HttpSession session){
		String userName = StringUtils.get(req.getParameter("userName"),"");
		PrintWriter out = null;
		try {
			out = res.getWriter();
			if(!userServiceImpl.checkNamePattern(userName)){
				out.println("2");//名字格式不正确
			}else{
				List<User> users= userServiceImpl.getUserByName(userName);
				System.out.println("users"+users.size());
				if(users.size() > 0){
					out.print("1");
				}
			}
		} catch (Exception e) {
			log.error("检查用户名发生异常",e);
			out.print("3");
		}
	}
	
	@RequestMapping("/register.do")
	public String register(HttpServletRequest req,HttpServletResponse res,HttpSession session){
		String userName = req.getParameter("UserName");
		String password = req.getParameter("Password");
		String confirmPassword = req.getParameter("ConfirmPassword");
		String email = req.getParameter("Email");
		
		String msg = null;
		try{
			if(session.getAttribute("currentUser") != null){
				msg = "你已经成功登陆了，退出点击<a href='"+root+"/user/out.do?from=register"+"' style='color: blue;'>这里>></a>";
				req.setAttribute("msg", msg);
			}else if(StringUtils.isBlank(userName)
					||StringUtils.isBlank(password)
					||StringUtils.isBlank(confirmPassword)
					||StringUtils.isBlank(email)){
				msg = "请正确输入完整的注册信息";
				req.setAttribute("msg", msg);
			}else if(userServiceImpl.getUserByName(userName).size() > 0){
				msg = "用户名"+userName+"已存在";
				req.setAttribute("msg", msg);
			}else if(!password.equals(confirmPassword)){
				msg = "密码两次输入不一致";
				req.setAttribute("msg", msg);
			}else if(!userServiceImpl.checkNamePattern(userName)
					|| !userServiceImpl.checkPasswordPattern(password)
					|| !userServiceImpl.checkEmailPattern(email)){
				msg = "请正确输入正确格式的注册信息";
				req.setAttribute("msg", msg);
			}else{
				User user = new User();
				user.setUsername(userName);
				user.setPassword(EncryptionUtils.md5("labview"+password));
				user.setEmail(email);
				user.setUpdateAt(new Date());
				user.setCreateAt(new Date());
				user.setStatus(1);
				
					int id = userServiceImpl.add(user);
					if(id > 0){
						user.setId(id);//注册更新id
						session.setAttribute("currentUser", userServiceImpl.getUserById(id));
				    	T.alert(res, "注册成功，欢迎<font color='green'>"+userName+"</font>", "/index.jsp");
						return null;
					}else{
						msg = "注册失败，请重新注册";
						req.setAttribute("msg", msg);
					}
			}
		}catch (Exception e) {
			log.error("注册用户发生异常",e);
			msg = "注册失败，请重新注册";
			req.setAttribute("msg", msg);
		}
		return "register";
	}
	
	@RequestMapping("/out.do")
	public void out(HttpServletRequest req,HttpServletResponse res,HttpSession session){
		try {
			if(session.getAttribute("currentUser") != null){
				session.invalidate();
				T.alert(res, "退出成功", "/login.jsp");
			}else{
				T.alert(res, "你尚未登陆", "/login.jsp");
			}
		}catch (Exception e) {
			log.error("用户退出登陆发生异常",e);
			String from = req.getParameter("from");
			T.alert(res, "退出失败", "/"+from+".jsp");
		}
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest req,HttpServletResponse res,HttpSession session){
		
		String userName = req.getParameter("UserName");
		String password = req.getParameter("Password");
		String msg = null;
		try {
			if(session.getAttribute("currentUser") != null){
				msg = "你已经登陆，请勿重复操作";
				req.setAttribute("msg", msg);
			}else if(StringUtils.isBlank(userName)
				||StringUtils.isBlank(password)){
				msg = "请正确输入完整的注册信息";
				req.setAttribute("msg", msg);
			}else{
				User user = new User();
				user.setUsername(userName);
				user.setStatus(1);
				user.setPassword(EncryptionUtils.md5("labview"+password));
				List<User> users = userServiceImpl.get(user);
				if(users.size() == 1){
			    	
					session.setAttribute("currentUser", users.get(0));//数据库中user
					T.alert(res, "登陆成功", "/index.jsp");
					return null;
				}else if(users.size() == 0){
					msg = "登陆名或密码错误，请重新登陆";
					req.setAttribute("msg", msg);
				}else{
					msg = "账号异常，请与管理员联系";
					req.setAttribute("msg", msg);
				}
			}
		}catch (Exception e) {
			log.error("用户登陆发生异常",e);
			msg = "登陆失败，请重新登陆";
			req.setAttribute("msg", msg);
		}
		return "login";
	}
}
