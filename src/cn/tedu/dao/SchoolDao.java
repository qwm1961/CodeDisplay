package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.School;
import cn.tedu.util.DBTools;

public class SchoolDao {
	/**
	 * 分页查询所有学校
	 */
	public List<School> findSchoolByPage(){
		String sql = "select * from school";
		List<School> list = DBTools.query(sql, School.class);
		
		return list;
	}
	
	/**
	 * 新增学校
	 */
	public int insert(School school) {
		String sql="insert into school (Sname, Nassistance, Gaid, Countent, History) values (?,?,?,?,?)";
		Object[] obj = {school.getSname(),school.getNassistance(),school.getGaid(),school.getCountent(),school.getHistory()};
		int n = DBTools.update(sql, obj);
		return n;
		
	}
	
	
	/**
	 * 编辑学校
	 */
	public int editSchoolById(School school,int id) {
		String sql = "update school set Sname = ?,Nassistance = ?,Gaid = ?, Countent = ?,History = ? where Sid = ?";
		Object[] obj = {school.getSname(),school.getNassistance(),school.getGaid(),school.getCountent(),school.getHistory(),school.getSid()};
		int n = DBTools.update(sql, obj);
		return n;
	}
	
	/**
	 * 根据id查找对应学校
	 */
	public School selectid(int id) {
		String sql="select * from school where Sid=?";
		Object[] obj= {id};
		List<School> list=DBTools.query(sql, School.class, obj);
		//System.out.println(list);
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 删除学校
	 */
	public int deleteid(int id) {
		String sql="delete from school where Sid=?";
		Object[] obj= {id};
		int n = DBTools.update(sql, obj);
		return n;
		
		
	}

	public List<School> selectSchool(String name) {
		String sql = "select * from school where Sname like\"%\"?\"%\"";
		Object[] obj = {name};
		List<School> list = DBTools.query(sql, School.class, obj);
		return list;
	}
	/**
	 * 需求添加里面需要查询学校
	 * @return
	 */
	public List<School> selectNedSchool() {
		String sql = "select * from school";
		List<School> list = DBTools.query(sql, School.class);
		return list;
	}
	
}
