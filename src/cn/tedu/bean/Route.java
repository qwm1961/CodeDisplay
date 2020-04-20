package cn.tedu.bean;

public class Route {
	private int Id;
	private String Rname;
	private String CreateTime;
	private String Crname;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getRname() {
		return Rname;
	}
	public void setRname(String rname) {
		Rname = rname;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getCrname() {
		return Crname;
	}
	public void setCrname(String crname) {
		Crname = crname;
	}
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Route(int id, String rname, String createTime, String crname) {
		super();
		Id = id;
		Rname = rname;
		CreateTime = createTime;
		Crname = crname;
	}
	@Override
	public String toString() {
		return "Route [Id=" + Id + ", Rname=" + Rname + ", CreateTime=" + CreateTime + ", Crname=" + Crname + "]";
	}
	

}
