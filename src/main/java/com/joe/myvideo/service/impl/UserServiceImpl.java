package com.joe.myvideo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.myvideo.entity.User;
import com.joe.myvideo.service.UserService;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserService userService;

	/**
	 * 查询总记录数
	 * @param 
	 * @return
	 */
	public int getTatolCount(Map<String, Object> params){
		return userService.getTatolCount(params);
	}
	
    /**
     * 分页列表
     * @param params
     * @return
     */
    public List<User> pageList(Map<String, Object> params){
    	return userService.pageList(params);

    }
    
	
	/**
	 * 依据实体属性获取实体
	 * @param entity
	 * @return
	 */
    public List<User> getUserByName(String userName){
    	return userService.getUserByName(userName);
    }
    
	/**
	 * 添加实体
	 * @param entity
	 * @return
	 */
    public int add(User entity){
    	return userService.add(entity);
    }
    
    /**
     * 检查用户名格式
     * @param userName
     * @return
     */
    public boolean checkNamePattern(String userName) {
		String pattern = "^[\u4e00-\u9fa5_a-zA-Z0-9_]{2,10}$";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(userName);
		if(m.matches()){
			return true;
		}
		return false;
    }
    
    /**
     * 检查密码格式
     * @param userName
     * @return
     */
    public boolean checkPasswordPattern(String userName) {
		String pattern = "^[a-zA-Z0-9_]{6,12}$";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(userName);
		if(m.matches()){
			return true;
		}
		return false;
    }
    
    /**
     * 检查邮箱格式
     * @param userName
     * @return
     */
    public boolean checkEmailPattern(String userName) {
		String pattern = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(userName);
		if(m.matches()){
			return true;
		}
		return false;
    }

	/**
	 * 依据实体属性获取实体
	 * @param entity
	 * @return
	 */
    public List<User> get(User user){
    	return userService.get(user);
    }
    
    public User getUserById(int id){
    	return userService.getUserById(id);
    }
}
