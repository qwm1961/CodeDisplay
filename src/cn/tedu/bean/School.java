package cn.tedu.bean;

public class School {
	
	private int Sid;
	private String Sname;
	private int Nassistance;
	private int Gaid;
	private String Countent;
	private String History;
	
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getNassistance() {
		return Nassistance;
	}
	public void setNassistance(int nassistance) {
		Nassistance = nassistance;
	}
	public int getGaid() {
		return Gaid;
	}
	public void setGaid(int gaid) {
		Gaid = gaid;
	}
	public String getCountent() {
		return Countent;
	}
	public void setCountent(String countent) {
		Countent = countent;
	}
	public String getHistory() {
		return History;
	}
	public void setHistory(String history) {
		History = history;
	}
	
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}
	public School(int sid, String sname, int nassistance, int gaid, String countent, String history) {
		super();
		Sid = sid;
		Sname = sname;
		Nassistance = nassistance;
		Gaid = gaid;
		Countent = countent;
		History = history;
	}
	@Override
	public String toString() {
		return "School [Sid=" + Sid + ", Sname=" + Sname + ", Nassistance=" + Nassistance + ", Gaid=" + Gaid
				+ ", Countent=" + Countent + ", History=" + History + "]";
	}
	

}
