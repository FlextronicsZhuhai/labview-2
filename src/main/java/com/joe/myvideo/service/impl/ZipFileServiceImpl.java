package com.joe.myvideo.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.joe.myvideo.entity.User;
import com.joe.myvideo.entity.ZipFile;
import com.joe.myvideo.enums.DecodeStatusEnum;
import com.joe.myvideo.service.ZipFileService;
import com.joe.myvideo.util.DateUtils;
import com.joe.myvideo.util.HttpUtils;
import com.joe.myvideo.util.StringUtils;
import com.joe.myvideo.util.SysConfig;
import com.joe.myvideo.util.T;
import com.joe.myvideo.util.ZipUtil;

@Service
public class ZipFileServiceImpl {
	
	/**
	 * log
	 */
	public static Log log = LogFactory.getLog(ZipFileServiceImpl.class);
	private static final String location = "/service.jsp";
	private static final String basePath = SysConfig.getConfig("upload.path");
	private static final String temPath = SysConfig.getConfig("upload.temPath");
	private static final String decode = SysConfig.getConfig("upload.decode");
	private static final String repress = SysConfig.getConfig("upload.repress");
	
	@Autowired
	private ZipFileService zipFileService;
	
	/**
	 * 添加实体
	 * @param entity
	 * @return
	 */
    public int add(ZipFile entity){
    	return zipFileService.add(entity);
    }
    /**
     * 分页列表
     * @param params
     * @return
     */
    public List<ZipFile> pageList(Map<String, Object> params){
    	if(params != null)
    		return zipFileService.pageList(params);
    	else
    		return null;
    }
    
    /**
     * 条件查询
     * @param params
     * @return
     */
	public ZipFile getByCondition(Map<String, Object> params){
		return zipFileService.getByCondition(params);
	}
	
	/**
	 *更新状态
	 * @param zipFile
	 * @return
	 */
	public int updateStatus(ZipFile zipFile){
		return zipFileService.updateStatus(zipFile);
	}
	
	/**
	 * 查询总记录数
	 * @param zipFile
	 * @return
	 */
	public int getTatolCount(Map<String, Object> params){
		return zipFileService.getTatolCount(params);
	}
	
	/**
	 * 操作文件
	 * @throws IOException 
	 */
	public void operaFile(HttpServletResponse res, User user ,int zipId ,int userId ,String opera) throws Exception{
        if(user != null && zipId > 0 && userId > 0){
        	if(userId == user.getId()){
        		Map<String, Object> params = new HashMap<String,Object>();
        		params.put("id", zipId);
        		params.put("userId", userId);
        		params.put("status", 6);
        		ZipFile zipFile = getByCondition(params);

        		switch (opera) {
				case "download":
					download(zipFile, res ,user);
					break;
				case "delete":
					delete(zipFile, res);
					break;
				case "decode":
					decode(zipFile, res , user);
					break;
				
				default:
					throw new RuntimeException("操作符不明确");
				}
        	}else{
        		T.alert(res, "文件不属于你", location);
        	}
        }else{
        	if(user == null){
        		T.alert(res, "你尚未登录", "/login.jsp");
        	}else {
        		T.alert(res, "参数有误，下载失败", location);
        	}
        }
	}
	
	public void download(ZipFile zipFile , HttpServletResponse res ,User user) throws Exception{
			if(zipFile.getStatus() == DecodeStatusEnum.ALREADY_TO_FIX.getKey()){
				String outPath = repress
						+"\\"
						+user.getId()
						+"\\"
						+zipFile.getTempName()+".zip";//压输出路径
				
				ZipUtil.ZipFiles(zipFile.getDecodePath(), "C:\\Users\\zhoucijoe\\Desktop\\hh\\6666.zip");
				
				zipFile.setRePressPath(outPath);
				zipFile.setUpdateAt(new Date());
				zipFileService.update(zipFile);//更新数据库
			}
			
			String path = zipFile.getFilePath();
			
			File file=new File(path);
			if(file.exists()){
			
			
			long fileLength = file.length(); 
			String fileName = new String(zipFile.getOriginName().getBytes("UTF-8"),"iso-8859-1");
			//为了解决中文名称乱码问题  
			
			res.setContentType("application/x-compress");
			res.setHeader("Content-disposition", "attachment; filename="+fileName);  
			res.setHeader("Content-Length", String.valueOf(fileLength));  
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));  
			BufferedOutputStream bos = new BufferedOutputStream(res.getOutputStream());  
			byte[] buff = new byte[2048];  
			int bytesRead;  
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
				bos.write(buff, 0, bytesRead);  
			}  
			bis.close();  
			bos.close();
			
			zipFile.setDownloadDate(new Date());
			zipFile.setUpdateAt(new Date());
			zipFileService.update(zipFile);//更新数据库
		}else{
			T.alert(res, "文件不存在", location);
		}
	}
	
	public void delete(ZipFile zipFile ,HttpServletResponse res) throws Exception{
		if(zipFile.deleteFlie()){
			zipFile.setStatus(DecodeStatusEnum.ALREADY_TO_DELETE.getKey());
			if(updateStatus(zipFile) > 0){	
				T.alert(res, "删除成功", location);
			}else{
				T.alert(res, "删除失败", location);
			}
		}else{
			T.alert(res, "文件不存在", location);
		}
	}
	
	public void decode(ZipFile zipFile , HttpServletResponse res ,User user) throws Exception{
		File file=new File(zipFile.getUploadPath());
		if(file.exists()){
			String outputDir = temPath
					+File.separator
					+user.getId()
					+File.separator
					+zipFile.getTempName();//解压输出路径
			
			String outPathRoot = decode
					+File.separator
					+user.getId()
					+File.separator
					+zipFile.getTempName();//解密输出路径

			try{
				ZipUtil.unZipFiles(file, outputDir);
				int status =  DecodeStatusEnum.IS_FIXING.getKey();
				zipFile.setStatus(status);
				zipFile.setDepressPath(outputDir);
				zipFileService.update(zipFile);
				
				String phpRoot = SysConfig.getConfig("php.root");
				String result = HttpUtils.sendGet(phpRoot ,"inPathRoot="+outputDir+"&outPathRoot="+outPathRoot);
				String now = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
				
				log.info("["+now+"] : 向解密系统发出请求,userId="+user.getId()+user.getUsername()+"&fileId="+zipFile.getId());
				log.info("["+now+"] : 返回结果" + result);
				
				JSONObject json = JSONObject.parseObject(result);
				if(json.getInteger("status") == 1){
					T.alert(res, "解密请求已提交，请稍等片刻", location);
				}else{
					T.alert(res, "解密请求异常，请重试或联系管理员", location);
				}
			}catch (Exception e) {
				log.error("解密失败" ,e);
				T.alert(res, "解密失败，请稍后再试", location);
			}
		}else{
			T.alert(res, "文件不存在", location);
		}
	}


}
