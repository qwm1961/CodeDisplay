package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Dynamic;
import cn.tedu.bean.Route;

import cn.tedu.dao.RouteDao;
import cn.tedu.dao.WorkDao;


public class RouteService {

	public String insertroute(Route a) {
		// TODO Auto-generated method stub
		RouteDao ad=new RouteDao();
		int i=ad.insertroute(a);
		if(i!=0) {
			return "增加成功";
		}
		return "增加失败";
	}
	


		


	public String deleteroute(int adid) {
		// TODO Auto-generated method stub
		
			
			RouteDao ad=new RouteDao();
			int i=ad.deleteadmin(adid);
			if(i!=0) {
				return "删除成功";
			}
			return "删除失败";
			
		}


	public List<Route> selectroute(String route) {
		// TODO Auto-generated method stub
		RouteDao a=new RouteDao();
		List<Route> list=a.selectname(route);
		return list;
		}






	public List<Route> selectname(String param) {
		// TODO Auto-generated method stub
		RouteDao ad=new RouteDao();
		List<Route> list=ad.selectname(param);
		return list;
	}






	public List<Route> selectee(String para) {
		// TODO Auto-generated method stub
		RouteDao ad=new RouteDao();
		List<Route> list=ad.selectee(para);
		return list;
	}






	
	
	
	
	}
	
	


