package com.ibeifeng.s2sh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ibeifeng.s2sh.model.User;
import com.ibeifeng.s2sh.model.HotMovies;
import com.ibeifeng.s2sh.model.Manager;
import com.ibeifeng.s2sh.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
@Controller("userAction")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
private UserService userService;
private User user;
public String signIn(){
	HttpServletRequest reqeust= ServletActionContext.getRequest();
	int movielist=0;
		User users = userService.login(user);
		List<HotMovies> hotmovies=userService.findmovie();
		if(hotmovies.size()%4>0){
		movielist=(hotmovies.size()/4)+1;
		}else{
			movielist=hotmovies.size()/4;  
		}
		List<HotMovies> list2=userService.findMov(1, 4);
		List<HotMovies> list3=userService.findMov(2, 4);
		
		List<List<HotMovies>> list1=new ArrayList<List<HotMovies>>();
		list1.add(list2);
		list1.add(list3);
		/*System.out.println(list1.size()) ;
		System.out.println(list2.size());
		System.out.println("list1的长度为："+list1.size());
		System.out.println(list1.get(1).get(0).getImg());*/
		if(users != null){
			ActionContext.getContext().put("url","/home/main.jsp");
			ActionContext.getContext().getSession().put("hotmovie", list1); 
		System.out.println("loading.....");
		}else{
			return "managerAction";
			/*Manager manager=new Manager();
			manager.setManagename(user.getUsername());
			manager.setManageps(user.getPassword());
			Manager manager1 = userService.findmanager(manager);
			if (manager1 !=null) {
			ActionContext.getContext().put("url", "/model/home_page.jsp");
			}else{
				ActionContext.getContext().put("url", "/home/login.jsp");
				System.out.println("enter.....");
			}*/
		}
		return "redirect";
}

	@Override
	public User getModel() {
         if(user==null){
        	 user=new User();
         }
		return user;
	}
}
