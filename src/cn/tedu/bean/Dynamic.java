package cn.tedu.bean;

public class Dynamic {
	private int Id;
	private String Title;
	private String Dinfomation;
	private String Dschool;
	private int Readnum;
	private String Dhistory;
	private String DcreateTime;
	private String Dname;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDinfomation() {
		return Dinfomation;
	}
	public void setDinfomation(String dinfomation) {
		Dinfomation = dinfomation;
	}
	public String getDschool() {
		return Dschool;
	}
	public void setDschool(String dschool) {
		Dschool = dschool;
	}
	public int getReadnum() {
		return Readnum;
	}
	public void setReadnum(int readnum) {
		Readnum = readnum;
	}
	public String getDhistory() {
		return Dhistory;
	}
	public void setDhistory(String dhistory) {
		Dhistory = dhistory;
	}
	public String getDcreateTime() {
		return DcreateTime;
	}
	public void setDcreateTime(String dcreateTime) {
		DcreateTime = dcreateTime;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public Dynamic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dynamic(int id, String title, String dinfomation, String dschool, int readnum, String dhistory,
			String dcreateTime, String dname) {
		super();
		this.Id = id;
		Title = title;
		Dinfomation = dinfomation;
		Dschool = dschool;
		Readnum = readnum;
		Dhistory = dhistory;
		DcreateTime = dcreateTime;
		Dname = dname;
	}
	@Override
	public String toString() {
		return "Dynamic [id=" + Id + ", Title=" + Title + ", Dinfomation=" + Dinfomation + ", Dschool=" + Dschool
				+ ", Readnum=" + Readnum + ", Dhistory=" + Dhistory + ", DcreateTime=" + DcreateTime + ", Dname="
				+ Dname + "]";
	}

}
