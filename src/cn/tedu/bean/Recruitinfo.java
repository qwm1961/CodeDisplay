package cn.tedu.bean;

public class Recruitinfo {
	private int Id;
	private String Title;
	private String Rschool;
	private String Rinfomation;
	private int Readnum;
	private String RcreateTime;
	private String Rname;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getRschool() {
		return Rschool;
	}
	public void setRschool(String rschool) {
		Rschool = rschool;
	}
	public String getRinfomation() {
		return Rinfomation;
	}
	public void setRinfomation(String rinfomation) {
		Rinfomation = rinfomation;
	}
	public int getReadnum() {
		return Readnum;
	}
	public void setReadnum(int readnum) {
		Readnum = readnum;
	}
	public String getRcreateTime() {
		return RcreateTime;
	}
	public void setRcreateTime(String rcreateTime) {
		RcreateTime = rcreateTime;
	}
	public String getRname() {
		return Rname;
	}
	public void setRname(String rname) {
		Rname = rname;
	}
	public Recruitinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recruitinfo(int id, String title, String rschool, String rinfomation, int readnum, String rcreateTime,
			String rname) {
		super();
		Id = id;
		Title = title;
		Rschool = rschool;
		Rinfomation = rinfomation;
		Readnum = readnum;
		RcreateTime = rcreateTime;
		Rname = rname;
	}
	@Override
	public String toString() {
		return "Recruitinfo [Id=" + Id + ", Title=" + Title + ", Rschool=" + Rschool + ", Rinfomation=" + Rinfomation
				+ ", Readnum=" + Readnum + ", RcreateTime=" + RcreateTime + ", Rname=" + Rname + "]";
	}

}
