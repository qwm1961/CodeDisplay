package cn.tedu.bean;

public class Needs {
	
	private int Id;
	private String Title;
	private int State;
	private String Nschool;
	private int Readnum;
	private String Information;
	private String Crname;
	private String Createtime;
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
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	public String getNschool() {
		return Nschool;
	}
	public void setNschool(String nschool) {
		Nschool = nschool;
	}
	public int getReadnum() {
		return Readnum;
	}
	public void setReadnum(int readnum) {
		Readnum = readnum;
	}
	public String getInformation() {
		return Information;
	}
	public void setInformation(String information) {
		Information = information;
	}
	public String getCrname() {
		return Crname;
	}
	public void setCrname(String crname) {
		Crname = crname;
	}
	public String getCreatetime() {
		return Createtime;
	}
	public void setCreatetime(String createtime) {
		Createtime = createtime;
	}
	
	public Needs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Needs(int id, String title, int state, String nschool, int readnum, String information, String crname) {
		super();
		Id = id;
		Title = title;
		State = state;
		Nschool = nschool;
		Readnum = readnum;
		Information = information;
		Crname = crname;
	}
	@Override
	public String toString() {
		return "Needs [Id=" + Id + ", Title=" + Title + ", State=" + State + ", Nschool=" + Nschool + ", Readnum="
				+ Readnum + ", Information=" + Information + ", Crname=" + Crname + "]";
	}
	

}
