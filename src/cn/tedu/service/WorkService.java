package cn.tedu.service;


import java.util.List;

import cn.tedu.bean.Admin;
import cn.tedu.bean.Dynamic;
import cn.tedu.bean.Route;
import cn.tedu.dao.WorkDao;

public class WorkService {

	
		
	public String insertwork(Dynamic a){
		//System.out.println(a);
		WorkDao ad=new WorkDao();
		int i=ad.insertwork(a);
		if(i!=0) {
			return "发布成功";
		}
		return "发布失败";
	}

	public List<Dynamic> selectwork() {
		// TODO Auto-generated method stub
		WorkDao a=new WorkDao();
		List<Dynamic> list=a.selectDynamic();
		return list;}
//banji
	public Dynamic selectaid(int id) {
		WorkDao ad=new WorkDao();
		Dynamic list=ad.selectid(id);
		return list;
	}

	public int updateadmin(Dynamic a2) {
		// TODO Auto-generated method stub
//		System.out.println("+++++++"+a2+"+++++++");
		WorkDao ad=new WorkDao();
		int i=ad.updateadmin(a2);	
		return i;
	}
	public List<Dynamic> selectname(String name){
		WorkDao ad=new WorkDao();
		List<Dynamic> list=ad.selectname(name);
		return list;
	}

	public String deletedynamic(int id) {
		// TODO Auto-generated method stub
		WorkDao ad=new WorkDao();
		int i=ad.deletedynamic(id);
		if(i!=0) {
			return "删除成功";
		}
		return "删除失败";
		
	}

	
	}


