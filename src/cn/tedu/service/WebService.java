package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Dynamic;
import cn.tedu.bean.Needs;
import cn.tedu.bean.Recruitinfo;
import cn.tedu.bean.Route;
import cn.tedu.dao.WebDao;

public class WebService {
	
	public List<Recruitinfo> selectRecruitinfo(){
		
		WebDao web=new WebDao();
		List<Recruitinfo> list=web.selectRecruitinfo();
		return list;
	}
	
	public Recruitinfo Recruitinfoselectid(int id) {
		
		WebDao web=new WebDao();
		Recruitinfo list=web.Recruitinfoselectid(id);
		return list;
	}
	
	public List<Route> selectRoute() {
		// TODO Auto-generated method stub
		WebDao web=new WebDao();
		List<Route> list=web.selectRoute();
		return list;
	}
	

	public Route selectid(int rid) {
		// TODO Auto-generated method stub
		WebDao web=new WebDao();
		Route list=web.selectid(rid);
		return list;
	}
	
	public List<Needs> selectNeeds(){
		
		WebDao web=new WebDao();
		List<Needs> list=web.selectNeeds();
		return list;
		
	}
	
	public List<Dynamic> selectDynamic() {
		// TODO Auto-generated method stub
		WebDao web=new WebDao();
		List<Dynamic> list=web.selectDynamic();
		return list;
	
	}


	public Dynamic selectid1(int rid1) {
		// TODO Auto-generated method stub
		WebDao web=new WebDao();
		Dynamic list=web.selectid1(rid1);
		return list;
	}
}
