package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Page;
import cn.tedu.bean.School;
import cn.tedu.dao.SchoolDao;

public class SchoolService {
	/**
	 * 查询所有学校
	 */
	public List<School> findAllSchoolByPage(){
		SchoolDao schoolDao = new SchoolDao();
		List<School> list = schoolDao.findSchoolByPage();
		return list;
	}
	
	
	public String add(School school) {
		SchoolDao schoolDao = new SchoolDao();
		int n = schoolDao.insert(school);
				
		if(n > 0) {
			return "添加成功";
		}
		
		return "添加失败";
	}
	
	public String editSchool(School school3){
		SchoolDao schoolDao = new SchoolDao();
		int n = schoolDao.editSchoolById(school3,school3.getSid());
					
			if(n > 0) {
				return "修改成功";
			}
			
			return "修改失败";
		}
	
	public School selectSid(int id) {
		SchoolDao sd=new SchoolDao();
		School list = sd.selectid(id);
		//System.out.println(list);
		return list;
	}
	
	public String deleteSid(int id) {
		SchoolDao sd2 = new SchoolDao();
		int n = sd2.deleteid(id);
		if(n == 0) {
			return "删除失败";
		}
		return "删除成功";
	}


	public List<School> selectSchool(String name) {
		SchoolDao sd3 = new SchoolDao();
		List<School> list = sd3.selectSchool(name);
		return list;
	}


	public List<School> selectNedSchool() {
		SchoolDao sd4 = new SchoolDao();
		List<School> list = sd4.selectNedSchool();
		return list;
	}
	
	
	
	
}
