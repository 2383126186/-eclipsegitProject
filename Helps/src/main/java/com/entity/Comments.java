package com.entity;
//评论
public class Comments {
	private int id;
	private String uname;
	private String comment;
	private int tid;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Comments(int id, String uname, String comment, int tid) {
		super();
		this.id = id;
		this.uname = uname;
		this.comment = comment;
		this.tid = tid;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", uname=" + uname + ", comment=" + comment + ", tid=" + tid + "]";
	}
	
}
