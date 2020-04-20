package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.Dynamic;
import cn.tedu.bean.Route;
import cn.tedu.util.DBTools;

public class RouteDao {

	public int insertroute(Route a) {
		// TODO Auto-generated method stub
		String sql="insert into route (Rname,CreateTime,Crname) values (?,?,?)";
		Object[] obj= {a.getRname(),a.getCreateTime(),a.getCrname()};
		int i=DBTools.update(sql, obj);
		return i;
	}
	

	
		


	public int deleteadmin(int adid) {
		// TODO Auto-generated method stub
		
			
			String sql="delete from route where id=?";
			Object[] obj= {adid};
			int i=DBTools.update(sql, obj);
	 		return i;
			
		}


	public List<Route> selectname(String name) {
		// TODO Auto-generated method stub
		String sql="select * from route";
		List<Route> list=DBTools.query(sql, Route.class);
		return list;
	}






	public List<Route> selectee(String para) {
		// TODO Auto-generated method stub
		String sql="select * FROM route WHERE Rname LIKE \"%\"?\"%\"";
		Object[] obj= {para};
		List<Route> list=DBTools.query(sql, Route.class, obj);
		return list;
	}

	}
	


