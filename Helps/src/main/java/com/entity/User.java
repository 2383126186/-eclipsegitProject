package com.entity;
//用户类
public class User {
	private int id;
	private String uname;
	private String upass;
	private String age;
	private String idCard;
	private String name;
	private String phone;
	private String img;
	private String site;
	private int state;
	private String gender;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String uname, String upass, String age, String idCard, String name, String phone, String img,
			String site, int state, String gender) {
		super();
		this.id = id;
		this.uname = uname;
		this.upass = upass;
		this.age = age;
		this.idCard = idCard;
		this.name = name;
		this.phone = phone;
		this.img = img;
		this.site = site;
		this.state = state;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upass=" + upass + ", age=" + age + ", idCard=" + idCard
				+ ", name=" + name + ", phone=" + phone + ", img=" + img + ", site=" + site + ", state=" + state
				+ ", gender=" + gender + "]";
	}
	
	
	
	
	
	
}
