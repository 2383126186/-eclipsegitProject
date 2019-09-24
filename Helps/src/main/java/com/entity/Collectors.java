package com.entity;
//收藏表
public class Collectors {
	private int id;
	private int uid;
	private int tid;
	public Collectors(int id, int uid, int tid) {
		super();
		this.id = id;
		this.uid = uid;
		this.tid = tid;
	}
	public Collectors() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "collector [id=" + id + ", uid=" + uid + ", tid=" + tid + "]";
	}
	
}
