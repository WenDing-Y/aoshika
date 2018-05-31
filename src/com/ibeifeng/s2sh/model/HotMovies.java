package com.ibeifeng.s2sh.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="hotmovies")
@DynamicInsert(true)
@DynamicUpdate(true)
public class HotMovies {
private int id ;
private String moviename;
private String tostar;
private String data;
private int releasetime;
private int img;
private String director;
private String price;
private String introduction;
public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public int getImg() {
	return img;
}
public void setImg(int img) {
	this.img = img;
}
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMoviename() {
	return moviename;
}
public void setMoviename(String moviename) {
	this.moviename = moviename;
}
public String getTostar() {
	return tostar;
}
public void setTostar(String tostar) {
	this.tostar = tostar;
}
public int getReleasetime() {
	return releasetime;
}
public void setReleasetime(int releasetime){
	this.releasetime = releasetime;
}
}
