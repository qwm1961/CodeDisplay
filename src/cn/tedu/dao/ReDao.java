package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.Recruitinfo;
import cn.tedu.util.DBTools;

public class ReDao {
	public List<Recruitinfo> select(){
		
		String sql="select * from recruitinfo";
		List<Recruitinfo> list=DBTools.query(sql, Recruitinfo.class);
		return list;
		
	}
	
	public int insertRecruitinfo(Recruitinfo r) {
		
		String sql="insert into recruitinfo (Title,Rschool,Rinfomation,RcreateTime,Rname) values (?,?,?,?,?)";
		Object[] obj= {r.getTitle(),r.getRschool(),r.getRinfomation(),r.getRcreateTime(),r.getRname()};
		int i=DBTools.update(sql, obj);
		return i;
		
	}
	
	public Recruitinfo selectid(int id) {
		
		String sql="select * from recruitinfo where Id=?";
		Object[] obj= {id};
		List<Recruitinfo> list=DBTools.query(sql, Recruitinfo.class, obj);
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	public int updateRecruitinfo(Recruitinfo r) {
		
		String sql="update recruitinfo set Title=?,Rschool=?,Rinfomation=?,RcreateTime=?,Rname=?  where Id=?";
		Object[] obj= {r.getTitle(),r.getRschool(),r.getRinfomation(),r.getRcreateTime(),r.getRname(),r.getId()};
		int i=DBTools.update(sql, obj);
		return i;
		
	}
	
	public int deleteRecruitinfo(int id) {
		String sql="delete from recruitinfo where Id=?";
		Object[] obj= {id};
		int i=DBTools.update(sql, obj);
		return i;
	}
	
	public List<Recruitinfo> selectlike(String pram){
		String sql="select * FROM recruitinfo WHERE Title LIKE \"%\"?\"%\"";
		Object[] obj= {pram};
		List<Recruitinfo> list=DBTools.query(sql, Recruitinfo.class, obj);
		return list;
	}

}
