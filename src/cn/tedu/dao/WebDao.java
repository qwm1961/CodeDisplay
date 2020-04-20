package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.Dynamic;
import cn.tedu.bean.Needs;
import cn.tedu.bean.Recruitinfo;
import cn.tedu.bean.Route;
import cn.tedu.util.DBTools;

public class WebDao {
	
	public List<Recruitinfo> selectRecruitinfo(){
		
		String sql="select * from recruitinfo order by RcreateTime desc";
		List<Recruitinfo> list=DBTools.query(sql, Recruitinfo.class);
		return list;
		
	}
	
	public  Recruitinfo Recruitinfoselectid(int id) {
		
		String sql="select * from Recruitinfo where Id=?";
		Object[] obj= {id};
		List<Recruitinfo> list=DBTools.query(sql, Recruitinfo.class, obj);
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	public List<Route> selectRoute() {
		// TODO Auto-generated method stub
		String sql="select * from route";
		List<Route> list=DBTools.query(sql, Route.class);
		return list;
		
	}

	public Route selectid(int rid) {
		// TODO Auto-generated method stub
		String sql="select * from Route where Id=?";
		Object[] obj= {rid};
		List<Route> list=DBTools.query(sql, Route.class, obj);
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		
		
		return null;
	}
	
	public List<Needs> selectNeeds(){
			
			String sql="select * from needs order by Createtime desc";
			List<Needs> list=DBTools.query(sql, Needs.class);
			return list;
			
		}
	
	public List<Dynamic> selectDynamic() {
		// TODO Auto-generated method stub
		String sql="select * from dynamic";
		List<Dynamic> list=DBTools.query(sql, Dynamic.class);
		return list;
		
	
	}

	public Dynamic selectid1(int rid1) {
		// TODO Auto-generated method stub
		String sql="select * from Dynamic where Id=?";
		Object[] obj= {rid1};
		List<Dynamic> list=DBTools.query(sql, Dynamic.class, obj);
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		
		
		return null;
	}

}
