package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Recruitinfo;
import cn.tedu.dao.ReDao;

public class ReService {
	
	public List<Recruitinfo> selectRecruitinfo(){
		
		ReDao re=new ReDao();
		List<Recruitinfo>list=re.select();
		return list;
		
	}
	
	public String insertRecruitinfo(Recruitinfo r) {
		
		ReDao re=new ReDao();
		int i=re.insertRecruitinfo(r);
		if(i!=0) {
			return "��ӳɹ�";
		}
		return "���ʧ��";
	}
	
	public Recruitinfo selectid(int id) {
		
		ReDao re=new ReDao();
		Recruitinfo list=re.selectid(id);
		return list;
	}
	
	public String updateRecruitinfo(Recruitinfo r) {
		
		ReDao re=new ReDao();
		int i=re.updateRecruitinfo(r);
		if(i!=0) {
			return "�޸ĳɹ�";
		}
		
		return "�޸�ʧ��";
	}
	
	public String deleteRecruitinfo(int id) {
		
		ReDao re=new ReDao();
		int i=re.deleteRecruitinfo(id);
		if(i!=0) {
			return "ɾ���ɹ�";
		}
		return "ɾ��ʧ��";
	}
	
	public List<Recruitinfo> selectlike(String pram){
		
		ReDao re=new ReDao();
		List<Recruitinfo> list=re.selectlike(pram);
		return list;
	}

}
