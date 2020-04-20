package cn.tedu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.tedu.bean.Admin;

import cn.tedu.dao.AdminDao;


public class AdminService {
	//µÇÂ¼
	public Admin loginselect(Admin a,HttpSession session) {
		AdminDao adao=new AdminDao();
		Admin list=adao.loginselect(a);
		if(list==null) {
			return null;
		}
		if(a.getPassword().equals(list.getPassword())) {
			session.setAttribute("loginUser", list);
	    	return list;
	    }
		return null;
	}
	
	public List<Admin> selectadmin(){
		AdminDao a=new AdminDao();
		List<Admin> list=a.selectadmin();
		return list;
	}
	
	public String insertadmin(Admin a){
		AdminDao ad=new AdminDao();
		int i=ad.insertadmin(a);
		if(i!=0) {
			return "×¢²á³É¹¦";
		}
		return "×¢²áÊ§°Ü";
	}
	
	public Admin selectaid(int id) {
		AdminDao ad=new AdminDao();
		Admin list=ad.selectid(id);
		return list;
	}
	
	public int updateadmin(Admin a) {
		AdminDao ad=new AdminDao();
		int i=ad.updateadmin(a);	
		return i;
	}
	
	public List<Admin> selectname(String name){
		AdminDao ad=new AdminDao();
		List<Admin> list=ad.selectname(name);
		return list;
	}
	
	public String deleteadmin(int id) {
		
		AdminDao ad=new AdminDao();
		int i=ad.deleteadmin(id);
		if(i!=0) {
			return "É¾³ý³É¹¦";
		}
		return "É¾³ýÊ§°Ü";
		
	}
		

}
