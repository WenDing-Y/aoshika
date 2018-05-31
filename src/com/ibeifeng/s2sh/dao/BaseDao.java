package com.ibeifeng.s2sh.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ibeifeng.s2sh.model.User;
public interface BaseDao<T> {
	public T get(Class<T> clz, Serializable id);
	public T get(String hql,Object[] params);
	public T get(String hql,List<Object> params);
	public Serializable save(T t);
	public void delete(T t);
	public void update(T t);
	public void saveOrUpdate(T t);
	public List<T> find(String hql);
	public List<T> find(String hql,Object[] params);
	public List<T> find(String hql,List<Object> params);
	public List<T> find(String hql,Integer page,Integer rows);
	public List<T> find(String hql,List<Object> params,Integer page,Integer rows);
	public List<User> findEmp(String hql,Integer count, Integer pagesize,Integer deptId);
	public Long count(String hql,Object[] params);
	public Long count(String hql,List<Object> params);
	public List<User> count(String hql,int id);
	public double sumPrice(Integer num,double price);
	public Integer executeHql(String hql);
	public Integer executeHql(String hql,Object[] params);
	public Integer executeHql(String hql,List<Object> params);
    public List<T> findcinema(String hql,String params );
    public List<T> findcinemas(String hql,Object[] params );
    public List<T> selectStatement(String className, Map<String,Object> varables);
    
    
  
	
}
