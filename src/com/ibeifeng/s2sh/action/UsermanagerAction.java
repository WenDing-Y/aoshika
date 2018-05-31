package com.ibeifeng.s2sh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ibeifeng.s2sh.model.Manager;
import com.ibeifeng.s2sh.model.User;
import com.ibeifeng.s2sh.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("usermanagerAction")
public class UsermanagerAction  extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	private User user;
	public String usermanager(){
		List<User> users=userService.findAlls();
		ActionContext.getContext().getSession().put("user", users);
		return "usermanager";
	}
	public String useradd(){
		userService.saveEmp(user);
		List<User> users=userService.findAlls();
		ActionContext.getContext().getSession().put("user", users);
		return "useradd";
	}
	public String usersub(){
		userService.updateEmp(user);
		List<User> users=userService.findAlls();
		ActionContext.getContext().getSession().put("user", users);
		return "usersub";
	}
	public String usermodify(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String deleteid=request.getParameter("id");
		int id=Integer.parseInt(deleteid);
		User user1=userService.findEmpById(id);
		ActionContext.getContext().getSession().put("user", user1);
		return "usermodify";
	}
	public String userdelete(){
		userService.delEmp(user);
		List<User> users=userService.findAlls();
		ActionContext.getContext().getSession().put("user", users);
		return "userdelete";
	}
	@Override
	public User getModel() {
	     if(user==null){
	    	 user=new User();
	     }
		return user;
	}
}
