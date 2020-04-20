package cn.tedu.dao;


import java.util.List;

import cn.tedu.bean.Admin;
import cn.tedu.bean.Dynamic;
import cn.tedu.util.DBTools;

public class WorkDao {

	
	public List<Dynamic> selectDynamic(){
		String sql="select * from dynamic";
		Object[] obj= {};
		List<Dynamic> list=DBTools.query(sql, Dynamic.class, obj);
		return list;
	}
	
	public int insertwork(Dynamic a) {
		// TODO Auto-generated method stub
			String sql="insert into dynamic (Title,Dhistory,Dinfomation,DcreateTime,Dname) values (?,?,?,?,?)";
			Object[] obj= {a.getTitle(),a.getDhistory(),a.getDinfomation(),a.getDcreateTime(),a.getDname()};
			int i=DBTools.update(sql, obj);
			return i;
		}



	public Dynamic selectid(int id) {
		// TODO Auto-generated method stub
		String sql="select * from dynamic where id=?";
		Object[] obj= {id};
		List<Dynamic> list=DBTools.query(sql, Dynamic.class, obj);
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	
	}

	public int updateadmin(Dynamic a2) {
		// TODO Auto-generated method stub
		//System.out.println(a2);
		String sql="update dynamic set Title=?,Dhistory=?,Dinfomation=? where Id=?";
		Object[] obj= {a2.getTitle(),a2.getDhistory() ,a2.getDinfomation(),a2.getId()};
//		System.out.println(a2.getTitle()+"----"+a2.getDhistory()+"----"+a2.getDinfomation()+"----"+a2.getId());
		
		int i=DBTools.update(sql, obj);
		//System.out.println(i);
		return i;
	}

	

	public List<Dynamic> selectname(String name) {
		// TODO Auto-generated method stub
		String sql="select * FROM dynamic WHERE Title LIKE \"%\"?\"%\"";
		Object[] obj= {name};
		List<Dynamic> list=DBTools.query(sql, Dynamic.class, obj);
		return list;
	}

	public int deletedynamic(int id) {
		// TODO Auto-generated method stub
			String sql="delete from dynamic where id=?";
			Object[] obj= {id};
			int i=DBTools.update(sql, obj);
	 		return i;
			
		}
	}
	
	
	
	


