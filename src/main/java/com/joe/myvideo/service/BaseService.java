package com.joe.myvideo.service;

import java.util.List;

import com.joe.myvideo.util.Pager;

/**
 * 
 * @author zhoucijoe
 *
 * @param <T>
 */
public interface BaseService<T> {


    public List<T> get(T entity);
    
    public T getUserById(int id);
    
    public int add(T entity);
    
    public void update(T entity);
    
    public void delete(int entity);

    public List<T> list(String sql, Object...params);
    
	public Pager<T> pager( String sql, int pageNo, int pageSize, Object... params );
	
}