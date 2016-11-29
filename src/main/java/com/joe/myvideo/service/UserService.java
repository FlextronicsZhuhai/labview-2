package com.joe.myvideo.service;

import java.util.List;

import com.joe.myvideo.entity.User;

public interface UserService extends BaseService<User> {
	
	/**
	 * 依据实体属性获取实体
	 * @param entity
	 * @return
	 */
    public List<User> getUserByName(String userName);

}
