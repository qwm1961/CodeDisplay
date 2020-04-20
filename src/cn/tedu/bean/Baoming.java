package cn.tedu.bean;

public class Baoming {
	private int id;
	private String name;
	private String phone;
	private String qq;
	private String calssname;
	private String school;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getClassname() {
		return calssname;
	}
	public void setClassname(String classname) {
		this.calssname = classname;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Baoming() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Baoming(int id, String name, String phone, String qq, String classname, String school) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.qq = qq;
		this.calssname = classname;
		this.school = school;
	}
	@Override
	public String toString() {
		return "Baoming [id=" + id + ", name=" + name + ", phone=" + phone + ", qq=" + qq + ", classname=" + calssname
				+ ", school=" + school + "]";
	}
	

}
