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
@Controller("managerAction")
public class ManagerAction  extends ActionSupport implements ModelDriven<Manager>{
	private static final long serialVersionUID = 1L;
@Autowired
private UserService userService;
private Manager manager;
public String manager(){
	HttpServletRequest request= ServletActionContext.getRequest();
	String s1=request.getParameter("username");
	String s2=request.getParameter("password");
	manager.setManagername(s1);
	manager.setManagerpw(s2);
	Manager manager1 = userService.findmanager(manager);
	List<Manager> manager=userService.findManagerAll();
	if (manager1 !=null) {
	ActionContext.getContext().put("url", "/model/home_page.jsp");
	ActionContext.getContext().getSession().put("manager", manager);
	}else{
		ActionContext.getContext().put("url", "/home/login.jsp");
		System.out.println("enter.....666");
	}
	return "manageraction";
}
public String managermodify(){
	HttpServletRequest request= ServletActionContext.getRequest();
	String  managerId=request.getParameter("id");
	int id=Integer.parseInt(managerId);
Manager manager=userService.findmanager(id);
ActionContext.getContext().getSession().put("manager", manager);
	return "managermodify";
}
public String managersub(){
	userService.updateManager(manager);
	List<Manager> manager=userService.findManagerAll();
	ActionContext.getContext().getSession().put("manager", manager);
	return "managersub";
}
public String managerdelete(){
HttpServletRequest request=ServletActionContext.getRequest();
String deleteid=request.getParameter("id");
System.out.println("ID:"+deleteid);
int id=Integer.parseInt(deleteid);
Manager manager1=userService.findmanager(id);
userService.delManager(manager1);
List<Manager> manager=userService.findManagerAll();
ActionContext.getContext().getSession().put("manager", manager);
return "managerdelete";
}
public String manageradd(){
	userService.saveManager(manager);
	List<Manager> manager=userService.findManagerAll();
	ActionContext.getContext().getSession().put("manager", manager);
	return "manageradd";
}
@Override
public Manager getModel() {
     if(manager==null){
    	 manager=new Manager();
     }
	return manager;
}
}
