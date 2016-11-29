package com.joe.myvideo.entity;

import java.io.Serializable;
import java.util.Date;

public class ZipFile implements Serializable{

	/**
	 * 
	 */
	public static final int WAIT_TO_FIX = 0;//等候处理
	public static final int ALREADY_TO_FIX = 1;//已经处理完成
	public static final int ALREADY_TO_DOWNLOAD = 2;//已经被下载
	public static final int ALREADY_TO_DATE = 3;//已经过期
	public static final int IS_ILLEGAL = 4;//不合法文件
	public static final int CAN_NOT_FIX = 5;//不能解密
	public static final int ALREADY_TO_DELETE = 6;//已删除
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int userId;
	
	private String originName;
	
	private String tempName;
	
	private Date downloadDate;
	
	private int status;
	
	private float size;
	
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

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
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
	
	
	
}
