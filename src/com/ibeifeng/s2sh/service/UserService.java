package com.ibeifeng.s2sh.service;

import java.util.List;
import java.util.Map;

import com.ibeifeng.s2sh.model.User;
import com.ibeifeng.s2sh.model.Cinema;
import com.ibeifeng.s2sh.model.HotMovies;
import com.ibeifeng.s2sh.model.Manager;
import com.ibeifeng.s2sh.model.User;

public interface UserService {
	public List<HotMovies> findmovie();
	public void saveEmp(User emp);
	public void delEmp(User emp);
	public void updateEmp(User emp);
	public User findEmpById(int id);
	public HotMovies findmovieById(int id);
	public List<User> findAlls();
	public User login(User emp);
	public Manager findmanager(Manager manager);
    public List<User> findEmp(Integer pagesize,Integer deptId);
    public List<HotMovies> findMov(Integer page,Integer rows); 
    public double sumPrice(Integer num,double price);
    public List<Cinema> findcinema(String moviesname);
    public List<Cinema> findcinemas(Cinema cinema);
    public List<Cinema> queryResultList(String className, Map<String,Object> varables);
    public Manager findmanager(int id);
    public void updateManager(Manager manager);
    public List<Manager> findManagerAll();
    public void delManager(Manager manager);
    public void saveManager(Manager manager);
  
}
