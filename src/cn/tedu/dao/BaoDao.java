package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.Baoming;
import cn.tedu.bean.Needs;
import cn.tedu.util.DBTools;

public class BaoDao {
	
	public List<Baoming> selectBao(){
		
		String sql="select * from baoming";
		List<Baoming> list=DBTools.query(sql, Baoming.class);
		return list;
	}
	
	public List<Baoming> selectlike(String param){
		
		String sql="select * FROM baoming WHERE name LIKE \"%\"?\"%\"";
		Object[] obj= {param};
		List<Baoming> list=DBTools.query(sql, Baoming.class, obj);
		return list;
	}
	
	public int insertBao(Baoming b) {
		
		String sql="insert into baoming (name,phone,qq,calssname,school) values (?,?,?,?,?)";
		Object[] obj= {b.getName(),b.getPhone(),b.getQq(),b.getClassname(),b.getSchool()};
		int i=DBTools.update(sql, obj);
		return i;
	}
	

}
