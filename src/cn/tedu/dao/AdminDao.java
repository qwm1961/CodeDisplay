package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.Admin;
import cn.tedu.util.DBTools;

public class AdminDao {
	
	public Admin loginselect(Admin a){
		//System.out.println(a.getUname());
		String sql="select * FROM admin WHERE Uname=?";
		String username=a.getUname();
		Object[] obj= {username};
		List <Admin> list=DBTools.query(sql, Admin.class, obj);
		//System.out.println(list);
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	public List<Admin> selectadmin(){
		String sql="select * from admin WHERE Lv>0";
		Object[] obj= {};
		List<Admin> list=DBTools.query(sql, Admin.class, obj);
		return list;
	}
	
	public int insertadmin(Admin a) {
		String sql="insert into admin (Uname,Password,School,Createtime,Crname,Lv,phone) values (?,?,?,?,?,?,?)";
		Object[] obj= {a.getUname(),a.getPassword(),a.getSchool(),a.getCreatetime(),a.getCrname(),a.getLv(),a.getPhone()};
		int i=DBTools.update(sql, obj);
		return i;
	}
	
	public Admin selectid(int id) {
		String sql="select * from admin where id=?";
		Object[] obj= {id};
		List<Admin> list=DBTools.query(sql, Admin.class, obj);
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	public int updateadmin(Admin a) {
		String sql="update admin set Uname=?,Lv=?,phone=? where id=?";
		Object[] obj= {a.getUname(),a.getLv(),a.getPhone(),a.getId()};
		//System.out.println(a.getUname()+"----"+a.getLv()+"----"+a.getPhone()+"----"+a.getId());
		int i=DBTools.update(sql, obj);
		return i;
	}
	
	public List<Admin> selectname(String name){
		String sql="select * FROM admin WHERE Uname LIKE \"%\"?\"%\"";
		Object[] obj= {name};
		List<Admin> list=DBTools.query(sql, Admin.class, obj);
		return list;
	}
	
	public int deleteadmin(int id) {
		
		String sql="delete from admin where id=?";
		Object[] obj= {id};
		int i=DBTools.update(sql, obj);
 		return i;
		
	}

}
