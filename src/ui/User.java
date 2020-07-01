package ui;

import java.awt.Image;
import java.util.ArrayList;

public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	private ArrayList<Image> images;
	private ArrayList<Image> thumbs;

	public User() {
		this.images = new ArrayList<>();
		this.thumbs = new ArrayList<>();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setThumbs(ArrayList<Image> thumbs) {
		this.thumbs = thumbs;
	}

	public ArrayList<Image> getThumbs() {
		return this.thumbs;
	}

	public void setImages(ArrayList<Image> imgs) {
		this.images = imgs;
	}

	public ArrayList<Image> getImages() {
		return this.images;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserName() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password =password;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
}



