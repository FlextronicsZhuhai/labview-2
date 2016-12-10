package com.joe.myvideo.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

public class ZipFile implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int userId;
	
	/**
	 * 文件原名字
	 */
	private String originName;
	/**
	 * 文件临时名字
	 */
	private String tempName;
	/**
	 * 上传路径
	 */
	private String uploadPath;
	/**
	 * 解压路径
	 */
	private String depressPath;
	/**
	 * 解密后路径
	 */
	private String decodePath;
	/**
	 * 重新压缩路径
	 */
	private String rePressPath;
	/**
	 * 下载时间
	 */
	private Date downloadDate;
	
	private int status;
	
	private long size;
	
    private Date createAt; 
    private Date updateAt; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public Date getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getDepressPath() {
		return depressPath;
	}

	public void setDepressPath(String depressPath) {
		this.depressPath = depressPath;
	}

	public String getDecodePath() {
		return decodePath;
	}

	public void setDecodePath(String decodePath) {
		this.decodePath = decodePath;
	}

	public String getRePressPath() {
		return rePressPath;
	}

	public void setRePressPath(String rePressPath) {
		this.rePressPath = rePressPath;
	}

	/**
	 * 格式化文件大小
	 * @return
	 */
    public String getSizeString(){  
        DecimalFormat df = new DecimalFormat("0.00");  
        String mysize = "";  
        if( size > 1024*1024){  
          mysize = df.format( size / 1024f / 1024f ) +"M";  
        }else if( size > 1024 ){  
          mysize = df.format( size / 1024f ) +"K";  
        }else{  
          mysize = size + "B";  
        }  
        return mysize;  
    }  
	
}
