package com.entity;
//单子类
public class Task {
	private int id;
	private int num;
	private String uid;
	private String uname;
	private String message;		//内容
	private String time;	//时间
	private String site;	//地点
	private String money;	//钱
	private String language;			//多余的
	private String state;	//状态
	private String receive;//接取人id
	private int cid;//收藏
	private int prompt;//提示
	public Task(int id, int num, String uid, String uname, String message, String time, String site, String money,
			String language, String state, String receive, int cid, int prompt) {
		super();
		this.id = id;
		this.num = num;
		this.uid = uid;
		this.uname = uname;
		this.message = message;
		this.time = time;
		this.site = site;
		this.money = money;
		this.language = language;
		this.state = state;
		this.receive = receive;
		this.cid = cid;
		this.prompt = prompt;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive = receive;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPrompt() {
		return prompt;
	}
	public void setPrompt(int prompt) {
		this.prompt = prompt;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", num=" + num + ", uid=" + uid + ", uname=" + uname + ", message=" + message
				+ ", time=" + time + ", site=" + site + ", money=" + money + ", language=" + language + ", state="
				+ state + ", receive=" + receive + ", cid=" + cid + ", prompt=" + prompt + "]";
	}
	
	
}
