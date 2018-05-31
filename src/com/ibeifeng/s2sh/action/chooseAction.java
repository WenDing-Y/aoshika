package com.ibeifeng.s2sh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ibeifeng.s2sh.model.HotMovies;
import com.ibeifeng.s2sh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("choose")
public class chooseAction extends ActionSupport implements ModelDriven<HotMovies>{
private HotMovies hotmovies;
@Autowired
private UserService userservice;
public String moviesname;
public String findmovies(){
HttpServletRequest reqeust= ServletActionContext.getRequest();
int id=Integer.parseInt(reqeust.getParameter("id"));
	hotmovies=userservice.findmovieById(id);
	moviesname=hotmovies.getMoviename();
	reqeust.getSession().setAttribute("moviesname", moviesname);
	reqeust.setAttribute("moviename", moviesname);
	ServletActionContext.getContext().getSession().put("movies", hotmovies);
	System.out.println("转向成功？");
	return "chooses";
}
	@Override
	public HotMovies getModel() {
if(hotmovies==null){
	hotmovies=new HotMovies();
}
		return hotmovies;
	}
	
}
