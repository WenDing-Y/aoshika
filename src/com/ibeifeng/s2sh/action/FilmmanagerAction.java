package com.ibeifeng.s2sh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ibeifeng.s2sh.model.HotMovies;
import com.ibeifeng.s2sh.model.Manager;
import com.ibeifeng.s2sh.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("filmmanagerAction")
public class FilmmanagerAction  extends ActionSupport implements ModelDriven<HotMovies>{
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	private HotMovies hotmovies;
	public String filmmanager(){
		List<HotMovies> hotMovies=userService.findmovie();
		ActionContext.getContext().getSession().put("film", hotMovies);
		return "filmmanager";
	}
	@Override
	public HotMovies getModel() {
	     if(hotmovies==null){
	    	 hotmovies=new HotMovies();
	     }
		return hotmovies;
	}
}
