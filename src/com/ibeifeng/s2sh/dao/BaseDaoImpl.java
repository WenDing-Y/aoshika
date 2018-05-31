package com.ibeifeng.s2sh.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibeifeng.s2sh.model.Cinema;
import com.ibeifeng.s2sh.model.User;
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T>{
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	} 

	@Override
	public T get(Class<T> clz, Serializable id) {
		return (T)getSession().get(clz, id);
	}

	@Override
	public T get(String hql, Object[] params) {
		List<T> list = this.find(hql,params);
		if(list !=null&&list.size()>0){
			return list.get(0);
		}else{
		System.out.println(".....");
		return null;
		}
	}

	@Override
	public T get(String hql, List<Object> params) {
		List<T> list = this.find(hql, params);
		if(list!= null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Serializable save(T t) {
		return getSession().save(t);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getSession().saveOrUpdate(t);
	} 

	@Override
	public List<T> find(String hql) {
		return getSession().createQuery(hql).list();
	}

	@Override
	public List<T> find(String hql, Object[] params) {
		Query query = getSession().createQuery(hql);
		if(params != null && params.length>0){
			for(int i=0;i<params.length;i++){
				query.setParameter(i, params[i]);
				System.out.println("3333");
			}
		}
		System.out.println("22222");
		return query.list();
	}

	@Override
	public List<T> find(String hql, List<Object> params) {
		Query query = getSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(int i = 0;i < params.size(); i++){
				query.setParameter(i, params.get(i));
			}
		}
		return query.list();
	}

	@Override
	public List<T> find(String hql, Integer page, Integer rows) {
		if(page == null || page < 1){
			page = 1;
		}
		if(rows == null || rows < 1){
			rows = 5;
		}
		Query query = getSession().createQuery(hql);
		
		return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}

	@Override
	public List<T> find(String hql, List<Object> params, Integer page, Integer rows) {
		if(page == null || page < 1){
			page = 1;
		}
		if(rows == null || rows < 1){
			rows = 5;
		}
		Query query = getSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(int i = 0;i < params.size(); i++){
				query.setParameter(i, params.get(i));
			}
		}
		return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	@Override
	public Long count(String hql, Object[] params) {
		Query query = getSession().createQuery(hql);
		if(params != null && params.length > 0){
			for(int i = 0;i < params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		return (Long)query.uniqueResult();
	}

	@Override
	public Long count(String hql, List<Object> params) {
		Query query = getSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(int i = 0;i < params.size(); i++){
				query.setParameter(i, params.get(i));
			}
		}
		return (Long)query.uniqueResult();
	}

	@Override
	public Integer executeHql(String hql) {
		return getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public Integer executeHql(String hql, Object[] params) {
		Query query = getSession().createQuery(hql);
		if(params != null && params.length > 0){
			for(int i = 0;i < params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		return query.executeUpdate();
	}

	@Override
	public Integer executeHql(String hql, List<Object> params) {
		Query query = getSession().createQuery(hql);
		if(params != null && params.size() > 0){
			for(int i = 0;i < params.size(); i++){
				query.setParameter(i,params.get(i));
			}
		}
		return query.executeUpdate();
	}

	@Override
	public List<User> count(String hql,int id) {
		Query query=getSession().createQuery(hql);
			query.setParameter(0, id);
		return query.list();
	}
	@Override
	public List<User> findEmp(String hql,Integer page, Integer pagesize, Integer deptId) {
     Query query=getSession().createQuery(hql);
     query.setParameter(0, deptId);
      query.setFirstResult((page-1)*pagesize);
     query.setMaxResults(pagesize);
    return query.list();
  
	}


	@Override
	public double sumPrice(Integer num, double price) {
		
		return num*price;
	}
	@Override
	public List<T> findcinema(String hql,String params){
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.setParameter(0, params);
		return query.list();
	}

	@Override
	public List<T> findcinemas(String hql, Object[] params) {
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		if(params != null && params.length > 0){
			for(int i = 0;i < params.length; i++){
				query.setParameter(i,params[i]);
			}
		}
		return query.list();
	}
	public List<T>  selectStatement(String className, Map<String,Object> varables) {
		HashMap map=new HashMap();
		int a=0;
		Object[] params=new Object[]{};
        StringBuilder stringBuilder = new StringBuilder();
        /*
         * 通过className得到该实体类的字符串形式,
         */
        stringBuilder.append("from " + className);
        stringBuilder.append(" where 1=1 ");
        /*
         * 动态的拼接sql语句,如果一个属性的值为"", 则不往条件中添加.
         */
        for(Entry<String, Object> entry : varables.entrySet()){
            if(!entry.getValue().equals(" ")){
                stringBuilder.append(" and " + entry.getKey()+"=?");
                map.put(a,entry.getValue());
                a++;
            }
        }
System.out.println(stringBuilder.toString());
        Query query = getSession().createQuery(stringBuilder.toString());
        for(int i=0;i<a;i++){
        	query.setParameter(i,map.get(i));
        }
        /*
         * 动态的给条件赋值
         */
      /*  for(Entry<String, Object> entry : varables.entrySet()){
            if(!entry.getValue().equals(" ")){
                query.setParameter(entry.getKey(),entry.getValue());
            }
        }*/
      /* String name="大地影城";
        query.setParameter(0, name);
        query.setParameter(1, "阿道夫");  
        System.out.println("loading");*/
        System.out.println(query.list().size());
        return query.list();
    }
}
