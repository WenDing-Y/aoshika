package com.ibeifeng.s2sh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="cinema")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Cinema {
private int id;
private String cinema;
private String movietime;
private String districts;
private String cinematography;
private String moviename;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCinema() {
	return cinema;
}
public void setCinema(String cinema) {
	this.cinema = cinema;
}
public String getMovietime() {
	return movietime;
}
public void setMovietime(String movietime) {
	this.movietime = movietime;
}
public String getDistricts() {
	return districts;
}
public void setDistricts(String districts) {
	this.districts = districts;
}
public String getCinematography() {
	return cinematography;
}
public void setCinematography(String cinematography) {
	this.cinematography = cinematography;
}
public String getMoviename() {
	return moviename;
}
public void setMoviename(String moviename) {
	this.moviename = moviename;
}

}
