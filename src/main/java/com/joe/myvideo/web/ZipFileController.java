package com.joe.myvideo.web;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.joe.myvideo.entity.User;
import com.joe.myvideo.entity.ZipFile;
import com.joe.myvideo.enums.DecodeStatusEnum;
import com.joe.myvideo.service.impl.ZipFileServiceImpl;
import com.joe.myvideo.util.DateUtils;
import com.joe.myvideo.util.StringUtils;
import com.joe.myvideo.util.SysConfig;
import com.joe.myvideo.util.T;

@Controller
@RequestMapping("/zipfile")
public class ZipFileController {
	/**
	 * log
	 */
	public static Log log = LogFactory.getLog(UserController.class);
	private static final String location = "/service.jsp";
	private static final String basePath = SysConfig.getConfig("upload.path");
	
	@Autowired
	private ZipFileServiceImpl zipFileServiceImpl;
	
    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    public void upload( @RequestParam(value = "zipFile", required = false) MultipartFile file,HttpServletResponse res, HttpSession session) {
		try {
    		User user = (User) session.getAttribute("currentUser");
    		long size = Long.parseLong(SysConfig.getConfig("upload.maxsize"));
    		
	        if(session.getAttribute("currentUser") == null){
	        	T.alert(res, "你尚未登陆,请登录后再上传", "/login.jsp");
	        }else if(file.getSize() > size){
	        	T.alert(res, "你上传的文件过大", location);
	        }else{
	        	//创建保存的文件的路径
	        	String path = basePath
	        			+File.separator
	        			+user.getId();
	        	//获取该文件的文件名
	        	String fileName = file.getOriginalFilename();
	        	String tempName = user.getId()+"_"+file.getName()+"_"+DateUtils.formatDate(new Date(), "yyyy_MM_dd_HH_mm_ss").trim();
	        	
	        	File targetFile = new File(path, tempName);
	        	if (!targetFile.exists()) {
	        		targetFile.mkdirs();
	        	}
	        	// 保存
	        	file.transferTo(targetFile);
	        	ZipFile zf = new ZipFile();
	        	zf.setCreateAt(new Date());
	        	zf.setUpdateAt(new Date());
	        	zf.setStatus(DecodeStatusEnum.WAIT_TO_FIX.getKey());
	        	zf.setOriginName(fileName);
	        	zf.setTempName(tempName);
	        	
	        	zf.setUploadPath(path + File.separator + tempName);
	        	zf.setSize(file.getSize());
	        	zf.setUserId(user.getId());
	        	if(zipFileServiceImpl.add(zf) > 0){
	        		T.alert(res, "上传成功", location);
	        	}
	        }
        } catch (Exception e) {
        	log.error("用户上传文件发生异常",e);
        	T.alert(res, "上传发生错误，请稍后重试", location);
        }
    }
    
    /**
     * 处理上传文件大小超过限制抛出的异常
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e ,HttpServletResponse res , HttpSession session) {
    	try {
    		T.alert(res, "上传的文件过大", location);
    	}catch (Exception ex) {
    		String userName = "";
    		User user = (User) session.getAttribute("currentUser");
    		if(user != null){
    			userName = user.getUsername();
    		}
        	log.error("用户【"+userName+"】上传文件过大发生异常",e);
        }
    }
    
    @RequestMapping("/opera.do")    
    public void opera(HttpServletRequest req,HttpServletResponse res, HttpSession session){
      int zipId = StringUtils.getInt(req.getParameter("zipId"),0);
      int userId = StringUtils.getInt(req.getParameter("userId"),0);
      User user = (User) session.getAttribute("currentUser");
      String opera = StringUtils.get(req.getParameter("opera"),null);
      
      try {
    	  zipFileServiceImpl.operaFile(res, user, zipId, userId, opera);
		} catch (Exception e) {
			e.printStackTrace();
			T.alert(res, "操作失败", location);
		}
    }
 
}
