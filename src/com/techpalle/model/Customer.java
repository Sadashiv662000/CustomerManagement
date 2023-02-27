package com.techpalle.model;

public class Customer {
	private int cid;
	private String cname;
	private int cage;
	private String cemail;
	private String cpassword;
	
	
	public Customer(int cid, String cname, int cage, String cemail, String cpassword) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cage = cage;
		this.cemail = cemail;
		this.cpassword = cpassword;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

}
