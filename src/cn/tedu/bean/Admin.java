package cn.tedu.bean;

public class Admin {
	private int id;
	private String Uname;
	private String Password;
	private String School;
	private String Createtime;
	private String Crname;
	private int Lv;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public String getCreatetime() {
		return Createtime;
	}
	public void setCreatetime(String createtime) {
		Createtime = createtime;
	}
	public String getCrname() {
		return Crname;
	}
	public void setCrname(String crname) {
		Crname = crname;
	}
	public int getLv() {
		return Lv;
	}
	public void setLv(int lv) {
		Lv = lv;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id, String uname, String password, String school, String createtime, String crname, int lv,
			String phone) {
		super();
		this.id = id;
		Uname = uname;
		Password = password;
		School = school;
		Createtime = createtime;
		Crname = crname;
		Lv = lv;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", Uname=" + Uname + ", Password=" + Password + ", School=" + School
				+ ", Createtime=" + Createtime + ", Crname=" + Crname + ", Lv=" + Lv + ", phone=" + phone + "]";
	}
	
	

}
