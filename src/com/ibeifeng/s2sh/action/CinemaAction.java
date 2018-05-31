package com.ibeifeng.s2sh.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibeifeng.s2sh.dao.BaseDao;
import com.ibeifeng.s2sh.dao.BaseDaoImpl;
import com.ibeifeng.s2sh.model.Cinema;
import com.ibeifeng.s2sh.model.HotMovies;
import com.ibeifeng.s2sh.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller("cinemaAction")
public class CinemaAction extends ActionSupport implements ModelDriven<Cinema> {
@Autowired
private UserService userservice;
@Autowired
private BaseDao basedao;
@Autowired
private BaseDaoImpl basedaoimpl;
private HotMovies hotmovies;
private Cinema cinema;
private String moviesname;
public SessionFactory sessionfactory;
public String findCinema(){
	HttpServletRequest reqeust= ServletActionContext.getRequest();
	moviesname=(String) reqeust.getAttribute("moviename");
	System.out.println(moviesname);
	 List<Cinema> cinema=userservice.findcinema(moviesname);
	System.out.println(cinema.get(0).getCinema());
	ActionContext.getContext().put("cinemas", cinema);
	return "cinemas";
}
@ResponseBody
public List<Cinema>  district(){
	System.out.println("loadin,,,,,");
	HttpServletRequest request= ServletActionContext.getRequest();
	String district=request.getParameter("district");
	String movietime=request.getParameter("movietime");
	String cinemas=request.getParameter("cinema");
	String cinematography=request.getParameter("cinematography");
	String moviename=request.getParameter("moviename");
	System.out.println("loadin,,,,,2");

    Map<String, Object> map = new HashMap<String, Object>();
    map.put("moviename", "阿道夫");
    map.put("district", district);
    map.put("cinema", cinemas);
    map.put("cinematography", cinematography);
    map.put("movietime", movietime);
    
	System.out.println("loadin,,,,,3");

    String classname="Cinema";
    List<Cinema> cinemass =userservice.queryResultList(classname,map);
	System.out.println("loadin,,,,,4");

    for (Cinema cinema : cinemass) {
        System.out.println("滴滴滴滴555"+cinema.getCinema());
    }
    JSONArray listArray=JSONArray.fromObject(cinemass);
    JSONObject jsonPP = new JSONObject();
    jsonPP.put("aaaa", listArray);
    return cinemass;
}
	@Override
	public Cinema getModel() {
		if(cinema==null){
			cinema=new Cinema();
		}
		return cinema;
	}
}
