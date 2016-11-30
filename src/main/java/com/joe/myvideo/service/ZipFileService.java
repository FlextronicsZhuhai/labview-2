package com.joe.myvideo.service;

import java.util.List;
import java.util.Map;

import com.joe.myvideo.entity.ZipFile;

public interface ZipFileService extends BaseService<ZipFile> {
	
	public List<ZipFile> pageList(Map<String, Object> params);
	
	public ZipFile getByCondition(Map<String, Object> params);
	
	public int updateStatus(ZipFile zipFile);
	
	public int getTatolCount(Map<String, Object> params);
}
