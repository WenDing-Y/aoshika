package com.ibeifeng.s2sh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Manager")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Manager {
private int id ;
private String managername;
private String managerpw;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getManagerpw() {
	return managerpw;
}
public void setManagerpw(String managerpw) {
	this.managerpw = managerpw;
}
public String getManagername() {
	return managername;
}
public void setManagername(String managername) {
	this.managername = managername;
}


}
