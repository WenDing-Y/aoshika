package com.ibeifeng.s2sh.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ibeifeng.s2sh.dao.LoginUtils;
@Controller("elecHomeAction")  
public class ElecHomeAction extends BaseAction { 
private LoginUtils loginUtils=new LoginUtils();
  
public String home() throws IOException{  
        loginUtils.createCookie(request, response);
        return "home";  
}
/*@Override
public LoginUtils getModel() {
	if(loginUtils!=null){
		loginUtils=new LoginUtils();
	}
	return loginUtils;
}  */
}
