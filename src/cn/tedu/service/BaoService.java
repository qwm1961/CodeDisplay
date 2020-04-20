package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Baoming;
import cn.tedu.dao.BaoDao;

public class BaoService {
	
	public List<Baoming> selectbao(){
		
		BaoDao b=new BaoDao();
		List<Baoming> list=b.selectBao();
		return list;
		
	}

	public List<Baoming> selectname(String param) {
		
		BaoDao b=new BaoDao();
		List<Baoming> list=b.selectlike(param);
		return list;
	}
	
	public String insertBao(Baoming b) {
		
		BaoDao ba=new BaoDao();
		int i=ba.insertBao(b);
		if(i!=0) {
			return "报名成功";	
		}
		
		return "报名失败";
	}

}
