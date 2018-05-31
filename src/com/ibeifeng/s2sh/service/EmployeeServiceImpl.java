package com.ibeifeng.s2sh.service;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.From;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeifeng.s2sh.dao.BaseDao;
import com.ibeifeng.s2sh.model.User;
import com.ibeifeng.s2sh.model.Cinema;
import com.ibeifeng.s2sh.model.HotMovies;
import com.ibeifeng.s2sh.model.Manager;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

@Service("empService")
public class EmployeeServiceImpl implements UserService{
	@Autowired
	private BaseDao<User> baseDao;
	@Autowired
	private BaseDao<HotMovies> basemovie;
	@Autowired
	private BaseDao<Cinema> basecinema;
	@Autowired
	private BaseDao<Manager> basemanager;
	@Override
	public void saveEmp(User emp) {
		baseDao.save(emp);
	}
	
	@Override
	public void delEmp(User emp) {
		baseDao.delete(emp);
	}

	@Override
	public void updateEmp(User emp) {
		baseDao.update(emp);
	}

	@Override
	public User findEmpById(int id) {
		return baseDao.get(User.class, id);
	}

	@Override
	public List<User> findAlls() {
		return baseDao.find("from User");
	}
	@Override
	public User login(User emp) {
		//String hql="select* from td_User where username=?and password=?";
		String hql = "from User emp where emp.username=? and emp.password=?";
		Object[] params = new Object[]{emp.getUsername(),emp.getPassword()};
		return baseDao.get(hql,params);
	}
	
	@Override
	public List<User> findEmp(Integer pagesize,Integer deptId) {
		String hql="from User where dept_id=?";
		
		return null;
	}

	@Override
	public double sumPrice(Integer num, double price) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HotMovies> findmovie() {
		String hql="from HotMovies";
		return basemovie.find(hql);
	}

@Override
	public List<HotMovies> findMov(Integer page,Integer rows) {
		String hql="from HotMovies";
return basemovie.find(hql,  page, rows);
		
	}

	@Override
	public HotMovies findmovieById(int id) {
	
		return basemovie.get(HotMovies.class, id);
	}

	@Override
	public List<Cinema> findcinema(String moviename) {
		String hql="from Cinema where moviename=?";
		return basecinema.findcinema(hql, moviename);
	}

	@Override
	public List<Cinema> findcinemas(Cinema cinema) {
		String hql="from Cinema where moviename=?,cinema=?,movietime=?,districts=? and cinematography=?";
		Object[] params = new Object[]{cinema.getMoviename(),cinema.getCinema(),cinema.getMovietime(),cinema.getDistricts(),cinema.getCinematography()};
		return basecinema.findcinemas(hql,params);
	}

	@Override
	public List<Cinema> queryResultList(String className, Map<String, Object> varables) {
		List<Cinema> valueList = basecinema.selectStatement(className, varables);
        return valueList;
	}
	@Override
	public Manager findmanager(Manager manager) {
		String hql = "from Manager manager where manager.managername=? and manager.managerpw=?";
		Object[] params = new Object[]{manager.getManagername(),manager.getManagerpw()};
		return basemanager.get(hql,params);
	}

	@Override
	public Manager findmanager(int id) {
		return basemanager.get(Manager.class, id);
	}

	@Override
	public void updateManager(Manager manager) {
		basemanager.update(manager);
		
	}

	@Override
	public List<Manager> findManagerAll() {
		return basemanager.find("from Manager");
	}

	@Override
	public void delManager(Manager manager) {
		basemanager.delete(manager);
		
	}

	@Override
	public void saveManager(Manager manager) {
	basemanager.save(manager);
		
	}



	
	
}
